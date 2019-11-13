package com.nogame;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *  基本服务提供方
 * @author 黄传举
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.nogame.mapper")
public class PrimaryServiceStarter {
	
	private static Logger log = LoggerFactory.getLogger(PrimaryServiceStarter.class);
	
	public static void main(String[] args) {
		log.info(" primary service 开始启动...");
		SpringApplication.run(PrimaryServiceStarter.class, args);
	}
}
