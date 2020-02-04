package com.cognizant.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cognizant.model.Employee;

public class Utility {

	// Checks the country domain

	public static boolean checkCountryDomain(String email, Employee employee) {
		boolean flag = false;
		String[] empEmail = email.split("\\.");
		String last = empEmail[empEmail.length - 1];
		if (!last.equals("com")) {
			flag = true;
		}
		return flag;
	}

	// Return the employee list from the document

	public static List<Employee> getEmployeeList(File file) throws IOException {
		List<Employee> employeeList = new ArrayList<>();
		BufferedReader br;
		try {
			Employee employee = null;
			br = new BufferedReader(new FileReader(file));
			String st;
			String[] employeeDetails = null;
			br.readLine();
			while ((st = br.readLine()) != null) {
				employeeDetails = st.split(",");
				employee = new Employee(employeeDetails[0], employeeDetails[1], employeeDetails[2], employeeDetails[3],
						employeeDetails[4], employeeDetails[5],
						Float.parseFloat((employeeDetails[6] + employeeDetails[7]).substring(2).replace(" \"", "")),
						employeeDetails[8], employeeDetails[9], employeeDetails[10], employeeDetails[11],
						employeeDetails[12]);
				employee.setCountryDomain(Utility.checkCountryDomain(employeeDetails[3], employee));
				employeeList.add(employee);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	// To print every employee details in a tabular form into a text file

	public static void printData(Collection<Employee> employeeList, int offset, int limit) throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		FileWriter fWriter = new FileWriter("output.txt");
		for (Employee employee : employeeList) {
			fWriter.write(employee.getEmployeeId(), offset, limit);
			fWriter.write("                                  ");
			fWriter.write(employee.getFirstName() + " " + employee.getLastName(), offset, limit);
			fWriter.write("                                  ");
			fWriter.write(employee.getGender(), offset, limit);
			fWriter.write("                                  ");
			fWriter.write(employee.getDepartmentName(), offset, limit);
			fWriter.write("                                  ");
			fWriter.write(String.valueOf(employee.getSalary()), offset, limit);
			fWriter.write("                                                                            ");
			fWriter.write(employee.getStreetAddress() + " " + employee.getCity() + " " + employee.getState(), offset,
					limit);
			fWriter.write("\r\n");
		}
		fWriter.flush();
		fWriter.close();
		out.close();
	}

	public static void getEmployeesByDepartment(List<Employee> employeeList) {
		Map<String, Long> departmentCountingMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting()));
		System.out.println("Number of employees by department \n");
		printEmployeeMap(departmentCountingMap);
	}

	public static void getEmployeesByMaxAndMin(List<Employee> employeeList) {

		System.out.println();

		Map<String, Optional<Employee>> topEmployee = employeeList.stream().collect(Collectors.groupingBy(
				emp -> emp.getDepartmentName(), Collectors.maxBy(Comparator.comparingDouble(emp -> emp.getSalary()))));

		System.out.println("Department wise maximum salary \n");
		printMaxAndMinEmployee(topEmployee);

		Map<String, Optional<Employee>> bottomEmployee = employeeList.stream().collect(Collectors.groupingBy(
				emp -> emp.getDepartmentName(), Collectors.minBy(Comparator.comparingDouble(emp -> emp.getSalary()))));

		System.out.println("Department wise minimum salary \n");
		printMaxAndMinEmployee(bottomEmployee);

	}

	public static void getAverageSalary(List<Employee> employeeList) {
		Map<String, Double> averageSalary = employeeList.stream().collect(Collectors
				.groupingBy(emp -> emp.getDepartmentName(), Collectors.averagingDouble(emp -> emp.getSalary())));

		Map<String, Double> result = averageSalary.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		System.out.println("Department wise average salary \n");
		printSortedEmployee(result);
	}

	private static void printEmployeeMap(Map<String, Long> departmentCountingMap) {
		for (Map.Entry<String, Long> entry : departmentCountingMap.entrySet())
			System.out.println("Department = " + entry.getKey() + " , No of Employees = " + entry.getValue());
		System.out.println();
	}

	private static void printSortedEmployee(Map<String, Double> departmentCountingMap) {
		for (Map.Entry<String, Double> entry : departmentCountingMap.entrySet())
			System.out.println("Department = " + entry.getKey() + " , Average Salary = " + entry.getValue());
		System.out.println();
	}

	private static void printMaxAndMinEmployee(Map<String, Optional<Employee>> employee) {
		for (Map.Entry<String, Optional<Employee>> entry : employee.entrySet())
			System.out.println("Department = " + entry.getKey() + " , Employee Details = " + entry.getValue().get());
		System.out.println();
	}
}
