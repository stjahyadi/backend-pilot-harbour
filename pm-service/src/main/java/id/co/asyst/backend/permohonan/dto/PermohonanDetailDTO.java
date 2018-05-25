package id.co.asyst.backend.permohonan.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class PermohonanDetailDTO implements Serializable {
	private static final long serialVersionUID = 8830726265050440453L;
	private Integer noSeq;
	private String mbrgKode;
	private String kdSatuan;
	private String mbrgSifat;
	private String mbrgKemasan;
	private String portAsalTujuan;
	private BigDecimal jumlah;

	public Integer getNoSeq() {
		return noSeq;
	}

	public void setNoSeq(Integer noSeq) {
		this.noSeq = noSeq;
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

	public String getPortAsalTujuan() {
		return portAsalTujuan;
	}

	public void setPortAsalTujuan(String portAsalTujuan) {
		this.portAsalTujuan = portAsalTujuan;
	}

	public BigDecimal getJumlah() {
		return jumlah;
	}

	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}
}
