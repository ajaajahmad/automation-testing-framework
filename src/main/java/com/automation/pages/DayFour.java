package com.automation.pages;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DayFour {
	
	@Parameters("URL")
	@Test
	public void webLoginHomeLoan(String urlname) {
		System.out.println("web login home");
		System.out.println(urlname);
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
