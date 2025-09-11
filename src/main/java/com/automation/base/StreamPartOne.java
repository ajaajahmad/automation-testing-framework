package com.automation.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;

public class StreamPartOne {

	public static void main(String[] args) {

		streamFilter();
		streamMap();
		streamCollect();
		assignmentStreams();
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

		ArrayList<String> namesOne = new ArrayList<>();

		namesOne.add("man");
		namesOne.add("Don");
		namesOne.add("woman");

		// Print all names in UPPER CASE which ends with letter "a".

		Stream.of("Aliya", "Ahmed", "Karan", "Don", "Shama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Print all names in sorted and UPPER CASE which starts with letter "A".

		List<String> namesTwo = Arrays.asList("Azwa", "Alia", "Ahmad", "Karan", "Don", "Arbaz");
		namesTwo.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		Stream<String> mergedStream = Stream.concat(namesOne.stream(), namesTwo.stream());
		boolean flag = mergedStream.anyMatch(s -> s.equalsIgnoreCase("man"));

		System.out.println(flag);

		Assert.assertTrue(flag);
	}

	public static void streamCollect() {

		List<String> list = Arrays.asList("Azwa", "Alia", "Ahmad", "Karan", "Don", "Arbaz");
		list.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(list.get(0));
	}

	public static void assignmentStreams() {

		List<Integer> values = Arrays.asList(3, 2, 2, 7, 3, 9, 5, 1, 6, 7, 4);

		// Print unique numbers from the above Array.
		// Sort the Array - 3rd index

		values.stream().distinct().forEach(s -> System.out.println(s));
		values.stream().distinct().sorted().forEach(s -> System.out.println(s));

		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());

		System.out.println(li.get(3));
	}

}