package com.automation.base;

public class ReverseString {

	public static void main(String[] args) {

		imperativeStyle();
	}

	public static void imperativeStyle() {

		String str = "how are you";
		char[] arr = str.toCharArray();
		String rev = "";

		for (int i = arr.length - 1; i >= 0; i--) {
			rev = rev + arr[i];
		}

		System.out.println(rev);
	}

	public static void reverseString() {

		String str = "hello world";

		String reversed = new StringBuilder(str).reverse().toString();

		System.out.println(reversed);
	}

}
