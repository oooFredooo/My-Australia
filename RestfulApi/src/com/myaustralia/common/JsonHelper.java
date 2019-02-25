package com.myaustralia.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {
	
	public static <T> String parseToJsonWithRoot(List<T> list) {
		HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			JSONROOT.put("data", list);
		} catch (Exception ex) {
			
		}
		String jsonArray = gson.toJson(JSONROOT);
		return jsonArray;
	}
	
	public static <T> String parseToJsonWithoutRoot(List<T> list) {
		Gson gson = new Gson();
		String jsonArray = gson.toJson(list);
		return jsonArray;
	}
}
