package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "findAlurDokWithFilters", query = "SELECT c FROM AlurDokumen c WHERE c.kdCabang = :kdCabang AND kdTerminal = :kdTerminal AND noPpk = :noPpk and actCode = :actCode")
@Table(name = "TOSGCT_REP_ALURDOK", uniqueConstraints = @UniqueConstraint(columnNames = "ID_H"))
public class AlurDokumen implements Serializable {

	private static final long serialVersionUID = 8906115840440841455L;
	@NotNull
	@Column(name = "NO_PPK")
	private String noPpk;

	@NotNull
	@Column(name = "KEGIATAN")
	private String kegiatan;

	@NotNull
	@Column(name = "KD_CABANG")
	private String kdCabang;

	@NotNull
	@Column(name = "KD_TERMINAL")
	private String kdTerminal;

	@Column(name = "KAPAL")
	private String kapal;

	@Column(name = "TANGGAL_PMH")
	private Date tanggalPmh;

	@Column(name = "NO_PPB")
	private String noPpb;

	@Column(name = "PBM")
	private String pbm;

	@Column(name = "STS_PLAN")
	private Integer stsPlan;

	@Column(name = "STS_EPB")
	private Integer stsEpb;

	@Column(name = "STS_BPJK")
	private Integer stsBpjk;

	@Column(name = "STS_SPMK")
	private Integer stsSpmk;

	@Column(name = "STS_KEGIATAN")
	private Integer stsKegiatan;

	@Column(name = "STS_PRANOTA")
	private Integer stsPranota;

	@Column(name = "STS_NOTA")
	private Integer stsNota;

	@Column(name = "ACT_CODE")
	private String actCode;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REP_ALURDOK")
	@SequenceGenerator(name = "REP_ALURDOK", sequenceName = "REP_ALURDOK", allocationSize = 1)
	@NotNull
	@Column(name = "ID_H")
	private Integer idH;

	@Column(name = "KD_PBM")
	private String kdPbm;

	@Column(name = "IS_ENDWORK")
	private Integer isEndWork;

	public String getNoPpk() {
		return noPpk;
	}

	public void setNoPpk(String noPpk) {
		this.noPpk = noPpk;
	}

	public String getKegiatan() {
		return kegiatan;
	}

	public void setKegiatan(String kegiatan) {
		this.kegiatan = kegiatan;
	}

	public String getKdCabang() {
		return kdCabang;
	}

	public void setKdCabang(String kdCabang) {
		this.kdCabang = kdCabang;
	}

	public String getKdTerminal() {
		return kdTerminal;
	}

	public void setKdTerminal(String kdTerminal) {
		this.kdTerminal = kdTerminal;
	}

	public String getKapal() {
		return kapal;
	}

	public void setKapal(String kapal) {
		this.kapal = kapal;
	}

	public Date getTanggalPmh() {
		return tanggalPmh;
	}

	public void setTanggalPmh(Date tanggalPmh) {
		this.tanggalPmh = tanggalPmh;
	}

	public String getNoPpb() {
		return noPpb;
	}

	public void setNoPpb(String noPpb) {
		this.noPpb = noPpb;
	}

	public String getPbm() {
		return pbm;
	}

	public void setPbm(String pbm) {
		this.pbm = pbm;
	}

	public Integer getStsPlan() {
		return stsPlan;
	}

	public void setStsPlan(Integer stsPlan) {
		this.stsPlan = stsPlan;
	}

	public Integer getStsEpb() {
		return stsEpb;
	}

	public void setStsEpb(Integer stsEpb) {
		this.stsEpb = stsEpb;
	}

	public Integer getStsBpjk() {
		return stsBpjk;
	}

	public void setStsBpjk(Integer stsBpjk) {
		this.stsBpjk = stsBpjk;
	}

	public Integer getStsSpmk() {
		return stsSpmk;
	}

	public void setStsSpmk(Integer stsSpmk) {
		this.stsSpmk = stsSpmk;
	}

	public Integer getStsKegiatan() {
		return stsKegiatan;
	}

	public void setStsKegiatan(Integer stsKegiatan) {
		this.stsKegiatan = stsKegiatan;
	}

	public Integer getStsPranota() {
		return stsPranota;
	}

	public void setStsPranota(Integer stsPranota) {
		this.stsPranota = stsPranota;
	}

	public Integer getStsNota() {
		return stsNota;
	}

	public void setStsNota(Integer stsNota) {
		this.stsNota = stsNota;
	}

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public Integer getIdH() {
		return idH;
	}

	public void setIdH(Integer idH) {
		this.idH = idH;
	}

	public String getKdPbm() {
		return kdPbm;
	}

	public void setKdPbm(String kdPbm) {
		this.kdPbm = kdPbm;
	}

	public Integer getIsEndWork() {
		return isEndWork;
	}

	public void setIsEndWork(Integer isEndWork) {
		this.isEndWork = isEndWork;
	}
}
