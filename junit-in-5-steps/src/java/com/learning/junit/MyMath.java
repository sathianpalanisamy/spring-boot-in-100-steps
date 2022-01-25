package com.learning.junit;

public class MyMath {

	int sum(int[] nos) {
		int sum = 0;
		for (int i : nos) {
			sum += i;
		}
		return sum;
	}

}
