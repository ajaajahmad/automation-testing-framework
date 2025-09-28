package com.automation.pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

	// methods, variables
	public void doThis() {

		System.out.println("i am here");
	}

	@BeforeMethod
	public void beforeRun() {
		System.out.println("run me first");
	}

	@AfterMethod
	public void afetrRun() {
		System.out.println("run me last");
	}
}
