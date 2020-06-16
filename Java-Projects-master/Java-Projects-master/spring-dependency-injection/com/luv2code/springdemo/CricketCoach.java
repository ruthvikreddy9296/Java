package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//new fields for email address and name
	private String emailAddress;
	private String name;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside the Setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Inside the Setter method - setName");
		this.name = name;
	}

	public CricketCoach() {
		System.out.println("Inside the no args constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Pratice fast bowling for 15Min";
	}
	
	
	//setter Method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside the Setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
