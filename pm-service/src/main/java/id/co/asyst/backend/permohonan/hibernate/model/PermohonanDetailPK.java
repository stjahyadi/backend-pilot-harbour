package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PermohonanDetailPK implements Serializable {

	private static final long serialVersionUID = 8280274593382354483L;

	@NotNull
	@Column(name = "ID")
	private Integer id;

	@NotNull
	@Column(name = "NO_PMH_BM")
	private String noPmhBm;

	@NotNull
	@Column(name = "NO_SEQ")
	private Integer noSeq;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoPmhBm() {
		return noPmhBm;
	}

	public void setNoPmhBm(String noPmhBm) {
		this.noPmhBm = noPmhBm;
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
		if (!(o instanceof PermohonanDetailPK))
			return false;
		PermohonanDetailPK that = (PermohonanDetailPK) o;
		return Objects.equals(getId(), that.getId())
				&& Objects.equals(getNoSeq(), that.getNoSeq())
				&& Objects.equals(getNoPmhBm(), that.getNoPmhBm());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getNoSeq(), getNoPmhBm());
	}
	

}
