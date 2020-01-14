package com.cyberorange.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心
 * @author 黄传举
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerStarter {
	
	private static Logger log = LoggerFactory.getLogger(EurekaServerStarter.class);
	
	public static void main(String[] args) {
		log.info("Eureka注册中心EurekaServerStarter 开始启动...");
		SpringApplication.run(EurekaServerStarter.class, args);
		log.info("Eureka注册中心EurekaServerStarter 已启动");
	}
}
