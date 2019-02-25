package com.myaustralia.repositories;

import java.util.ArrayList;
import java.util.List;
import com.myaustralia.common.Adapter;
import com.myaustralia.common.JsonHelper;
import com.myaustralia.dao.DAO;
import com.myaustralia.entities.*;
import com.myaustralia.models.ModelReport;

public class ReportRepository {
	
	public String getReports(String authority) {
		
		EntityReport entityReport = new EntityReport();
		List<EntityReport> entityReports = new ArrayList<>();
		if (authority.equals("Admin")) {
			entityReports = new DAO().query(entityReport.getClass(), "select ReportId reportId, UserId userId, Time time, Route route, PriorityId priorityId, RelevantDepartment relevantDepartment, Description description, StreetNumber streetNumber, Locality locality, ReportStageId reportStageId, ReportStatusId reportStatusId from report");
		} else {
			entityReports = new DAO().query(entityReport.getClass(), "select ReportId reportId, UserId userId, Time time, Route route, PriorityId priorityId, RelevantDepartment relevantDepartment, Description description, StreetNumber streetNumber, Locality locality, ReportStageId reportStageId, ReportStatusId reportStatusId from report where RelevantDepartment=?", authority);
		}
		List<ModelReport> modelReports = Adapter.entityReportsToModelReports(entityReports);
		
		return JsonHelper.parseToJsonWithRoot(modelReports);
	}

	public void create(ModelReport report) {

		EntityReport entityReport = Adapter.modelReportToEntityReport(report);
		new DAO().update("insert into report(ReportId,UserId,Time,Route,PriorityId,RelevantDepartment,Description,StreetNumber,Locality,ReportStageId,ReportStatusId) values (?,?,?,?,?,?,?,?,?,?,?)", String.valueOf(entityReport.getReportId()), entityReport.getUserId(), entityReport.getTime().toString(), entityReport.getRoute(), String.valueOf(entityReport.getPriorityId()), entityReport.getRelevantDepartment(), entityReport.getDescription(), entityReport.getStreetNumber(), entityReport.getLocality(), String.valueOf(entityReport.getReportStageId()), String.valueOf(entityReport.getReportStatusId()));
	}
	
	public void update(ModelReport report) {
	
		EntityReport entityReport = Adapter.modelReportToEntityReport(report);
		new DAO().update("update report set UserId=?, Route=?, Time=?, PriorityId=?, RelevantDepartment=?, Description=?, StreetNumber=?, Locality=?, ReportStageId=?, ReportStatusId=? where ReportId=?", entityReport.getUserId(), entityReport.getRoute(), entityReport.getTime().toString(), String.valueOf(entityReport.getPriorityId()), entityReport.getRelevantDepartment(), entityReport.getDescription(), entityReport.getStreetNumber(), entityReport.getLocality(), String.valueOf(entityReport.getReportStageId()), String.valueOf(entityReport.getReportStatusId()), String.valueOf(entityReport.getReportId()));
	}

	public void delete(String id) {
		new DAO().update("delete from report where ReportId = ?", id);
	}
	
}