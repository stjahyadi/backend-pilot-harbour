package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PermohonanLampiranDokumenPK implements Serializable {
	
	private static final long serialVersionUID = -8202171372036306140L;

	@NotNull
	@Column(name = "KD_CABANG")
	private Integer kdCabang;

	@NotNull
	@Column(name = "KD_TERMINAL")
	private String kdTerminal;

	@Column(name = "NO_REF_TRANS")
	private String noRefTrans;

	@Column(name = "NO_SEQ")
	private Integer noSeq;

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

	public String getNoRefTrans() {
		return noRefTrans;
	}

	public void setNoRefTrans(String noRefTrans) {
		this.noRefTrans = noRefTrans;
	}

	public Integer getNoSeq() {
		return noSeq;
	}

	public void setNoSeq(Integer noSeq) {
		this.noSeq = noSeq;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PermohonanLampiranDokumenPK))
			return false;
		PermohonanLampiranDokumenPK that = (PermohonanLampiranDokumenPK) o;
		return Objects.equals(getKdCabang(), that.getKdCabang())
				&& Objects.equals(getKdTerminal(), that.getKdTerminal())
				&& Objects.equals(getNoRefTrans(), that.getNoRefTrans())
				&& Objects.equals(getNoSeq(), that.getNoSeq());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getKdCabang(), getKdTerminal(), getNoRefTrans(), getNoSeq());
	}
}
