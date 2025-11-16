package com.automation.base;

public class NestedLoop {

	public static void main(String[] args) {

		for (int i = 1; i <= 4; i++) {
			System.out.println("outer loop started!");
			for (int j = 1; j <= 4; j++) {
				System.out.println("inner loop");
			}
			System.out.println("outer loop finished!");
		}
	}

}
