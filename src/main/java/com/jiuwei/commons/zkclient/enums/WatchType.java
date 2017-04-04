package com.jiuwei.commons.zkclient.enums;

public enum WatchType {
	
	TreeWatch(0, "表示treeWatch监听模式"),
	PathChildWatch(1, "表示pathChildWatch监听模式"),
	NodeWatch(2, "表示nodeWatch监听模式");

	private int typeCode;// 监听类型代号
	private String typeDesc;// 监听类型描述

	WatchType(int typeCode, String typeDesc) {
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
