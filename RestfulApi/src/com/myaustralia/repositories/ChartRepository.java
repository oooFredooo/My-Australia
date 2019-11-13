package com.myaustralia.repositories;

import java.util.ArrayList;
import java.util.List;

import com.myaustralia.beans.Chart;
import com.myaustralia.common.JsonHelper;
import com.myaustralia.dao.DAO;

public class ChartRepository {
	
	public String getSuburbCount(String authority) {
		Chart chart = new Chart();
		List<Chart> charts = new ArrayList<>();
		if (authority.equals("Admin")) {
			charts = new DAO().query(chart.getClass(), "select Locality suburb, COUNT( `ReportId` ) count from report group by Locality order by count desc limit 0,10");
		} else {
			charts = new DAO().query(chart.getClass(), "select Locality suburb, COUNT( `ReportId` ) count from report where RelevantDepartment=? group by Locality order by count desc limit 0,10", authority);
		}
		return JsonHelper.parseToJsonWithoutRoot(charts);
	}
	
	public String getRouteCount(String authority) {
		Chart chart = new Chart();
		List<Chart> charts = new ArrayList<>();
		if (authority.equals("Admin")) {
			charts = new DAO().query(chart.getClass(), "select Route suburb, COUNT( `ReportId` ) count from report group by Route order by count desc limit 0,10");
		} else {
			charts = new DAO().query(chart.getClass(), "select Route suburb, COUNT( `ReportId` ) count from report where RelevantDepartment=? group by Route order by count desc limit 0,10", authority);
		}
		return JsonHelper.parseToJsonWithoutRoot(charts);
	}
	
}