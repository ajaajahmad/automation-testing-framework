package com.automation.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test Listener - Start");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Listener - failed " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Listener - Success");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFinish(ITestResult result) {

	}
}
