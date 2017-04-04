package com.jiuwei.commons.zkclient.event;

import com.jiuwei.plugins.event.core.ApplicationEvent;

public class ZKTreeWatchEvent extends ApplicationEvent {

	private static final long serialVersionUID = -182586646183912684L;

	public ZKTreeWatchEvent(Object source) {
		super(source);
	}

}
