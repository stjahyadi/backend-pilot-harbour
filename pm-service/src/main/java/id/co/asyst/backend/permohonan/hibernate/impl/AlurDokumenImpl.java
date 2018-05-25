package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import id.co.asyst.backend.permohonan.hibernate.model.AlurDokumen;

@Stateful
public class AlurDokumenImpl implements AlurDokumenDAO{
	
	@PersistenceContext(unitName = "GENC")
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void saveAlurDokument(AlurDokumen alurDokumen) {
		em.persist(alurDokumen);
	}

}
