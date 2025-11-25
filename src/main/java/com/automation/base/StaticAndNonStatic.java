package com.automation.base;

public class StaticAndNonStatic {

	String name;
	String address;
	String city;

	StaticAndNonStatic(String name, String address, String city) {

		this.name = name;
		this.address = address;
		this.city = city;
	}

	public void getAddress() {
		System.out.println(address);
	}

	public static void main(String[] args) {

		StaticAndNonStatic st = new StaticAndNonStatic("Ajaaj", "Mumbra", "Mumbai");
		StaticAndNonStatic st2 = new StaticAndNonStatic("Ahmad", "Kausa", "Mumbai");
		st2.getAddress();
		st.getAddress();
	}

}
