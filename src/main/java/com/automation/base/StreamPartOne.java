package com.automation.base;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class StreamPartOne {
	
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Ajaaj");
		names.add("Ahmad");
		names.add("Kalam");
		names.add("Don");
		names.add("Alia");

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
	}

}
