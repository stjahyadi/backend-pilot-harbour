package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "findPermohonanWithNoPmhBm", query = "SELECT c FROM Permohonan c WHERE c.pk.noPmhBm = :noPmhBm")
@Table(name = "TOSGCT_PMH", uniqueConstraints = @UniqueConstraint(columnNames = { "ID", "KD_CABANG", "KD_TERMINAL" }))
public class Permohonan implements Serializable {

	private static final long serialVersionUID = -7931025981045227098L;

	@Column(name = "TOTAL_MANIFEST")
	private Integer totalManifest;
	
	@EmbeddedId
	private PermohonanPK pk;

	@NotNull
	@Column(name = "KD_CABANG")
	private Integer kdCabang;
	
	@Column(name = "PPKB1_NOMOR")
	private String ppkb1Nomor;

	@Column(name = "PBM")
	private String pbm;

	@NotNull
	@Column(name = "TANGGAL")
	private Date tanggal;

	@NotNull
	@Column(name = "ACT_CODE")
	private String actCode;

	@Column(name = "NO_BC")
	private String noBc;

	@Column(name = "TGL_BC")
	private Date tglBc;

	@Column(name = "KETERANGAN")
	private String keterangan;

	@Column(name = "STATUS")
	private String status;

	@NotNull
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@NotNull
	@Column(name = "CREATION_BY")
	private String creationBy;

	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "LAST_UPDATE_BY")
	private String lastUpdateBy;

	@NotNull
	@Column(name = "PROGRAM_NAME")
	private String programName;

	@NotNull
	@Column(name = "LOG_ID")
	private Integer logId;

	@Column(name = "NO_REF")
	private String noRef;

	@Column(name = "TGL_REF")
	private Date tglRef;

	@Column(name = "NO_SPK")
	private String noSpk;

	@Column(name = "TGL_SPK")
	private Date tglSpk;

	@Column(name = "KD_TUMPUK")
	private String kdTumpuk;

	@Column(name = "KD_KAPAL")
	private String kdKapal;

	@Column(name = "KD_TERTAGIH")
	private String kdTertagih;

	public Integer getTotalManifest() {
		return totalManifest;
	}

	public void setTotalManifest(Integer totalManifest) {
		this.totalManifest = totalManifest;
	}
	
	public PermohonanPK getPk() {
		return pk;
	}
	
	public void setPk(PermohonanPK pk) {
		this.pk = pk;
	}

	public Integer getId() {
		return pk.getId();
	}

	public void setId(Integer id) {
		this.pk.setId(id);
	}

	public Integer getKdCabang() {
		return kdCabang;
	}

	public void setKdCabang(Integer kdCabang) {
		this.kdCabang = kdCabang;
	}

	public String getKdTerminal() {
		return pk.getKdTerminal();
	}

	public void setKdTerminal(String kdTerminal) {
		this.pk.setKdTerminal(kdTerminal);
	}

	public String getPpkb1Nomor() {
		return ppkb1Nomor;
	}

	public void setPpkb1Nomor(String ppkb1Nomor) {
		this.ppkb1Nomor = ppkb1Nomor;
	}

	public String getNoPmhBm() {
		return pk.getNoPmhBm();
	}

	public void setNoPmhBm(String noPmhBm) {
		this.pk.setNoPmhBm(noPmhBm);
	}

	public String getPbm() {
		return pbm;
	}

	public void setPbm(String pbm) {
		this.pbm = pbm;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getNoBc() {
		return noBc;
	}

	public void setNoBc(String noBc) {
		this.noBc = noBc;
	}

	public Date getTglBc() {
		return tglBc;
	}

	public void setTglBc(Date tglBc) {
		this.tglBc = tglBc;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationBy() {
		return creationBy;
	}

	public void setCreationBy(String creationBy) {
		this.creationBy = creationBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getNoRef() {
		return noRef;
	}

	public void setNoRef(String noRef) {
		this.noRef = noRef;
	}

	public Date getTglRef() {
		return tglRef;
	}

	public void setTglRef(Date tglRef) {
		this.tglRef = tglRef;
	}

	public String getNoSpk() {
		return noSpk;
	}

	public void setNoSpk(String noSpk) {
		this.noSpk = noSpk;
	}

	public Date getTglSpk() {
		return tglSpk;
	}

	public void setTglSpk(Date tglSpk) {
		this.tglSpk = tglSpk;
	}

	public String getKdTumpuk() {
		return kdTumpuk;
	}

	public void setKdTumpuk(String kdTumpuk) {
		this.kdTumpuk = kdTumpuk;
	}

	public String getKdKapal() {
		return kdKapal;
	}

	public void setKdKapal(String kdKapal) {
		this.kdKapal = kdKapal;
	}

	public String getKdTertagih() {
		return kdTertagih;
	}

	public void setKdTertagih(String kdTertagih) {
		this.kdTertagih = kdTertagih;
	}

}
