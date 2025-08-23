package com.automation.base;

import java.util.ArrayList;
import java.util.List;

public class ArrList {

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();

		a.add("Ajaaj");
		a.add("Ahmad");
		a.add("Sheikh");
		a.add("Null");

		System.out.println(a.get(0));

		List<Integer> b = new ArrayList<>();

		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(5);
		b.add(6);
		b.remove(5);

		System.out.println(b.get(4));
	}

}