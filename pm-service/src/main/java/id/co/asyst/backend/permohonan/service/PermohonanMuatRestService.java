package id.co.asyst.backend.permohonan.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import id.co.asyst.backend.permohonan.hibernate.impl.LogTransDAO;
import id.co.asyst.backend.permohonan.hibernate.impl.PermohonanMuatBSDAO;
import id.co.asyst.backend.permohonan.hibernate.model.LogTrans;

@Path("/")
public class PermohonanMuatRestService {
	
	@Inject
    private PermohonanMuatBSDAO permohohanMuatBSDAO;
	
	@Inject
	private LogTransDAO logTransDAO;
	
	@POST
    @Path("savePermohonanMuat")
    @Consumes({"application/json"})
    public Response savePermohonanMuat(String inputMap) throws Exception {
		LogTrans logTrans = logTransDAO.saveLogTrans(inputMap);
    	String output = permohohanMuatBSDAO.processPermohonanMuat(inputMap, logTrans.getLogId());
		return Response.ok(output).build();
    }
	
}
