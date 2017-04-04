package com.jiuwei.commons.zkclient.core;

import java.util.List;

import com.jiuwei.commons.zkclient.event.ZKListener;

/**
 * <b>com.jiuwei.commons.zkclient.core.ZKClient.java</b></br>
 * TODO(这里用一句话描述这个类的作用)</br>
 *
 * @author cpthack cpt@jianzhimao.com
 * @date 2017年4月4日 下午1:56:04
 * @since JDK 1.7
 */
public interface ZKClient {

	/**
	 * <b>create </b> <br/>
	 * 
	 * 创建zookeeper节点，并设置值. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @param data
	 * @return void
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
	 * 
	 * <b>getChildren </b> <br/>
	 * 
	 * 获取zookeeper指定目录下的子节点. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @return List<String>
	 *
	 */
	List<String> getChildren(String path);

	/**
	 * 
	 * <b>getData </b> <br/>
	 * 
	 * 获取指定节点下的数据. <br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @return String
	 *
	 */
	String getData(String path);

	/**
	 * 
	 * <b>exists </b> <br/>
	 * 
	 * 判断zookeeper节点是否存在<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @return boolean
	 *
	 */
	boolean exists(String path);

	/**
	 * 
	 * <b>pathChildrenWatch </b> <br/>
	 * 
	 * 监控zookeeper节点的子节点数据的变化.<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @param listener
	 *            void
	 *
	 */
	void pathChildrenWatch(String path, ZKListener listener);

	/**
	 * 
	 * <b>nodeWatch </b> <br/>
	 * 
	 * 监控zookeeper节点数据的变化（不包含子节点）.<br/>
	 *
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @param listener
	 *            void
	 *
	 */
	void nodeWatch(String path, ZKListener listener);

	/**
	 * 
	 * <b>treeWatch </b> <br/>
	 * 
	 * 监控zookeeper节点及其所有子节点数据的变化.<br/>
	 * 
	 * @author cpthack cpt@jianzhimao.com
	 * @param path
	 * @param listener
	 *            void
	 *
	 */
	void treeWatch(String path, ZKListener listener);

}
