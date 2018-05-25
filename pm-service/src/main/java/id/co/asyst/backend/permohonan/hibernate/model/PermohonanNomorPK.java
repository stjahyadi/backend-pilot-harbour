package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PermohonanNomorPK implements Serializable{

	private static final long serialVersionUID = 8909701320053077776L;

	@NotNull
	@Column(name="KD_CABANG")    
	private Integer kdCabang;
	
	@NotNull
	@Column(name="KD_TERMINAL")
	private Integer kdTerminal;
	
	@NotNull
	@Column(name="KD_BUKTI")
	private String kdBukti;
	
	@NotNull
	@Column(name="KD_PERIODE")
	private String kdPeriode;

	public Integer getKdCabang() {
		return kdCabang;
	}

	public void setKdCabang(Integer kdCabang) {
		this.kdCabang = kdCabang;
	}

	public Integer getKdTerminal() {
		return kdTerminal;
	}

	public void setKdTerminal(Integer kdTerminal) {
		this.kdTerminal = kdTerminal;
	}

	public String getKdBukti() {
		return kdBukti;
	}

	public void setKdBukti(String kdBukti) {
		this.kdBukti = kdBukti;
	}

	public String getKdPeriode() {
		return kdPeriode;
	}

	public void setKdPeriode(String kdPeriode) {
		this.kdPeriode = kdPeriode;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PermohonanNomorPK))
			return false;
		PermohonanNomorPK that = (PermohonanNomorPK) o;
		return Objects.equals(getKdCabang(), that.getKdCabang())
				&& Objects.equals(getKdBukti(), that.getKdBukti())
				&& Objects.equals(getKdPeriode(), that.getKdPeriode())
				&& Objects.equals(getKdTerminal(), that.getKdTerminal());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getKdCabang(), getKdBukti(), getKdPeriode(), getKdTerminal());
	}
}
