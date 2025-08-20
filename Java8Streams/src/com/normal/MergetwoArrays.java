package com.normal;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergetwoArrays {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 5, 6, 8, 9 };
		int arr2[] = { 1, 8, 7, 4, 6, 9 };

		IntStream.concat(Arrays.stream(arr), Arrays.stream(arr2))
		.distinct().forEach(e -> System.out.println(e + ","));
	}

}
