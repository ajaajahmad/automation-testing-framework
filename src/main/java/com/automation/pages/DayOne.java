package com.automation.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DayOne {

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}

	@Test
	public void firstTest() {
		System.out.println("hello");
	}

	@Test(groups={"Smoke"})
	public void secondTest() {
		System.out.println("bye");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
}
