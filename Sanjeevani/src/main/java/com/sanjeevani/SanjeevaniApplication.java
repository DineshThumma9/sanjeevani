package com.sanjeevani;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class SanjeevaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanjeevaniApplication.class, args);
	}

}
