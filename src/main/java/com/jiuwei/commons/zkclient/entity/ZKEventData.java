package com.jiuwei.commons.zkclient.entity;

import com.jiuwei.commons.zkclient.enums.EventType;

public class ZKEventData {

	private EventType eventType;

	private String path;

	private String data;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	
}
