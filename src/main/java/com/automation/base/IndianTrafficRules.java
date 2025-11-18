package com.automation.base;

public class IndianTrafficRules implements CentralizedTraffiRules {

	public static void main(String[] args) {

		CentralizedTraffiRules ct = new IndianTrafficRules();

		ct.greenSign();
		ct.redSign();
		ct.yelloSign();
		
		IndianTrafficRules it = new IndianTrafficRules();
		
		it.walkinSign();
	}

	@Override
	public void greenSign() {
		System.out.println("Green for go!");
	}

	@Override
	public void redSign() {
		System.out.println("Red for stop!");
	}

	@Override
	public void yelloSign() {
		System.out.println("Yello for go!");
	}

	public void walkinSign() {
		System.out.println("Walking for move!");
	}

}
