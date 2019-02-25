package com.myaustralia.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MapMarker {
	private int title;
	private double lat;
	private double lng;
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
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