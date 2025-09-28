package com.automation.pages;

import org.testng.annotations.Test;

public class PS1 extends PS {

	@Test
	public void runTest() {

		PS2 ps2 = new PS2(3);

		int a = 3;
		doThis();

		System.out.println(ps2.increament());
		System.out.println(ps2.decreament());

		PS3 ps3 = new PS3(3);

		System.out.println(ps3.multiplyThree());
	}
}
