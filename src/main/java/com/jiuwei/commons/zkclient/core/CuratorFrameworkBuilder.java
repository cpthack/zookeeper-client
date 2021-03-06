package com.jiuwei.commons.zkclient.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.RetryNTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiuwei.commons.zkclient.config.ZkConfig;
import com.jiuwei.commons.zkclient.exception.ZookeeperException;

/** 
 * <b>com.jiuwei.commons.zkclient.core.CuratorFrameworkBuilder.java</b></br>
 * TODO(这里用一句话描述这个类的作用)</br>
 *
 * @author cpthack cpt@jianzhimao.com 
 * @date 2017年4月4日 下午2:15:45 
 * @since JDK 1.7 
*/
public class CuratorFrameworkBuilder {
	private final static Logger logger = LoggerFactory
			.getLogger(CuratorFrameworkBuilder.class);
	private ZkConfig zkconfig = ZkConfig.getInstance();
	private CuratorFramework zkClient = null;

	public CuratorFrameworkBuilder setZkconfig(ZkConfig zkconfig) {
		this.zkconfig = zkconfig;
		return this;
	}

	public ZkConfig getZkconfig() {
		return zkconfig;
	}

	public CuratorFramework createCurator() {

		logger.info("开始连接zookeeper集群...");
		logger.info("集群地址[{}],session超时时间[{}],连接超时时间[{}]",
				zkconfig.getAddress(), zkconfig.getSessionTimeoutMs(),
				zkconfig.getConnectionTimeoutMs());
		Builder builder = CuratorFrameworkFactory.builder();
		builder.connectString(zkconfig.getAddress())
				.sessionTimeoutMs(zkconfig.getSessionTimeoutMs())
				.retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000))
				.connectionTimeoutMs(zkconfig.getConnectionTimeoutMs());
		if (StringUtils.isNoneEmpty(zkconfig.getNamespace())) {
			builder.namespace(zkconfig.getNamespace());
		}
		zkClient = builder.build();
		zkClient.start();
		try {
			zkClient.blockUntilConnected();
		} catch (InterruptedException e) {
			logger.error("", e);
			throw new ZookeeperException("无法连接zookeeper集群, 原因："
					+ e.getMessage());
		}
		logger.info("zookeeper集群连接成功.");

		return zkClient;
	}

}
