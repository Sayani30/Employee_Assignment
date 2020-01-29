package com.cognizant.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.cognizant.model.Employee;

public class EmployeeMain {

	/*
	 * Driver method
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("MOCK_DATA.csv");
		Collection<Employee> employeeList = new ArrayList<>();
		BufferedReader br;
		try {
			Employee employee = null;
			br = new BufferedReader(new FileReader(file));
			String st;
			String[] employeeDetails = null;

			while ((st = br.readLine()) != null) {
				employeeDetails = st.split(",");
				employee = new Employee(employeeDetails[0], employeeDetails[1], employeeDetails[2], employeeDetails[3],
						employeeDetails[4], employeeDetails[5],
						Float.parseFloat(employeeDetails[6].substring(1).replace(",", "")), employeeDetails[7],
						employeeDetails[8], employeeDetails[9], employeeDetails[10], employeeDetails[11]);
				employee.setCountryDomain(checkCountryDomain(employeeDetails[3], employee));
				employeeList.add(employee);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		Scanner sc = new Scanner(System.in);
		int offset = sc.nextInt();
		int limit = sc.nextInt();
		sc.close();
		printData(employeeList, offset, limit);

	}

	private static boolean checkCountryDomain(String email, Employee employee) {
		boolean flag=false;
		String[] empEmail = email.split("\\.");
		String last = empEmail[empEmail.length - 1];
		if(!last.equals("com")) {
			flag=true;
		}
		return flag;
	}

	/*
	 * To print every employee details in a tabular form into a text file
	 */
	private static void printData(Collection<Employee> employeeList, int offset, int limit) throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		FileWriter fWriter = new FileWriter("output.txt");
		
		for (Employee employee : employeeList) {
			System.out.println(employee); //prints all the employee objects
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
			fWriter.write(employee.getStreetAddress() + " " + employee.getCity() + " " + employee.getState(), offset, limit);
			fWriter.write("\r\n");
		}
		fWriter.flush();
		fWriter.close();
		out.close();
	}
}
