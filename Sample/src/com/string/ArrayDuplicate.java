package com.string;

import java.util.Arrays;

public class ArrayDuplicate {

	public static int removeDuplicates(int array[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (array[i] != array[i + 1]) {
				array[j++] = array[i];
			}
		}

		array[j++] = array[n - 1];
		return j;
	}

	public static void main(String[] args) {
		int data[] = { 25, 28, 18, 29, 25, 18, 29, 28, 25, 18 };
		Arrays.sort(data);
		int length = ArrayDuplicate.removeDuplicates(data, data.length);

		for (int i = 0; i < length; i++) {
			System.out.println(data[i]);
		}
	}

}
