package id.co.asyst.backend.permohonan.hibernate.impl;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface PermohonanMuatBSDAO {
	public String processPermohonanMuat(String input, Integer logId) throws Exception;
}
