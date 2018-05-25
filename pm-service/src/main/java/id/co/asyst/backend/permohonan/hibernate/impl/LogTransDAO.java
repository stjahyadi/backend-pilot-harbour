package id.co.asyst.backend.permohonan.hibernate.impl;


import javax.ejb.Local;

import id.co.asyst.backend.permohonan.hibernate.model.LogTrans;

@Local
public interface LogTransDAO {
	public LogTrans saveLogTrans(String inputMap) throws Exception;
}
