package com.myaustralia.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.myaustralia.beans.BeanReport;
import com.myaustralia.vo.VOReport;

public class Adapter {

	public static List<VOReport> beanReportsToVOReports(List<BeanReport> beanReports) {
		
		List<VOReport> voReports = new ArrayList<>();
		
		for (BeanReport beanReport : beanReports) {
			VOReport voReport = new VOReport();
			voReport.setReportId(beanReport.getReportId());
			voReport.setUserId(beanReport.getUserId());
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String tsStr = sdf.format(beanReport.getTime());
			voReport.setDate(tsStr.substring(0, 10));
			voReport.setTime(tsStr.substring(11, 19));
			
			voReport.setRoute(beanReport.getRoute());
			voReport.setPriority(Dictionary.getValueFromKey("priorityDic", beanReport.getPriorityId()));
			voReport.setRelevantDepartment(beanReport.getRelevantDepartment());
			voReport.setDescription(beanReport.getDescription());
			voReport.setStreetNumber(beanReport.getStreetNumber());
			voReport.setLocality(beanReport.getLocality());
			voReport.setReportStage(Dictionary.getValueFromKey("reportStageDic", beanReport.getReportStageId()));
			voReport.setReportStatus(Dictionary.getValueFromKey("reportStatusDic", beanReport.getReportStatusId()));
			
			voReports.add(voReport);
		} 
		return voReports;
	}
	
	
	public static BeanReport voReportToBeanReport(VOReport voReport) {
		
		BeanReport beanReport = new BeanReport();
		beanReport.setReportId(voReport.getReportId());
		beanReport.setUserId(voReport.getUserId());
		
		String tsStr = voReport.getDate() + " " + voReport.getTime();
		Timestamp ts = Timestamp.valueOf(tsStr);
		beanReport.setTime(ts);
		
		beanReport.setRoute(voReport.getRoute());
		beanReport.setPriorityId(Dictionary.getKeyFromValue("priorityDic", voReport.getPriority()));
		beanReport.setRelevantDepartment(voReport.getRelevantDepartment());
		beanReport.setDescription(voReport.getDescription());
		beanReport.setStreetNumber(voReport.getStreetNumber());
		beanReport.setLocality(voReport.getLocality());
		beanReport.setReportStageId(Dictionary.getKeyFromValue("reportStageDic", voReport.getReportStage()));
		beanReport.setReportStatusId(Dictionary.getKeyFromValue("reportStatusDic", voReport.getReportStatus()));
		
		return beanReport;
	}	
}