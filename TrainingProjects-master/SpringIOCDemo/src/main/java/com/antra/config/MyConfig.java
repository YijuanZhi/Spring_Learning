package com.antra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.antra")
@EnableAspectJAutoProxy
public class MyConfig {
	@Bean
	public String getString() {
		return "Hello";
	}
}
