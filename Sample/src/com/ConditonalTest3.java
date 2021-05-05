package com;

import java.util.HashMap;
import java.util.Map;

public class ConditonalTest3 {
	static Map<String, Integer> numbersMap = new HashMap<String, Integer>();
	static {
		numbersMap.put("Monday", 0);
		numbersMap.put("Tuesday", 1);
		numbersMap.put("Wednesday", 2);
	}

	public static void main(String[] args) {
		int day = numbersMap.get("Tuesday");
		System.out.println("Day:-" + day);
	}
}
