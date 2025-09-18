package com.automation.pages;

import org.testng.annotations.Test;

public class DayFour {

	@Test
	public void webLoginHomeLoan() {
		System.out.println("web login home");
	}

	@Test(groups={"Smoke"})
	public void mobileLoginHomeLoan() {
		System.out.println("mobile login home");
	}

	@Test
	public void loginAPIHomeLoad() {
		System.out.println("login api home");
	}

}
