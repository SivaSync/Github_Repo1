package com.siva.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // java configuration
@ComponentScan(basePackages="com.siva.sbeans") 
public class AppConfig
{
  @Bean(name="ltime")  // Object Creation 
  
  public LocalTime createLTime()
  {
	  System.out.println("AppConfig.createLTime()");
	  return LocalTime.now();
  }
  
}
