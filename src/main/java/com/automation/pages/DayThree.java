package com.automation.pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DayThree {

	@Parameters({ "URL" })
	@Test
	public void webLoginCarLoan(String urlname) {
		System.out.println("web login car");
		System.out.println(urlname);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before class in class 3");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after class in class 3");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method in class 3");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after method in class 3");
	}

	@Test(dependsOnMethods = { "webLoginCarLoan" })
	public void mobileLoginCarLoan() {
		System.out.println("mobile login car");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@Test(enabled = false)
	public void loginAPICarLoad() {
		System.out.println("login api car");
	}
	
	@DataProvider
	public static void getData() {
		
		Object[][] date = new Object[3][2];
		
	}

}
