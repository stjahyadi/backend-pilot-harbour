package id.co.asyst.backend.permohonan.hibernate.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.asyst.backend.common.DateUtil;
import id.co.asyst.backend.permohonan.hibernate.model.LogTrans;

@Stateful
public class LogTransImpl implements LogTransDAO {

	@PersistenceContext(unitName = "GENC")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	@Override
	public LogTrans saveLogTrans(String input) throws Exception {
		JSONObject jsonObj = new JSONObject(input);
		String jsonDesc = jsonObj.get("json_desc").toString();
		Map<String, Object> inputMap = new ObjectMapper().readValue(input, HashMap.class);

		Integer applicationId = Integer.valueOf((String) inputMap.get("application_id"));
		String creationBy = String.valueOf(inputMap.get("creation_by"));
		String programName = String.valueOf(inputMap.get("program_name"));
		String moduleName = String.valueOf(inputMap.get("module_name"));
		String paramCode = String.valueOf(inputMap.get("param_code"));
		String status = "N";
		Integer logId = getLogId();
		LogTrans logTrans = new LogTrans();
		logTrans.setLogId(logId);
		logTrans.setCreationBy(creationBy);
		logTrans.setCreationDate(DateUtil.getCurentDate());
		logTrans.setApplicationId(applicationId);
		logTrans.setProgramName(programName);
		logTrans.setModuleName(moduleName);
		logTrans.setJsonDesc(jsonDesc);
		logTrans.setParamCode(paramCode);
		logTrans.setStatus(status);
		em.persist(logTrans);
		return logTrans;
	}

	private synchronized Integer getLogId() {
		Integer logId = Integer
				.valueOf(em.createNativeQuery("SELECT LOG_TRANS_SEQ.NEXTVAL FROM dual").getSingleResult().toString());
		return logId;
	}

}
