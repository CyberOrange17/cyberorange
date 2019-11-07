package com.nogame;

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
	
	private static Logger LOGGER = LoggerFactory.getLogger(EurekaServerStarter.class);
	
	public static void main(String[] args) {
		LOGGER.info("eureka starter 开始启动...");
		SpringApplication.run(EurekaServerStarter.class, args);
	}
}
