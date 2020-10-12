package com.string;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ArrayReverseTest {

	@Test
	void reverseArrayTest() {
		int[] input = { 1, 2, 3, 4, 5 };
		ArrayReverse.reverseArray(input);
		assertArrayEquals(new int[] { 5, 4, 3, 2, 1 }, input);
	}

}
