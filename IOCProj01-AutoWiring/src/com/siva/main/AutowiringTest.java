package com.siva.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.siva.config.AppConfig;
import com.siva.sbeans.WishMessageGenerator;


public class AutowiringTest {

  public static void main(String[] args) 
  {
	  System.out.println("AutowiringTest.main()===>start");
	@SuppressWarnings("resource")
	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	
   System.out.println("AutowiringTest::IOC container cretion completed");
   
	WishMessageGenerator generator = ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
	
	String msg = generator.generateMessage("Siva");
	
	System.out.println("result :: "+msg);
	// ctx.close();
  }

}
