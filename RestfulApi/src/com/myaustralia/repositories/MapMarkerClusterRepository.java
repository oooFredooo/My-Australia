package com.myaustralia.repositories;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.myaustralia.common.JsonHelper;
import com.myaustralia.dao.DAO;
import com.myaustralia.entities.*;

public class MapMarkerClusterRepository {
	
	public String getMapMarkerClusters(String authority) {
		MapMarkerCluster mapMarkerCluster = new MapMarkerCluster();
		List<MapMarkerCluster> mapMarkerClusters = new ArrayList<>();
		if (authority.equals("Admin")) {
			mapMarkerClusters = new DAO().query(mapMarkerCluster.getClass(), "select Latitude lat, Longitude lng from report");
		} else {
			mapMarkerClusters = new DAO().query(mapMarkerCluster.getClass(), "select Latitude lat, Longitude lng from report where RelevantDepartment = ?", authority);
		}
		return JsonHelper.parseToJsonWithoutRoot(mapMarkerClusters);	
	}
	
}
