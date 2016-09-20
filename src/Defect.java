package teamc;

public class Defect {
	private String application;	
	private String assignee;
	private Integer defectName;	
	private String description;
	private String priority;
	private String status;	
	private String summary;
	

	//Constructor	

	public Defect(String application, String assignee, Integer defectName,
			String description, String priority, String status, String summary) {
		this.application = application;
		this.assignee = assignee;
		this.defectName = defectName;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.summary = summary;
	}

	public Defect() {}
	
	//Getters and setters

	public String getapplication() {
		return application;
	}

	public void setapplication(String application) {
		this.application = application;
	}

	public Integer getDefectName() {
		return defectName;
	}

	public void setDefectName(Integer defectName) {
		this.defectName = defectName;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public void Copy(Defect defect) {
		application = defect.application;
		defectName = defect.defectName;
		summary = defect.summary;
		status = defect.status;
		priority = defect.priority;
		assignee = defect.assignee;
		description = defect.description;
	}

	@Override
	public String toString() {
		return "Defect [application=" + application + ", defectName=" + defectName
				+ ", summary=" + summary + ", status=" + status + ", priority="
				+ priority + ", assignee=" + assignee + ", description="
				+ description + "]";
	}
}