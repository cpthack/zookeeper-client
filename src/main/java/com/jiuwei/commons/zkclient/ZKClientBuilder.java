/**
 * Copyright (c) 2013-2020, cpthack 成佩涛 (cpt@jianzhimao.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jiuwei.commons.zkclient;

import com.jiuwei.commons.zkclient.core.CuratorZKClient;
import com.jiuwei.commons.zkclient.core.ZKClient;

/** 
 * <b>ZKClientBuilder.java</b></br>
 * TODO(这里用一句话描述这个类的作用)</br>
 *
 * @author cpthack cpt@jianzhimao.com 
 * @date 2017年4月4日 下午2:14:29 
 * @since JDK 1.7
 */
public class ZKClientBuilder {
	
	private final static CuratorZKClient instance = new CuratorZKClient().build();
	
	public static ZKClient build(){
		return instance;
	}
}
