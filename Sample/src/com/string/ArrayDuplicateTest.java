package com.string;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArrayDuplicateTest {

	@Test
	void testArrayDuplicate() {
		int data[] = { 25, 28, 18, 29, 25, 18, 29, 28, 25, 18 };
		Arrays.sort(data);
		assertEquals(ArrayDuplicate.removeDuplicates(data, data.length), 4);
	}

}
