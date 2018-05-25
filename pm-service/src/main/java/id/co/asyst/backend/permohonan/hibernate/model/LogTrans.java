package id.co.asyst.backend.permohonan.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LOG_TRANS", uniqueConstraints = @UniqueConstraint(columnNames = "LOG_ID"))
public class LogTrans implements Serializable{

	private static final long serialVersionUID = 1123528484701474976L;

	@NotNull
	@Id
	@Column(name = "LOG_ID")
	private Integer logId;

	@NotNull
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@NotNull
	@Column(name = "CREATION_BY")
	private String creationBy;

	@NotNull
	@Column(name = "APPLICATION_ID")
	private Integer applicationId;

	@NotNull
	@Column(name = "PROGRAM_NAME")
	private String programName;

	@NotNull
	@Column(name = "MODULE_NAME")
	private String moduleName;

	@NotNull
	@Column(name = "STATUS")
	private String status;

	@Column(name = "LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name = "LAST_UPDATE_BY")
	private String lastUpdateBy;

	@Column(name = "JSON_DESC")
	private String jsonDesc;

	@Column(name = "MESSAGES")
	private String messages;

	@Column(name = "PARAM_CODE")
	private String paramCode;

	@Column(name = "PREV_LOG_ID")
	private Integer prevLogId;

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationBy() {
		return creationBy;
	}

	public void setCreationBy(String creationBy) {
		this.creationBy = creationBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getJsonDesc() {
		return jsonDesc;
	}

	public void setJsonDesc(String jsonDesc) {
		this.jsonDesc = jsonDesc;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public Integer getPrevLogId() {
		return prevLogId;
	}

	public void setPrevLogId(Integer prevLogId) {
		this.prevLogId = prevLogId;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	
}
