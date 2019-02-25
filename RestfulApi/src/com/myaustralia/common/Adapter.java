package com.myaustralia.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.myaustralia.entities.EntityReport;
import com.myaustralia.models.ModelReport;

public class Adapter {

	public static List<ModelReport> entityReportsToModelReports(List<EntityReport> entityReports) {
		
		List<ModelReport> modelReports = new ArrayList<>();
		
		for (EntityReport entityReport : entityReports) {
			ModelReport modelReport = new ModelReport();
			modelReport.setReportId(entityReport.getReportId());
			modelReport.setUserId(entityReport.getUserId());
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String tsStr = sdf.format(entityReport.getTime());
			modelReport.setDate(tsStr.substring(0, 10));
			modelReport.setTime(tsStr.substring(11, 19));
			
			modelReport.setRoute(entityReport.getRoute());
			modelReport.setPriority(Dictionary.getValueFromKey("priorityDic", entityReport.getPriorityId()));
			modelReport.setRelevantDepartment(entityReport.getRelevantDepartment());
			modelReport.setDescription(entityReport.getDescription());
			modelReport.setStreetNumber(entityReport.getStreetNumber());
			modelReport.setLocality(entityReport.getLocality());
			modelReport.setReportStage(Dictionary.getValueFromKey("reportStageDic", entityReport.getReportStageId()));
			modelReport.setReportStatus(Dictionary.getValueFromKey("reportStatusDic", entityReport.getReportStatusId()));
			
			modelReports.add(modelReport);
		} 
		return modelReports;
	}
	
	
	public static EntityReport modelReportToEntityReport(ModelReport modelReport) {
		
		EntityReport entityReport = new EntityReport();
		entityReport.setReportId(modelReport.getReportId());
		entityReport.setUserId(modelReport.getUserId());
		
		String tsStr = modelReport.getDate() + " " + modelReport.getTime();
		Timestamp ts = Timestamp.valueOf(tsStr);
		entityReport.setTime(ts);
		
		entityReport.setRoute(modelReport.getRoute());
		entityReport.setPriorityId(Dictionary.getKeyFromValue("priorityDic", modelReport.getPriority()));
		entityReport.setRelevantDepartment(modelReport.getRelevantDepartment());
		entityReport.setDescription(modelReport.getDescription());
		entityReport.setStreetNumber(modelReport.getStreetNumber());
		entityReport.setLocality(modelReport.getLocality());
		entityReport.setReportStageId(Dictionary.getKeyFromValue("reportStageDic", modelReport.getReportStage()));
		entityReport.setReportStatusId(Dictionary.getKeyFromValue("reportStatusDic", modelReport.getReportStatus()));
		
		return entityReport;
	}
	
}