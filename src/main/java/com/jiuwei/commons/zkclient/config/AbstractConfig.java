package com.jiuwei.commons.zkclient.config;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 读取配置文件的抽象基础类. 使用时，子类需指定配置文件名，并调用reloadConfig()方法.
 *
 */
public abstract class AbstractConfig {
	private static Logger logger = Logger.getLogger(AbstractConfig.class);
	private Properties configProperties = null;

	public synchronized boolean reloadConfig() {
		logger.debug("Base config reloadConfig().");
		if (configProperties != null) {
			configProperties.clear();
		}
		String file = getConfigFile();
		configProperties = FileUtils.loadStaticProperties(file);
		if (configProperties == null) {
			return false;
		}
		return true;
	}

	public String getProperty(String key) {
		if (configProperties == null) {
			return null;
		}
		return configProperties.getProperty(key);
	}

	public String getProperty(String key, String defaultV) {
		String strValue = defaultV;
		String temp = getProperty(key);
		if (StringUtils.isNotBlank(temp)) {
			strValue = temp;
		}
		return strValue;
	}

	public int getPropertyToInt(String key, int defaultV) {
		int intValue = defaultV;
		String temp = getProperty(key);
		try {
			intValue = Integer.parseInt(temp);
		} catch (NumberFormatException e) {
		}
		return intValue;
	}

	// 子类需指定配置文件名
	public abstract String getConfigFile();
}