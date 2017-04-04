package com.jiuwei.commons.zkclient.enums;

public enum EventType {

	nodeAdded(0, "新增节点"),
	nodeUpdated(1, "修改节点"),
	nodeRemoved(2, "移除节点");

	private int typeCode;// 事件类型代号
	private String typeDesc;// 事件类型描述

	EventType(int typeCode, String typeDesc) {
		this.typeCode = typeCode;
		this.typeDesc = typeDesc;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public String getTypeDesc() {
		return typeDesc;
	}
}
