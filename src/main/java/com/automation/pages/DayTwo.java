package com.automation.pages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DayTwo {

	@Test
	public void personalLoad() {
		System.out.println("good");
	}

	@BeforeTest
	public void beforeMethod() {
		System.out.println("before method");
	}

}