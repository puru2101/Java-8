package com.normal;

import java.util.stream.IntStream;

public class LastElemOfArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5, 6, 8, 9 };
		System.out.println(IntStream.of(arr).boxed().
				reduce((first, second) -> second));
	}

}
