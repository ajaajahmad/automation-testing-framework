package com.automation.pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DayTwo {
	
	@Parameters("URL")
	@Test(groups={"Smoke"})
	public void personalLoad(String urlname) {
		System.out.println("good");
		System.out.println(urlname);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}

}