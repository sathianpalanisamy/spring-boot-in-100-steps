package com.learning.mockito.mockitoin5steps;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessMockTest {

	@Test
	void testfindGreatestOfAllData() {
		DataService dataService = mock(DataService.class);
		when(dataService.retrieveAllData()).thenReturn(new int[] { 10, 18, 17 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
		int result = businessImpl.findGreatestOfAllData();
		assertEquals(18, result);

	}

	@Test
	void testfindGreatestOneValue() {
		DataService dataService = mock(DataService.class);
		when(dataService.retrieveAllData()).thenReturn(new int[] { 18 });
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
		int result = businessImpl.findGreatestOfAllData();
		assertEquals(18, result);

	}

}
