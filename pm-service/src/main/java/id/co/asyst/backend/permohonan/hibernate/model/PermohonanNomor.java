package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
		@NamedQuery(name = "findPermohonanNomorWithFilters", query = "SELECT c FROM PermohonanNomor c WHERE c.pk.kdBukti = :kd_bukti AND c.pk.kdPeriode = :thn_buku AND c.pk.kdCabang = :kd_cabang"),
		@NamedQuery(name = "findPermohonanNomorWithKdAktifAndFilters", query = "SELECT c FROM PermohonanNomor c WHERE c.pk.kdBukti = :kd_bukti AND c.pk.kdPeriode = :thn_buku and c.pk.kdCabang = :kd_cabang and c.kdAktif = :kd_aktif") })
@Table(name = "TOSGCM_NOMOR", uniqueConstraints = @UniqueConstraint(columnNames = { "KD_PERIODE", "KD_CABANG",
		"KD_TERMINAL", "KD_BUKTI" }))
public class PermohonanNomor implements Serializable {

	private static final long serialVersionUID = -3268062600058232154L;
	@EmbeddedId
	private PermohonanNomorPK pk;

	@Column(name = "KET_BUKTI")
	private String ketBukti;

	@Column(name = "AWALAN")
	private String awalan;

	@NotNull
	@Column(name = "NO_START")
	private Integer noStart;

	@NotNull
	@Column(name = "NO_STOP")
	private Integer noStop;

	@NotNull
	@Column(name = "NO_DIPAKAI")
	private Integer noDipakai;

	@NotNull
	@Column(name = "KD_AKTIF")
	private String kdAktif;

	@NotNull
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@NotNull
	@Column(name = "CREATION_BY")
	private String creationBy;

	@NotNull
	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@NotNull
	@Column(name = "LAST_UPDATE_BY")
	private String lastUpdateBy;

	@NotNull
	@Column(name = "PROGRAM_NAME")
	private String programName;

	public PermohonanNomorPK getPk() {
		return pk;
	}

	public void setPk(PermohonanNomorPK pk) {
		this.pk = pk;
	}

	public String getKetBukti() {
		return ketBukti;
	}

	public void setKetBukti(String ketBukti) {
		this.ketBukti = ketBukti;
	}

	public String getAwalan() {
		return awalan;
	}

	public void setAwalan(String awalan) {
		this.awalan = awalan;
	}

	public Integer getNoStart() {
		return noStart;
	}

	public void setNoStart(Integer noStart) {
		this.noStart = noStart;
	}

	public Integer getNoStop() {
		return noStop;
	}

	public void setNoStop(Integer noStop) {
		this.noStop = noStop;
	}

	public Integer getNoDipakai() {
		return noDipakai;
	}

	public void setNoDipakai(Integer noDipakai) {
		this.noDipakai = noDipakai;
	}

	public String getKdAktif() {
		return kdAktif;
	}

	public void setKdAktif(String kdAktif) {
		this.kdAktif = kdAktif;
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

	public Integer getKdCabang() {
		return pk.getKdCabang();
	}

	public Integer getKdTerminal() {
		return pk.getKdTerminal();
	}

	public String getKdBukti() {
		return pk.getKdBukti();
	}

	public String getKdPeriode() {
		return pk.getKdPeriode();
	}

}
