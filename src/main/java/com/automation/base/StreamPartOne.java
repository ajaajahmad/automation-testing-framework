package com.automation.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPartOne {

	public static void main(String[] args) {

		streamFilter();
		streamMap();
	}

	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Ajaaj");
		names.add("Ahmad");
		names.add("Kalam");
		names.add("Don");
		names.add("Alia");

		// There is no life to intermediate OP if there is no terminal OP.
		// Terminal OP will execute only if intermediate OP (filter) returns true.
		// We can create stream.
		// How to use filter in streams API.

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		long d = Stream.of("Alia", "Ahmed", "Karan", "Don").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();

		System.out.println(d);

		// Print all the names in ArrayList.

		// names.stream().filter(s -> s.length() > 4).forEach(s ->
		// System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	public static void streamMap() {

		// Print all names in UPPER CASE which ends with letter "a".

		Stream.of("Aliya", "Ahmed", "Karan", "Don", "Shama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Print all names in sorted and UPPER CASE which starts with letter "A".

		List<String> names = Arrays.asList("Azwa", "Alia", "Ahmad", "Karan", "Don", "Arbaz");
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

}