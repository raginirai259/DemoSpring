package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
public class DemoexampleApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DemoexampleApplication.class, args);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper uph=new UrlPathHelper();
		uph.setRemoveSemicolonContent(false);		
		configurer.setUrlPathHelper(uph);
	}
}
