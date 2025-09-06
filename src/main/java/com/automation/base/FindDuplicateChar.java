package com.automation.base;

public class FindDuplicateChar {

	public static void main(String[] args) {

		String str = "ajaajahmad";

		char[] arr = str.toCharArray();

		int count = 1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j] && arr[i] != ' ') {
					count++;
					arr[j] = 0;
					{
						System.out.println(arr[i]);
					}
				}
			}

		}

	}
}
