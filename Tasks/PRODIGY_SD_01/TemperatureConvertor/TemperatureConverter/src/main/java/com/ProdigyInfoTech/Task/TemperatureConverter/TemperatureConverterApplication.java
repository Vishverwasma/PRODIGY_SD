package com.ProdigyInfoTech.Task.TemperatureConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TemperatureConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatureConverterApplication.class, args);
	}

}
