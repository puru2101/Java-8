package com.pojo;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
	String name;
	List<String> email;

	public Student(String name, List<String> email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public static void main(String[] args) {
		// List to store multiple students
		List<Student> students = new ArrayList<>();

		// Student 1
		List<String> emails1 = new ArrayList<>();
		emails1.add("john@yahoo.com");
		emails1.add("john@gmail.com");
		emails1.add("johnd@gmail.com");
		emails1.add("john@outlook.com");
		Student s1 = new Student("John", emails1);

		// Student 2
		List<String> emails2 = new ArrayList<>();
		emails2.add("alice@yahoo.com");
		emails2.add("alice@gmail.com");
		Student s2 = new Student("Alice", emails2);

		// Student 3
		List<String> emails3 = new ArrayList<>();
		emails3.add("mark@icloud.com");
		emails3.add("mark@yahoo.com");
		Student s3 = new Student("Mark", emails3);

		// Add students to list
		students.add(s1);
		students.add(s2);
		students.add(s3);

		students.stream()
				.map(s -> new Student(s.getName(),
						s.email.stream().filter(e -> e.endsWith("gmail.com")).collect(Collectors.toList())))
				.filter(s -> !s.getEmail().isEmpty()).forEach(e -> {
					System.out.println(e.getName());
					e.getEmail().stream().forEach(p -> System.out.println(p + " ,"));
				}

				);

	}

}
