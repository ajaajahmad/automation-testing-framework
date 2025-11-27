package com.automation.base;

public class NumberPattern {

	public static void main(String[] args) {
		int totalRow = 3;

		for (int i = 1; i <= totalRow; i++) {

			int limit = i + 1;

			for (int j = 1; j <= limit; j++) {

				System.out.print(j);
			}

			System.out.println(1);
		}
	}

}
