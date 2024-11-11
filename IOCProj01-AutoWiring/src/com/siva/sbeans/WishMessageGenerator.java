package com.siva.sbeans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 @Component
public class WishMessageGenerator {
    @Autowired // Field injection
	private LocalTime lt; // HAS-Propert(Composition)
//
//    public WishMessageGenerator()
//    {
//    	System.out.println("WishMessageGenerator:: 0-Arg Constructor");
//    }
    
	public String generateMessage(String user) {
		int hour = lt.getHour(); // 24 Hours Format
		// generate the wish message
		if (hour < 12) {
			return "Good Morning ::" + user;
		} else if (hour < 16) {
			return "Good AfterNoon ::" + user;
		} else if (hour < 20) {
			return "Good Evening ::" + user;
		} else {
			return "Good Night ::" + user;
		}

	}

}
