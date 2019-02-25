package com.myaustralia.common;

import java.util.HashMap;

public class Dictionary {
	static HashMap<Integer, String> priorityDic = new HashMap<>();
	static HashMap<Integer, String> reportStageDic = new HashMap<>();
	static HashMap<Integer, String> reportStatusDic = new HashMap<>();
	
	static {
		priorityDic.put(1, "Low");
		priorityDic.put(2, "Medium");
		priorityDic.put(3, "High");
		
		reportStageDic.put(1, "New");
		reportStageDic.put(2, "In Progress");
		reportStageDic.put(3, "Done");
		
		reportStatusDic.put(1, "Frivolous");
		reportStatusDic.put(2, "Duplicate");
		reportStatusDic.put(3, "Valid");
	}
	
	public static String getValueFromKey(String dicType, int key) {
		String value = "";
		if (dicType.equals("priorityDic")) {
			value = priorityDic.get(key);
		} else if (dicType.equals("reportStageDic")) {
			value = reportStageDic.get(key);
		} else if (dicType.equals("reportStatusDic")) {
			value = reportStatusDic.get(key);
		}
		return value;
	}
	
	public static int getKeyFromValue(String dicType, String value){
		int res = 0;
		if (dicType.equals("priorityDic")) {
			for(int key : priorityDic.keySet()) {
				if (priorityDic.get(key).equals(value)) {
					res = key;
				}
			}
		} else if (dicType.equals("reportStageDic")) {
			for(int key : reportStageDic.keySet()) {
				if (reportStageDic.get(key).equals(value)) {
					res = key;
				}
			}
		} else if (dicType.equals("reportStatusDic")) {
			for(int key : reportStatusDic.keySet()) {
				if (reportStatusDic.get(key).equals(value)) {
					res = key;
				}
			}
		}
		return res;
	}
}