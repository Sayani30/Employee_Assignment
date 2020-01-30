package com.cognizant.model;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String departmentName;
	private float salary;
	private String ssn;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private boolean isCountryDomain;

	public Employee() {
	}

	public Employee(String employeeId, String firstName, String lastName, String email, String gender,
			String departmentName, float salary, String ssn, String streetAddress, String city, String state,
			String zip) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.departmentName = departmentName;
		this.salary = salary;
		this.ssn = ssn;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public boolean isCountryDomain() {
		return isCountryDomain;
	}

	public void setCountryDomain(boolean isCountryDomain) {
		this.isCountryDomain = isCountryDomain;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender + ", departmentName=" + departmentName + ", salary=" + salary + ", ssn="
				+ ssn + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zip=" + zip
				+ "]";
	}

}
