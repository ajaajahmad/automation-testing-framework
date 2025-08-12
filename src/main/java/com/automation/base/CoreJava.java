package com.automation.base;

public class CoreJava {

	public static void main(String[] args) {

		int myNum = 5;
		String myWebsite = "www.example.com";
		char myFlag = 'A';
		float myDeci = 5.99f;
		boolean isTrue = false;

		System.out.println(myNum + myWebsite);

		int array[] = new int[5];

		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		array[3] = 4;
		array[4] = 5;

		System.out.println(array[0]);

		int[] array2 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 67, 122 };

		for (int i = 0; i < array2.length; i++) {

			System.out.println(array2[i]);
		}

		String[] name = { "Ajaaj", "Ahmad", "Sheikh" };

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}

		for (String s : name) {
			System.out.println(s);
		}

		int[] array3 = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 67, 122 };

		for (int i = 0; i < array3.length; i++) {
			if (array3[i] % 2 == 0) {
				System.out.println(array3[i] + " is a multiple of 2");
			} else {
				System.out.println(array3[i] + " is not a multiple of 2");
			}
		}
	}

}
