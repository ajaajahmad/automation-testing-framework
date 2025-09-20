package com.automation.pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DayThree {

	@Test
	public void webLoginCarLoan() {
		System.out.println("web login car");
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

	@Test
	public void loginAPICarLoad() {
		System.out.println("login api car");
	}

}
