package com.learning.mockito.mockitoin5steps;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void testSize() {
		List mock2 = mock(List.class);
		when(mock2.size()).thenReturn(10);
		assertEquals(10, mock2.size());
		assertEquals(10, mock2.size());

	}

	@Test
	void testSize_multiplereturns() {
		List mock2 = mock(List.class);
		when(mock2.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, mock2.size());
		assertEquals(20, mock2.size());
		assertEquals(20, mock2.size());

	}

	@Test
	void testGet_Specific_Parameter() {
		List mock2 = mock(List.class);
		when(mock2.get(0)).thenReturn("something");
		assertEquals("something", mock2.get(0));
		assertEquals(null, mock2.get(1));


	}
	
	@Test
	void testGet_Deneric_Parameter() {
		List mock2 = mock(List.class);
		when(mock2.get(Mockito.anyInt())).thenReturn("something");
		assertEquals("something", mock2.get(0));
		assertEquals("something", mock2.get(1));


	}

}
