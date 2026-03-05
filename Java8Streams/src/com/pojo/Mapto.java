package com.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapto {

	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("Banana");
		ls.add("Apple");
		ls.add("Orange");

//		ls.stream().collect(Collectors.toMap(s -> s, s -> s.length(), (u, v) -> v)).entrySet()
//				.forEach(e -> System.out.print(e + ", "));

		ls.stream().collect(Collectors.toMap(s -> s, s -> s.length(), (u, v) -> v)).entrySet()
				.forEach(e -> System.out.println(e + ","));
	}

}
