package com.automation.base;

public class MultiDimensionalAarrayQuestion {

	public static void main(String[] args) {

		int[][] a = new int[3][3];

		a[0][0] = 2;
		a[0][1] = 6;
		a[0][2] = 3;
		a[1][0] = 9;
		a[1][1] = 7;
		a[1][2] = 5;
		a[2][0] = 4;
		a[2][1] = 8;
		a[2][2] = 1;

		int min = a[0][0];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				if (a[i][j] < min) {
					min = a[i][j];
				}
			}

		}
		System.out.println(min);
	}
}