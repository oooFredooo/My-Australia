package com.myaustralia.repositories;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.myaustralia.common.JsonHelper;
import com.myaustralia.dao.DAO;
import com.myaustralia.entities.*;

public class MapMarkerRepository {
	
	public String getMapMarkers(String authority) {
		MapMarker mapMarker = new MapMarker();
		List<MapMarker> mapMarkers = new ArrayList<>();
		if (authority.equals("Admin")) {
			mapMarkers = new DAO().query(mapMarker.getClass(), "select ReportId title, Latitude lat, Longitude lng from report");
		} else {
			mapMarkers = new DAO().query(mapMarker.getClass(), "select ReportId title, Latitude lat, Longitude lng from report where RelevantDepartment = ?", authority);
		}
		return JsonHelper.parseToJsonWithoutRoot(mapMarkers);
	}
}