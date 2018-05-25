package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import id.co.asyst.backend.permohonan.hibernate.model.Permohonan;

@Stateful
public class PermohonanImpl implements PermohonanDAO {

	@PersistenceContext(unitName = "GENC")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void savePermohonanMuat(Permohonan entity) {
		em.merge(entity);
	}

	@Override
	public Permohonan findPermohonanWithNoPmhBm(String noPmhBm) {
		return em.createNamedQuery("findPermohonanWithNoPmhBm", Permohonan.class).setParameter("noPmhBm", noPmhBm).getSingleResult();
	}

}
