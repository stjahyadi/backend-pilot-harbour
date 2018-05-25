package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TOSGCT_LAMPIRAN_DOK", uniqueConstraints = @UniqueConstraint(columnNames = { "ID" }))
public class PermohonanLampiranDokumen implements Serializable {

	private static final long serialVersionUID = -6467390053705926975L;

	@Column(name = "ID")
	private Integer id;

	@EmbeddedId
	private PermohonanLampiranDokumenPK pk;

	@NotNull
	@Column(name = "KD_DOK")
	private String kdDok;

	@Column(name = "TGL_DOK")
	private Date tglDok;

	@Column(name = "NOMOR_DOK")
	private String nomorDok;

	@Column(name = "KETERANGAN")
	private String keterangan;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKdCabang() {
		return pk.getKdCabang();
	}

	public void setKdCabang(Integer kdCabang) {
		this.pk.setKdCabang(kdCabang);
	}

	public String getKdTerminal() {
		return pk.getKdTerminal();
	}

	public void setKdTerminal(String kdTerminal) {
		this.pk.setKdTerminal(kdTerminal);
	}

	public String getNoRefTrans() {
		return pk.getNoRefTrans();
	}

	public void setNoRefTrans(String noRefTrans) {
		this.pk.setNoRefTrans(noRefTrans);
	}

	public Integer getNoSeq() {
		return pk.getNoSeq();
	}

	public void setNoSeq(Integer noSeq) {
		this.pk.setNoSeq(noSeq);
	}

	public String getKdDok() {
		return kdDok;
	}

	public void setKdDok(String kdDok) {
		this.kdDok = kdDok;
	}

	public Date getTglDok() {
		return tglDok;
	}

	public void setTglDok(Date tglDok) {
		this.tglDok = tglDok;
	}

	public String getNomorDok() {
		return nomorDok;
	}

	public void setNomorDok(String nomorDok) {
		this.nomorDok = nomorDok;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
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

}
