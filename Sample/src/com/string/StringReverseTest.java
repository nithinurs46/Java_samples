package com.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringReverseTest {

	@Test
	void testReverse() {
		assertEquals(StringReverse.reverseString1("ABD"), "DBA");
		assertNotEquals(StringReverse.reverseString1("ABD"), "DBA");
	}

}
