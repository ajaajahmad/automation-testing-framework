package com.automation.base;

public class Palindrome {

	public static void main(String[] args) {

		String str = "madam";
		String rev = new StringBuilder(str).reverse().toString();

		if (str.equals(rev)) {
			System.out.println("Palindrome");
		}
		
		imperativeStyle();

	}

	public static void imperativeStyle() {

		String str = "jahaj";
		char[] arr = str.toCharArray();
		String rev = "";

		for (int i = arr.length - 1; i >= 0; i--) {
			rev = rev + arr[i];
		}
		
		if(str.equals(rev)) {
			System.out.println("Palindrome");
		}
	}

}
