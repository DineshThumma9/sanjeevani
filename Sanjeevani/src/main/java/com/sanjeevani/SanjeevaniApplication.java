package com.sanjeevani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.cache.annotation.EnableCaching;

@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableCaching
public class SanjeevaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanjeevaniApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}