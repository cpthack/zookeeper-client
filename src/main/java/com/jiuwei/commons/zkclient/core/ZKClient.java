package com.jiuwei.commons.zkclient.core;

import java.util.List;

import com.jiuwei.commons.zkclient.event.ZKListener;

/**
 *
 * @author cpthack cpt@jianzhimao.com
 * @date Aug 6, 2016 3:12:00 PM <br/>
 * @version
 * @since JDK 1.7
 */
public interface ZKClient {

	CuratorZKClient build();

	/**
	 * <b>create</b> <br/>
	 * 创建zookeeper节点，并设置值. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @param data
	 *
	 */
	void create(String path, String data);

	/**
	 * 
	 * <b>delete</b> <br/>
	 * 删除zookeeper节点. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 *
	 */
	void delete(String path);

	/**
	 * <b>update</b> <br/>
	 * 
	 * 修改zookeeper节点的值. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @param data
	 *
	 */
	void update(String path, String data);

	/**
	 * <b>getChildren</b> <br/>
	 * 
	 * 获取zookeeper指定目录下的子节点. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @return
	 *
	 */
	List<String> getChildren(String path);

	/**
	 * <b>getData</b> <br/>
	 * 
	 * 获取指定节点下的数据. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @return
	 *
	 */
	String getData(String path);

	/**
	 * 
	 * <b>exists</b> <br/>
	 * 
	 * 判断zookeeper节点是否存在
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @return
	 *
	 */
	boolean exists(String path);
	
	
	/**
	 * <b>watch</b> <br/>
	 * 
	 * 监控zookeeper节点变化
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 *
	 */
	void watch();
	
	
	void pathChildrenWatch(String path,ZKListener listener);
	
	void nodeWatch(String path,ZKListener listener);
	
	void treeWatch(String path,ZKListener listener);

}
