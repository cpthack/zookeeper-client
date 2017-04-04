package com.jiuwei.commons.zkclient.event;

import org.apache.curator.framework.recipes.cache.TreeCacheEvent;

import com.jiuwei.plugins.event.annotation.Listener;
import com.jiuwei.plugins.event.core.ApplicationListener;

@Listener(enableAsync = false)
public class ZKTreeWatchApplicationListener implements ApplicationListener<ZKTreeWatchEvent>  {
	
	@Override
	public void onApplicationEvent(ZKTreeWatchEvent zKTreeWatchEvent) {
		TreeCacheEvent event = (TreeCacheEvent) zKTreeWatchEvent.getSource();
		switch (event.getType()) {
        case NODE_ADDED:
            System.out  
            .println("TreeNode added: " +event.getData() 
                    .getPath()+" , data: "+new String(event.getData().getData()));  
            break;  
        case NODE_UPDATED:  
            System.out  
            .println("TreeNode updated: "+event.getData()  
                    .getPath()+" , data: "+new String(event.getData().getData()));  
            break;  
        case NODE_REMOVED:  
            System.out  
            .println("TreeNode removed: "+event.getData()  
                    .getPath());  
            break;  
        default:  
            break;  
        }  
	}
	
	
}
