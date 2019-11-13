package com.myaustralia.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Chart {
	private String suburb;
	private long count;
	
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public long getCount() {
		return count;
	}
}