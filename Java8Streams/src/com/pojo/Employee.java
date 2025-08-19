package com.pojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

	int empId;
	String name;
	Double Salary;
	String Dept;
	String Gender;
	int joiningYear;

	public Employee(int empId, String name, Double salary, String dept, String gender, int joiningYear) {
		super();
		this.empId = empId;
		this.name = name;
		Salary = salary;
		Dept = dept;
		Gender = gender;
		this.joiningYear = joiningYear;
	}

	public int getJoiningYear() {
		return joiningYear;
	}

	public void setJoiningYear(int joiningYear) {
		this.joiningYear = joiningYear;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", Salary=" + Salary + ", Dept=" + Dept + ", Gender="
				+ Gender + "]";
	}

	public static void main(String[] args) {
		List<Employee> emp = new ArrayList<>();
		Employee emp1 = new Employee(1, "Alice", 50000d, "HR", "Female", 2022);
		Employee emp2 = new Employee(2, "Bob", 52000d, "IT", "Male", 2021);
		Employee emp3 = new Employee(3, "Carol", 55000d, "Finance", "Female", 2019);
		Employee emp4 = new Employee(4, "David", 53000d, "IT", "Male", 2020);
		Employee emp5 = new Employee(5, "Eva", 60000d, "Admin", "Female", 2024);
		Employee emp6 = new Employee(6, "Frank", 64000d, "Finance", "Male", 2019);

		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);
		emp.add(emp4);
		emp.add(emp5);
		emp.add(emp6);

		// 1)Highest Salary
		System.out.println(emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst()
				.map(e -> e.getName()).get());
		System.out.println("-----------------------");
		// 2)Count Employees
		System.out.println(emp.stream().count());
		System.out.println("-----------------------");

		// 3)Average Salary of Each dept

		emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 4)Count male and Female Employee
		Map<Boolean, List<Employee>> em = emp.stream().collect(Collectors.partitioningBy(e -> e.getGender() == "Male"));

		System.out.println("Male:" + em.get(true).stream().map(e -> e.getName()).collect(Collectors.toList()));
		System.out.println("Male count:" + em.get(true).stream().count());
		System.out.println("-----------------------");
		System.out.println("Female:" + em.get(false).stream().map(e -> e.getName()).collect(Collectors.toList()));
		System.out.println("Female count:" + em.get(false).stream().count());
		System.out.println("-----------------------");

		// 5)EMployees name in Sorted way

		emp.stream().sorted(Comparator.comparing(Employee::getName)).map(e -> e.getName())
				.forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 6)List all Dept
		emp.stream().map(e -> e.getDept()).collect(Collectors.toSet()).forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 7)Employee Name with lowest salary in IT
		System.out.println(emp.stream().filter(e -> e.getDept() == "IT")
				.sorted(Comparator.comparing(Employee::getSalary)).findFirst().map(e -> e.getName()).get());
		System.out.println("-----------------------");

		// 8)Male Employee increasing order of salary
		emp.stream().filter(e -> e.getGender() == "Male").sorted(Comparator.comparing(Employee::getSalary))
				.forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 9)Increase salary by 10%
		// emp.stream().map(e->e.getSalary()*1.1).forEach(e->System.out.println(e+","));
		emp.stream().forEach(e -> {
			e.setSalary(e.getSalary() * 1.1d);
			System.out.println(e.getName() + ":" + e.getSalary());
		});
		System.out.println("-----------------------");

		// 10)Join employee name into a single string with comma seperated
		System.out.println(emp.stream().map(e -> e.getName()).collect(Collectors.joining(",")));
		System.out.println("-----------------------");

		// 11)Name of employee joining each year
		emp.stream()
				.collect(Collectors.groupingBy(Employee::getJoiningYear,
						Collectors.mapping(Employee::getName, Collectors.toList())))
				.entrySet().forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 12)Count of employee joining each year
		emp.stream().collect(Collectors.groupingBy(Employee::getJoiningYear, Collectors.counting())).entrySet()
				.forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 13)Employee name starts with A
		emp.stream().filter(e -> e.getName().startsWith("A")).forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");

		// 14)Group Employees by Dept and then Gender
		emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.groupingBy(Employee::getGender)))
				.entrySet().forEach(e -> System.out.println(e + ","));
		System.out.println("-----------------------");
		
		// 15)Group Employees NAme by Dept and then Gender
				emp.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName, Collectors.toList()))))
						.entrySet().forEach(e -> System.out.println(e + ","));
				System.out.println("-----------------------");
        
		//16) Average salary of each dept 
			emp.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary))).
			entrySet().forEach(e->System.out.println(e+","));	
			System.out.println("-----------------------");
			
			
		//17)Each Dept Highest paid salary
			emp.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).
			entrySet().forEach(e->System.out.println(e+","));
			System.out.println("-----------------------");
			emp.stream().collect(Collectors.toMap(Employee::getDept, Employee::getSalary,Double::max)).entrySet().forEach(e->System.out.println(e+","));
			System.out.println("-----------------------");
			
		//18)Employee name in finance who join before 2021
			emp.stream().
			filter(e->e.getJoiningYear()<2021).
			filter(e->e.getDept()=="Finance").map(e->e.getName()).
			forEach(e->System.out.println(e+","));
	}

}
