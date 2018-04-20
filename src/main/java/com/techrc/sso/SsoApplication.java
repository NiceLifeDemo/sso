package com.techrc.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration
public class SsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoApplication.class, args);
	}
}
