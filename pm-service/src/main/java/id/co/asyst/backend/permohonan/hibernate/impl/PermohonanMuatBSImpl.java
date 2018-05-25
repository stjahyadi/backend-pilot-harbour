package id.co.asyst.backend.permohonan.hibernate.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.asyst.backend.common.CommonUtil;
import id.co.asyst.backend.common.DateUtil;
import id.co.asyst.backend.permohonan.hibernate.model.AlurDokumen;
import id.co.asyst.backend.permohonan.hibernate.model.Permohonan;
import id.co.asyst.backend.permohonan.hibernate.model.PermohonanDetail;
import id.co.asyst.backend.permohonan.hibernate.model.PermohonanDetailPK;
import id.co.asyst.backend.permohonan.hibernate.model.PermohonanNomor;
import id.co.asyst.backend.permohonan.hibernate.model.PermohonanNomorPK;
import id.co.asyst.backend.permohonan.hibernate.model.PermohonanPK;

@Stateful
public class PermohonanMuatBSImpl implements PermohonanMuatBSDAO {

	private static Logger LOG = Logger.getLogger(PermohonanMuatBSImpl.class);

	@PersistenceContext(unitName = "GENC")
	private EntityManager emGenc;

	@PersistenceContext(unitName = "VIEWDATA")
	private EntityManager emViewData;

	@Inject
	private PermohonanDAO permohonanDAO;

	@Inject
	private PermohonanNomorDAO permohonanNomorDAO;

	@Inject
	private AlurDokumenDAO alurDokumenDAO;

	@Inject
	private PermohonanDetailDAO permohonanDetailDAO;

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public String processPermohonanMuat(String input, Integer logId) throws Exception {
		String result = null;

		JSONObject jsonObj = new JSONObject(input);
		String jsonDescStr = jsonObj.get("json_desc").toString();
		Map<String, Object> inputMap = new ObjectMapper().readValue(input, HashMap.class);

		Map<String, String> jsonDesc = new ObjectMapper().readValue(jsonDescStr, HashMap.class);

		String creationBy = String.valueOf(inputMap.get("creation_by"));
		String programName = String.valueOf(inputMap.get("program_name"));

		Integer kdCabang = Integer.valueOf(jsonDesc.get("KdCabang"));
		String kdTerminal = jsonDesc.get("KdTerminal");
		String ppkb1Nomor = jsonDesc.get("Ppkb1Nomor");
		String pbm = jsonDesc.get("Pbm");
		Date tanggal = DateUtil.getCurentDate();
		String actCode = "MUAT";
		String statusPermohonan = "OPEN";
		Integer totalManifest = null;
		Boolean editable = Integer.valueOf(jsonDesc.get("isEditable")) == 0 ? false : true;

		String codeCust = getKodeKust(kdCabang, pbm);
		String noPmhBm = null;
		if (!editable) {
			// #################################################
			// Insert to TOSGCT_PMH
			noPmhBm = getKodeGenc(kdCabang, "PMHBKR", tanggal, creationBy);
			PermohonanPK pk = new PermohonanPK();
			pk.setKdTerminal(kdTerminal);
			pk.setNoPmhBm(noPmhBm);
			Permohonan permohonan = new Permohonan();
			permohonan.setPk(pk);
			permohonan.setTotalManifest(totalManifest);
			permohonan.setKdCabang(kdCabang);
			permohonan.setPpkb1Nomor(ppkb1Nomor);
			permohonan.setNoPmhBm(noPmhBm);
			permohonan.setPbm(pbm);
			permohonan.setTanggal(tanggal);
			permohonan.setActCode(actCode);
			permohonan.setStatus(statusPermohonan);
			permohonan.setCreationDate(DateUtil.getCurentDate());
			permohonan.setCreationBy(creationBy);
			permohonan.setProgramName(programName);
			permohonan.setLogId(logId);
			permohonanDAO.savePermohonanMuat(permohonan);

			// #################################################
			// Insert to Alur Dokumen
			String kapal = null;// TODO::To extract logic from FUNC_GETKAPAL_3
			AlurDokumen alurDokumen = new AlurDokumen();
			alurDokumen.setIsEndWork(-1);
			alurDokumen.setNoPpk(ppkb1Nomor);
			alurDokumen.setKegiatan(actCode);
			alurDokumen.setKdCabang(String.valueOf(kdCabang));
			alurDokumen.setKdTerminal(kdTerminal);
			alurDokumen.setKapal(kapal);
			alurDokumen.setTanggalPmh(tanggal);
			alurDokumen.setNoPpb(noPmhBm);
			alurDokumen.setPbm(codeCust);
			alurDokumen.setStsPlan(0);
			alurDokumen.setStsEpb(0);
			alurDokumen.setStsBpjk(0);
			alurDokumen.setStsSpmk(0);
			alurDokumen.setStsKegiatan(0);
			alurDokumen.setStsPranota(0);
			alurDokumen.setStsNota(0);
			alurDokumen.setActCode(actCode);
			alurDokumen.setKdPbm(pbm);
			alurDokumenDAO.saveAlurDokument(alurDokumen);
			result = "Success - " + noPmhBm;
		} else {
			// #################################################
			// Update TOSGCT_PMH
			noPmhBm = jsonDesc.get("NoPmhBm");
			Permohonan permohonan = permohonanDAO.findPermohonanWithNoPmhBm(noPmhBm);
			result = "Update";
		}

		JSONObject jsonObjPmhD = new JSONObject(jsonDescStr);
		JSONArray pmhD = jsonObjPmhD.getJSONArray("pmh_d");
		// #################################################
		// Looping to insert into TOSGCT_PMH_D
		for (int i = 0; i < pmhD.length(); i++) {
			JSONObject obj = pmhD.getJSONObject(i);
			PermohonanDetailPK detailPK = new PermohonanDetailPK();
			detailPK.setNoSeq(i + 1);
			detailPK.setNoPmhBm(noPmhBm);

			PermohonanDetail detail = new PermohonanDetail();
			detail.setPk(detailPK);
			detail.setKdCabang(kdCabang);
			detail.setKdTerminal(kdTerminal);
			detail.setMbrgKode(obj.get("MbrgKode").toString());
			detail.setKdSatuan(obj.get("KdSatuan").toString());
			detail.setMbrgSifat(obj.get("MbrgSifat").toString());
			detail.setMbrgKemasan(obj.get("MbrgKemasan").toString());
			detail.setJumlah(new BigDecimal(obj.get("Jumlah").toString()));
			detail.setKdPortAsal(obj.get("PortAsalTujuan").toString());
			detail.setCreationDate(DateUtil.getCurentDate());
			detail.setCreationBy(creationBy);
			detail.setProgramName(programName);
			permohonanDetailDAO.savePermohonanDetail(detail);

		}

		// #################################################
		// Looping to insert into TOSGCT_LAMPIRAN_DOK

		// #################################################
		// update status and error message at tabel LOG_TRANS

		return result;
	}

	private String getKodeGenc(Integer kdCabang, String kdBukti, Date tgl, String creationBy) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(tgl);
		String periode = String.valueOf(cal.get(Calendar.YEAR));
		return gencCreateNomor(kdCabang, kdBukti, periode, creationBy);
	}

	private String gencCreateNomor(Integer kdCabang, String kdBukti, String periode, String creationBy) {
		String tahunBuku = getTahunBuku(kdCabang, kdBukti);
		if (tahunBuku == null) {
			LOG.error("No Data found to get tahun buku with following parameters kdBukti=" + kdBukti + ", kdCabang="
					+ kdCabang);
			return null;
		}

		if (tahunBuku != null) {
			if (Integer.valueOf(periode) >= Integer.valueOf(tahunBuku)) {
				PermohonanNomor old = permohonanNomorDAO.getPermohonanNomorWithFilters(kdBukti, kdCabang, periode);
				Calendar cal = Calendar.getInstance();
				Date tanggal = new Date(cal.getTime().getTime());
				PermohonanNomor pn = new PermohonanNomor();
				PermohonanNomorPK pk = new PermohonanNomorPK();
				String user = creationBy;
				String kdAktif = "A";

				pk.setKdCabang(old.getKdCabang());
				pk.setKdTerminal(old.getKdTerminal());
				pk.setKdBukti(old.getKdBukti());
				pk.setKdPeriode(periode);

				pn.setPk(pk);
				pn.setKetBukti(old.getKetBukti());
				pn.setAwalan(old.getAwalan());
				pn.setNoStart(1);
				pn.setNoStop(old.getNoStop());
				pn.setNoDipakai(0);
				pn.setKdAktif(kdAktif);
				pn.setLastUpdateDate(tanggal);
				pn.setLastUpdateBy(user);
				pn.setProgramName("GET_KODE");
				pn.setCreationDate(tanggal);
				pn.setCreationBy(user);

				PermohonanNomor oldAktif = permohonanNomorDAO.getPermohonanNomorWithKdAktifAndFilters(kdBukti, kdCabang,
						periode, kdAktif);
				if (oldAktif == null) {
					LOG.error("Definisi Kode Untuk Modul Ini Belum Ada di KBBR_NO_NOTA, Hubungi Administrator ... !");
					return null;
				}

				Integer noStopAktif = oldAktif.getNoStop();
				Integer kdUrut = CommonUtil.nvl(old.getNoDipakai(), old.getNoStart() - 1) + 1;
				String kdUrutStr = null;
				if (kdUrut > oldAktif.getNoStop()) {
					noStopAktif = kdUrut;
				}
				Integer bulan = cal.get(Calendar.MONTH) + 1;
				kdUrutStr = oldAktif.getAwalan() + "" + kdCabang + ""
						+ CommonUtil.lpad(String.valueOf(kdUrut), String.valueOf(noStopAktif).length(), "0");
				if ("GATEINJO".equalsIgnoreCase(kdBukti) || "NOTALLY".equalsIgnoreCase(kdBukti)) {
					kdUrutStr = String.valueOf(kdUrut);
				} else {
					kdUrutStr = kdUrutStr + "/" + bulan + "" + periode.substring(2);
				}

				old.setNoDipakai(CommonUtil.nvl(old.getNoDipakai(), old.getNoStart() - 1) + 1);
				old.setNoStop(noStopAktif);
				return kdUrutStr;
			}
		}
		return null;
	}

	private String getKodeKust(Integer kdCabang, String kdKus) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT MPLG_NAMA ");
		sql.append(" FROM V_MASTER_PELANGGAN ");
		sql.append(" WHERE MPLG_KODE = :kd_kus AND KD_CABANG = :kd_cab");
		String customerName = emViewData.createNativeQuery(sql.toString()).setParameter("kd_kus", kdKus)
				.setParameter("kd_cab", kdCabang).getSingleResult().toString();
		return customerName;
	}

	private String getTahunBuku(Integer kdCabang, String kdBukti) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT KD_PERIODE  ");
		sql.append("FROM TOSGCM_NOMOR ");
		sql.append("WHERE KD_PERIODE = (SELECT MAX(kd_periode) ");
		sql.append("                    FROM TOSGCM_NOMOR ");
		sql.append("                    WHERE kd_bukti = :kd_bukti1 and kd_cabang = :kd_cabang1) ");
		sql.append("    and kd_cabang = :kd_cabang2 ");
		sql.append("    AND kd_bukti = :kd_bukti2 ");
		// sql.append(" AND kd_bukti = :kd_bukti FOR UPDATE nowait; ");
		Query q = emGenc.createNativeQuery(sql.toString());
		q.setParameter("kd_bukti1", kdBukti);
		q.setParameter("kd_cabang1", kdCabang);

		q.setParameter("kd_bukti2", kdBukti);
		q.setParameter("kd_cabang2", kdCabang);
		String data = q.getSingleResult().toString();
		return data;
	}

}
