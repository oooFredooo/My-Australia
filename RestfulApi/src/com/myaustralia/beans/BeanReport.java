package com.myaustralia.beans;

import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanReport {
	
	private int reportId;
	private String userId;
	private Timestamp time;
	private String route;
	private int priorityId;
	private String relevantDepartment;
	private String description;
	private String streetNumber;
	private String locality;
	private int reportStageId;
	private int reportStatusId;
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}
	public String getRelevantDepartment() {
		return relevantDepartment;
	}
	public void setRelevantDepartment(String relevantDepartment) {
		this.relevantDepartment = relevantDepartment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public int getReportStageId() {
		return reportStageId;
	}
	public void setReportStageId(int reportStageId) {
		this.reportStageId = reportStageId;
	}
	public int getReportStatusId() {
		return reportStatusId;
	}
	public void setReportStatusId(int reportStatusId) {
		this.reportStatusId = reportStatusId;
	}

}