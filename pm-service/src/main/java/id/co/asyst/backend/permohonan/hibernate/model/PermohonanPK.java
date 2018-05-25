package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PermohonanPK implements Serializable {
	private static final long serialVersionUID = -7728797806323732243L;

	@NotNull
	@Column(name = "ID")
	private Integer id;

	@NotNull
	@Column(name = "KD_TERMINAL")
	private String kdTerminal;

	@NotNull
	@Column(name = "NO_PMH_BM")
	private String noPmhBm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKdTerminal() {
		return kdTerminal;
	}

	public void setKdTerminal(String kdTerminal) {
		this.kdTerminal = kdTerminal;
	}

	public String getNoPmhBm() {
		return noPmhBm;
	}

	public void setNoPmhBm(String noPmhBm) {
		this.noPmhBm = noPmhBm;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PermohonanPK))
			return false;
		PermohonanPK that = (PermohonanPK) o;
		return Objects.equals(getId(), that.getId())
				&& Objects.equals(getKdTerminal(), that.getKdTerminal())
				&& Objects.equals(getNoPmhBm(), that.getNoPmhBm());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getKdTerminal(), getNoPmhBm());
	}

}
