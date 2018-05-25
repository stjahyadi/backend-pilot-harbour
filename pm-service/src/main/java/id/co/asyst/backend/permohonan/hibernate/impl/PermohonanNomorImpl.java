package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import id.co.asyst.backend.permohonan.hibernate.model.PermohonanNomor;

@Stateful
public class PermohonanNomorImpl implements PermohonanNomorDAO {

	@PersistenceContext(unitName = "GENC")
	private EntityManager em;

	@Override
	public void savePermohonanNomor(PermohonanNomor entity) {
		em.persist(entity);
	}

	@Override
	public PermohonanNomor getPermohonanNomorWithFilters(String kdBukti, Integer kdCabang, String periode) {
		PermohonanNomor obj = em.createNamedQuery("findPermohonanNomorWithFilters", PermohonanNomor.class)
				.setParameter("kd_bukti", kdBukti).setParameter("kd_cabang", kdCabang).setParameter("thn_buku", periode)
				.getSingleResult();
		return obj;
	}

	@Override
	public PermohonanNomor getPermohonanNomorWithKdAktifAndFilters(String kdBukti, Integer kdCabang, String periode,
			String kdAktif) {
		PermohonanNomor obj = em.createNamedQuery("findPermohonanNomorWithKdAktifAndFilters", PermohonanNomor.class)
				.setParameter("kd_bukti", kdBukti).setParameter("kd_cabang", kdCabang).setParameter("thn_buku", periode)
				.setParameter("kd_aktif", kdAktif).getSingleResult();
		return obj;
	}

}
