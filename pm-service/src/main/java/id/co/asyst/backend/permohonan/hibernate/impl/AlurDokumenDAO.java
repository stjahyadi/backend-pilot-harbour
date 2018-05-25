package id.co.asyst.backend.permohonan.hibernate.impl;

import javax.ejb.Local;

import id.co.asyst.backend.permohonan.hibernate.model.AlurDokumen;

@Local
public interface AlurDokumenDAO {
	public void saveAlurDokument(AlurDokumen alurDokumen);
}
