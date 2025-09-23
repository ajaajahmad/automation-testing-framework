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
	}

}
