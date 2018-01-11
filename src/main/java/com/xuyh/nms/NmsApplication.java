package com.xuyh.nms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.xuyh.nms.modules.sys.dao")
public class NmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmsApplication.class, args);
	}
}
