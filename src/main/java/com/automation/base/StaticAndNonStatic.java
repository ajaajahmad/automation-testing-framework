package com.automation.base;

public class StaticAndNonStatic {

	String name;
	String address;
	static String city = "Mumbai";
	static int i = 0;

	StaticAndNonStatic(String name, String address) {

		this.name = name;
		this.address = address;
		i++;
		System.out.println(i);
	}

	public void getAddress() {
		System.out.println(address + " " + city);
	}

	public static void main(String[] args) {

		StaticAndNonStatic st = new StaticAndNonStatic("Ajaaj", "Mumbra");
		StaticAndNonStatic st2 = new StaticAndNonStatic("Ahmad", "Kausa");
		st2.getAddress();
		st.getAddress();
	}

}
