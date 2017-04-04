package com.jiuwei.commons.zkclient.event;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.curator.framework.recipes.cache.TreeCacheEvent;

import com.jiuwei.commons.zkclient.entity.ZKEventData;
import com.jiuwei.commons.zkclient.enums.EventType;
import com.jiuwei.commons.zkclient.enums.WatchType;

public abstract class AbstractZKListener {
	// ZKTreeWatchApplicationListener listener = new
	// ZKTreeWatchApplicationListener();
	static Map<Integer, Map<String, ZKListener>> listeners = new ConcurrentHashMap<Integer, Map<String, ZKListener>>();

	protected void setWatchPath(WatchType watchType, String path,
			ZKListener listener) {
		Map<String, ZKListener> zkListeners = listeners.get(watchType
				.getTypeCode());
		if (zkListeners == null) {
			zkListeners = new HashMap<String, ZKListener>();
		}
		zkListeners.put(path, listener);
		listeners.put(watchType.getTypeCode(), zkListeners);
	}

	protected void WatchPathMulticaster(TreeCacheEvent event) {

		if (event.getData() == null)
			return;

		ZKEventData eventData = new ZKEventData();
		eventData.setPath(event.getData().getPath());
		eventData.setData(new String(event.getData().getData()));

		switch (event.getType()) {
		case NODE_ADDED:
			eventData.setEventType(EventType.nodeAdded);
			break;
		case NODE_UPDATED:
			eventData.setEventType(EventType.nodeUpdated);
			break;
		case NODE_REMOVED:
			eventData.setEventType(EventType.nodeRemoved);
			break;
		default:
			break;
		}

		Map<String, ZKListener> zkListeners = null;
		ZKListener zkListener = null;
		for (int watchTypeCode : listeners.keySet()) {

			zkListeners = listeners.get(watchTypeCode);
			// 监听某个path节点，只有path精准匹配成功才对该节点监听器发送事件
			if (watchTypeCode == WatchType.NodeWatch.getTypeCode()) {
				for (String path : zkListeners.keySet()) {
					if (path.equals(eventData.getPath())) {
						zkListener = zkListeners.get(path);
						zkListener.watchNode(eventData);
					}
				}
			}
			// 监听某个path子节点，只有path匹配到当前节点和子一级节点才对该节点监听器发送事件
			if (watchTypeCode == WatchType.PathChildWatch.getTypeCode()) {
				for (String path : zkListeners.keySet()) {
//					System.out.println("a "+path);
//					System.out.println("b "+eventData.getPath());
//					System.out.println("c "+eventData.getPath().replace(path, "")
//									.lastIndexOf("/"));
					if (eventData.getPath().startsWith(path)
							&& eventData.getPath().replace(path, "")
									.lastIndexOf("/") == 0) {
						zkListener = zkListeners.get(path);
						zkListener.watchNode(eventData);
					}
				}
			}

			// 监听某个path所有子节点，只有匹配到path及path当前所有子节点就对该节点监听并发送事件
			if (watchTypeCode == WatchType.TreeWatch.getTypeCode()) {
				for (String path : zkListeners.keySet()) {
					if (eventData.getPath().startsWith(path)) {
						zkListener = zkListeners.get(path);
						zkListener.watchNode(eventData);
					}
				}
			}

		}

	}
}
