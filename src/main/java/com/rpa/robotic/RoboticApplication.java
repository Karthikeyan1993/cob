package com.rpa.robotic;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoboticApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboticApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean h2Regi() {
		ServletRegistrationBean srb = new ServletRegistrationBean(new WebServlet());
		srb.addUrlMappings("/console/*");
		return srb;
	}

}
