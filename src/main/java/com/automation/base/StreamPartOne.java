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

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		long d = Stream.of("Alia", "Ahmed", "Karan", "Don").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();

		System.out.println(d);

		// names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

}