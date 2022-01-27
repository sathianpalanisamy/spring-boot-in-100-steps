package com.learning.mockito.mockitoin5steps;

public class SomeBusinessImpl {

	private DataService dataService;

	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	int findGreatestOfAllData() {
		int max = Integer.MIN_VALUE;

		for (int i : dataService.retrieveAllData()) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

}
