package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.Local;

import id.co.asyst.backend.permohonan.hibernate.model.PermohonanNomor;

@Local
public interface PermohonanNomorDAO {

	public void savePermohonanNomor(PermohonanNomor entity);

	/**
	 * To get permohonan nomor filtered by kdBukti, kdCabang and periode
	 * @param kdBukti
	 * @param kdCabang
	 * @param periode
	 * @return
	 */
	public PermohonanNomor getPermohonanNomorWithFilters(String kdBukti, Integer kdCabang, String periode);
	
	/**
	 * To get permohonan nomor filtered by kdBukti, kdCabang, periode and kdAktif
	 * @param kdBukti
	 * @param kdCabang
	 * @param periode
	 * @param kdAktif
	 * @return
	 */
	public PermohonanNomor getPermohonanNomorWithKdAktifAndFilters(String kdBukti, Integer kdCabang, String periode, String kdAktif);
}
