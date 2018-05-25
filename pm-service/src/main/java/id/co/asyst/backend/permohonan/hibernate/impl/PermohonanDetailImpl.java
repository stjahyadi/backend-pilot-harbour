package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import id.co.asyst.backend.permohonan.hibernate.model.PermohonanDetail;

public class PermohonanDetailImpl implements PermohonanDetailDAO {
	@PersistenceContext(unitName = "GENC")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void savePermohonanDetail(PermohonanDetail permohonanDetail) {
		em.merge(permohonanDetail);
	}

}
