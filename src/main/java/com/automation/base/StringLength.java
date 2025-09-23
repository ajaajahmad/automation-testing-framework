package com.automation.base;

public class StringLength {

	public static void main(String[] args) {

		String str = "how are you";

		String[] words = str.split(" ");

		String reversed = "";

		for (int i = words.length - 1; i >= 0; i--) {
			reversed = reversed + words[i] + " ";
		}

		reversed = reversed.trim();

		System.out.println(reversed);
		
		String str2 = "how are you";

		int count = 0;
		char[] arr = str2.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			count++;
		}
		
		System.out.println(count);
	}

}
