package com.myaustralia.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapMarker {
	private String title;
	private double lat;
	private double lng;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
}