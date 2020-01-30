package com.cognizant.service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

import com.cognizant.model.Employee;
import com.cognizant.utility.Utility;

public class EmployeeMain {

	/*
	 * Driver method
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("abc.csv");
		Collection<Employee> employeeList = Utility.getEmployeeList(file);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter offset : ");
		int offset = sc.nextInt();
		System.out.println("Enter limit : ");
		int limit = sc.nextInt();
		sc.close();
		Utility.printData(employeeList, offset, limit);
		System.out.println("<---------Completed Successfully--------->");
	}

	

}
