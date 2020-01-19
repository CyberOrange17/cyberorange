package com.cyberorange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Controller
 * 
 * @author 黄传举
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsoleStarter {

	private static Logger log = LoggerFactory.getLogger(ConsoleStarter.class);

	public static void main(String[] args) {
		log.info("应用Console 开始启动...");
		SpringApplication.run(ConsoleStarter.class, args);
		log.info("应用Console 已启动");
	}
}
