package com.nogame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 *  基本服务提供方
 * @author 黄传举
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.nogame")
public class PrimarySlotStarter {
	
	private static Logger log = LoggerFactory.getLogger(PrimarySlotStarter.class);
	
	public static void main(String[] args) {
		log.info("服务PrimarySlot 开始启动...");
		SpringApplication.run(PrimarySlotStarter.class, args);
		log.info("服务PrimarySlot 已启动");
	}
}
