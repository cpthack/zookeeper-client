package com.jiuwei.commons.zkclient.entity;

import java.io.Serializable;

import com.jiuwei.commons.zkclient.enums.EventType;

public class ZKEventData implements Serializable {

	private static final long serialVersionUID = 7569041209134714950L;

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
