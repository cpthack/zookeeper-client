package com.jiuwei.commons.zkclient.config;


public class ZkConfig extends AbstractConfig{
	private final String FILE_NAME = "zk-config.properties";
	private final String ZK_CONFIG_ADDRESS = "zk.config.address";
	private final String ZK_CONFIG_CHARSET = "zk.config.charset";
	private final String ZK_CONFIG_CONNECTION_TIMEOUT = "zk.config.connectionTimeoutMs";
	private final String ZK_CONFIG_SESSION_TIMEOUT = "zk.config.sessionTimeoutMs";
	private final String ZK_CONFIG_NAMESPACE = "zk.config.namespace";

	private static final ZkConfig instance = new ZkConfig();
	public static ZkConfig getInstance(){
		return instance;
	}
	
	private ZkConfig() {
		reloadConfig();
	}
	
	@Override
	public String getConfigFile() {
		return FILE_NAME;
	}
	
	public String getAddress(){
		return getProperty(ZK_CONFIG_ADDRESS);
	}
	
	
	public String getNamespace() {
	    return getProperty(ZK_CONFIG_NAMESPACE);
	}
	
	public String getCharset() {
	    return getProperty(ZK_CONFIG_CHARSET);
	}
	  
	public int getSessionTimeoutMs() {
	    return getPropertyToInt(ZK_CONFIG_SESSION_TIMEOUT,60_000);
	}
	
	public int getConnectionTimeoutMs() {
		return getPropertyToInt(ZK_CONFIG_CONNECTION_TIMEOUT, 15_000);
	}  
   

}
