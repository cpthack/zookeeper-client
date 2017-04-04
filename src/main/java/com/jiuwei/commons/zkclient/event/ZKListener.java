package com.jiuwei.commons.zkclient.event;

import com.jiuwei.commons.zkclient.entity.ZKEventData;

public interface ZKListener {
	
	/**
	 * 
	  * <b>watchNode </b> <br/>
	  * 
	  * 自定义监听节点事件<br/>
	  * 
	  * @author cpthack cpt@jianzhimao.com
	  * @param eventData 
	  * void
	  *
	 */
	void watchNode(ZKEventData eventData);
}
