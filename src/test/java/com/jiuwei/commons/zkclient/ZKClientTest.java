package com.jiuwei.commons.zkclient;

import com.jiuwei.commons.zkclient.core.ZKClient;
import com.jiuwei.commons.zkclient.entity.ZKEventData;
import com.jiuwei.commons.zkclient.event.ZKListener;

public class ZKClientTest {

	public static void main(String[] args) {
		
		ZKClient zKClient = ZKClientBuilder.build(	);

		/*
		 * 监听节点 example
		 */
		zKClient.pathChildrenWatch("/test", new ZKListener() {
			@Override
			public void watchNode(ZKEventData eventData) {
				System.out.println("我监听的是【pathChildrenWatch】，路径【/test】。"
						+ eventData.getEventType().getTypeDesc() + ", "
						+ eventData.getPath() + " , " + eventData.getData());
			}
		});
		zKClient.treeWatch("/test", new ZKListener() {

			@Override
			public void watchNode(ZKEventData eventData) {
				System.out.println("我监听的是【treeWatch】，路径【/test】。"
						+ eventData.getEventType().getTypeDesc() + ", "
						+ eventData.getPath() + " , " + eventData.getData());
			}
		});
		
		/*
		 * 创建节点 example
		 */
		zKClient.create("/test/abc/t", "我叫成佩涛");
		
		
	}
}
