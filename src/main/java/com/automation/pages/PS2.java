package com.automation.pages;

public class PS2 extends PS3 {

	int a;

	public PS2(int a) {
		super(a);
		this.a = a;
	}

	public int increament() {
		a = a + 1;
		return a;
	}

	public int decreament() {
		a = a - 1;
		return a;
	}
}