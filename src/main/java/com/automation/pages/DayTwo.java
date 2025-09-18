package com.automation.pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DayTwo {

	@Test(groups={"Smoke"})
	public void personalLoad() {
		System.out.println("good");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}

}