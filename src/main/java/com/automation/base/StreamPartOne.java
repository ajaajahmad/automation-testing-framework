package com.automation.base;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamPartOne {

	public static void main(String[] args) {

		streamFilter();
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

}