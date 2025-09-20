package com.automation.pages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DayFour {

	@Parameters("URL")
	@Test
	public void webLoginHomeLoan(String urlname) {
		System.out.println("web login home");
		System.out.println(urlname);
	}

	@Test(groups = { "Smoke" })
	public void mobileLoginHomeLoan() {
		System.out.println("mobile login home");
	}

	@Test(dataProvider = "getData")
	public void loginAPIHomeLoad(String username, String password) {
		System.out.println("login api home");
		System.out.println(username);
		System.out.println(password);
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "firstsetusername";
		data[0][1] = "firstpassword";

		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";

		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdpassword";

		return data;
	}

}
