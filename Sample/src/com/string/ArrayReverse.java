package com.string;

import java.util.Arrays;

public class ArrayReverse {

	public static void reverseArray(int input[]) {
		if (input == null || input.length <= 1) {
			return;
		}

		int size = input.length;
		for (int i = 0; i < size / 2; i++) {
			int temp = input[i];
			input[i] = input[size - 1 - i];
			input[size - i - 1] = temp;
		}
		System.out.println("reversed array : " + Arrays.toString(input));
	}

	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 4, 5, 6 };
		ArrayReverse.reverseArray(input);
	}
}
