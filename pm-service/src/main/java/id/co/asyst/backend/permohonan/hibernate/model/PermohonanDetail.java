package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TOSGCT_PMH_D", uniqueConstraints = @UniqueConstraint(columnNames = { "NO_SEQ", "NO_PMH_BM", "KD_CABANG", "KD_TERMINAL" }))
public class PermohonanDetail implements Serializable{
	
	public PermohonanDetailPK getPk() {
		return pk;
	}

	public void setPk(PermohonanDetailPK pk) {
		this.pk = pk;
	}

	public Integer getKdCabang() {
		return kdCabang;
	}

	public void setKdCabang(Integer kdCabang) {
		this.kdCabang = kdCabang;
	}

	public String getKdTerminal() {
		return kdTerminal;
	}

	public void setKdTerminal(String kdTerminal) {
		this.kdTerminal = kdTerminal;
	}

	public String getMbrgKode() {
		return mbrgKode;
	}

	public void setMbrgKode(String mbrgKode) {
		this.mbrgKode = mbrgKode;
	}

	public String getKdSatuan() {
		return kdSatuan;
	}

	public void setKdSatuan(String kdSatuan) {
		this.kdSatuan = kdSatuan;
	}

	public BigDecimal getJumlah() {
		return jumlah;
	}

	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}

	public String getMbrgSifat() {
		return mbrgSifat;
	}

	public void setMbrgSifat(String mbrgSifat) {
		this.mbrgSifat = mbrgSifat;
	}

	public String getMbrgKemasan() {
		return mbrgKemasan;
	}

	public void setMbrgKemasan(String mbrgKemasan) {
		this.mbrgKemasan = mbrgKemasan;
	}

	public Date getTglRencanaTmpk() {
		return tglRencanaTmpk;
	}

	public void setTglRencanaTmpk(Date tglRencanaTmpk) {
		this.tglRencanaTmpk = tglRencanaTmpk;
	}

	public String getMglapKode() {
		return mglapKode;
	}

	public void setMglapKode(String mglapKode) {
		this.mglapKode = mglapKode;
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

	public BigDecimal getJumlah1() {
		return jumlah1;
	}

	public void setJumlah1(BigDecimal jumlah1) {
		this.jumlah1 = jumlah1;
	}

	public String getKdPortAsal() {
		return kdPortAsal;
	}

	public void setKdPortAsal(String kdPortAsal) {
		this.kdPortAsal = kdPortAsal;
	}

	public Integer getJumlah2() {
		return jumlah2;
	}

	public void setJumlah2(Integer jumlah2) {
		this.jumlah2 = jumlah2;
	}

	private static final long serialVersionUID = -6438661432641391028L;

	@EmbeddedId
	private PermohonanDetailPK pk;
	
	@NotNull
	@Column(name="KD_CABANG")
	private Integer kdCabang;
	
	@NotNull
	@Column(name="KD_TERMINAL")   
	private String kdTerminal;
	
	@NotNull
	@Column(name="MBRG_KODE")  
	private String mbrgKode;
	
	@Column(name="KD_SATUAN")
	private String kdSatuan;
	
	@Column(name="JUMLAH")  
	private BigDecimal jumlah;
	
	@Column(name="MBRG_SIFAT")   
	private String mbrgSifat;
	
	@Column(name="MBRG_KEMASAN")  
	private String mbrgKemasan;
	
	@Column(name="TGL_RENCANA_TMPK")
	private Date tglRencanaTmpk;
	
	@Column(name="MGLAP_KODE")
	private String mglapKode;
	
	@Column(name="KETERANGAN")
	private String keterangan;
	
	@NotNull
	@Column(name="CREATION_DATE")       
	private Date creationDate;
	
	@NotNull
	@Column(name="CREATION_BY")  
	private String creationBy;
	
	@Column(name="LAST_UPDATE_DATE")          
	private Date lastUpdateDate;
	
	@Column(name="LAST_UPDATE_BY")
	private String lastUpdateBy;
	
	@NotNull
	@Column(name="PROGRAM_NAME")  
	private String programName;
	
	@Column(name="JUMLAH1")
	private BigDecimal jumlah1;
	
	@Column(name="KD_PORT_ASAL")
	private String kdPortAsal;
	
	@Column(name="JUMLAH2")
	private Integer jumlah2;
}
