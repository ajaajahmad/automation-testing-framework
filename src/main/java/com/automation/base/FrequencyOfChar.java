package com.automation.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FrequencyOfChar {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 6, 4, 8, 9 };

		System.out.println("Original array: " + Arrays.toString(numbers));

		List<Integer> evenNumbers = Arrays.stream(numbers).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());

		System.out.println("Even numbers (List): " + evenNumbers);
	}

}
