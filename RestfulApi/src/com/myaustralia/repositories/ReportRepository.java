package com.myaustralia.repositories;

import java.util.ArrayList;
import java.util.List;

import com.myaustralia.beans.*;
import com.myaustralia.common.Adapter;
import com.myaustralia.common.JsonHelper;
import com.myaustralia.dao.DAO;
import com.myaustralia.vo.VOReport;

public class ReportRepository {
	
	public String getReports(String authority) {
		
		BeanReport beanReport = new BeanReport();
		List<BeanReport> beanReports = new ArrayList<>();
		if (authority.equals("Admin")) {
			beanReports = new DAO().query(beanReport.getClass(), "select ReportId reportId, UserId userId, Time time, Route route, PriorityId priorityId, RelevantDepartment relevantDepartment, Description description, StreetNumber streetNumber, Locality locality, ReportStageId reportStageId, ReportStatusId reportStatusId from report");
		} else {
			beanReports = new DAO().query(beanReport.getClass(), "select ReportId reportId, UserId userId, Time time, Route route, PriorityId priorityId, RelevantDepartment relevantDepartment, Description description, StreetNumber streetNumber, Locality locality, ReportStageId reportStageId, ReportStatusId reportStatusId from report where RelevantDepartment=?", authority);
		}
		List<VOReport> voReports = Adapter.beanReportsToVOReports(beanReports);
		
		return JsonHelper.parseToJsonWithRoot(voReports);
	}

	public void create(VOReport voReport) {

		BeanReport beanReport = Adapter.voReportToBeanReport(voReport);
		new DAO().update("insert into report(ReportId,UserId,Time,Route,PriorityId,RelevantDepartment,Description,StreetNumber,Locality,ReportStageId,ReportStatusId) values (?,?,?,?,?,?,?,?,?,?,?)", String.valueOf(beanReport.getReportId()), beanReport.getUserId(), beanReport.getTime().toString(), beanReport.getRoute(), String.valueOf(beanReport.getPriorityId()), beanReport.getRelevantDepartment(), beanReport.getDescription(), beanReport.getStreetNumber(), beanReport.getLocality(), String.valueOf(beanReport.getReportStageId()), String.valueOf(beanReport.getReportStatusId()));
	}
	
	public void update(VOReport voReport) {
	
		BeanReport beanReport = Adapter.voReportToBeanReport(voReport);
		new DAO().update("update report set UserId=?, Route=?, Time=?, PriorityId=?, RelevantDepartment=?, Description=?, StreetNumber=?, Locality=?, ReportStageId=?, ReportStatusId=? where ReportId=?", beanReport.getUserId(), beanReport.getRoute(), beanReport.getTime().toString(), String.valueOf(beanReport.getPriorityId()), beanReport.getRelevantDepartment(), beanReport.getDescription(), beanReport.getStreetNumber(), beanReport.getLocality(), String.valueOf(beanReport.getReportStageId()), String.valueOf(beanReport.getReportStatusId()), String.valueOf(beanReport.getReportId()));
	}

	public void delete(String id) {
		new DAO().update("delete from report where ReportId = ?", id);
	}
	
}