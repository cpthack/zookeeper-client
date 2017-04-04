package com.jiuwei.commons.zkclient.event;

import com.jiuwei.commons.zkclient.entity.ZKEventData;

public interface ZKListener {
	
	void watchNode(ZKEventData eventData);
}
