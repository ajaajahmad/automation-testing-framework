package com.automation.base;

public class MultiDimensionalArrays {

	public static void main(String[] args) {

		int[][] a = new int[2][3];

		a[0][0] = 2;
		a[0][1] = 1;
		a[0][2] = 3;
		a[1][0] = 9;
		a[1][1] = 7;
		a[1][2] = 5;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				System.out.print(a[i][j]);
				System.out.print(" ");
			}

			System.out.println();
		}
	}
}
