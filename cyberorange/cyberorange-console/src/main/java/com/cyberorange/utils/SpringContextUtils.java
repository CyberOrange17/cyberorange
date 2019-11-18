package com.cyberorange.utils;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *  上下文工具
 * @author 黄传举
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
	
    private static ApplicationContext applicationContext;
	
    @Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}
    
    /**
     * 	获取上下文实例
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    /**
     * 	根据类全名获取实例
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    
    /**
     * 	根据类对象获取实例
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
 
    /**
     * 	根据类全名及类对象获取实例
     * @param name
     * @param clazz
     * @return
     */
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
    
    /**
     * 	根据类对象获得所有的实例
     * @param clazz
     * @return
     */
    public static <T> Map<String,T> getBeansOfType(Class<T> clazz){
    	return getApplicationContext().getBeansOfType(clazz);
    }
    
}
