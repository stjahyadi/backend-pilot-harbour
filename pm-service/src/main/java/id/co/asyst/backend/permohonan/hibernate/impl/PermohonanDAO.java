package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.Local;

import id.co.asyst.backend.permohonan.hibernate.model.Permohonan;

@Local
public interface PermohonanDAO {
	public void savePermohonanMuat(Permohonan entity);
	
	public Permohonan findPermohonanWithNoPmhBm(String noPmhBm);
}
