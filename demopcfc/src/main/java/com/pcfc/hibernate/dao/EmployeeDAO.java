package com.pcfc.hibernate.dao;

import java.util.List;

import com.pcfc.hibernate.model.Employee;
/**
 * Create Date : 2022-06-14
 * @author Nadeem
 *
 */
public interface EmployeeDAO {

	/**
	 * Fetch all employees list
	 * @return List<Employee>
	 * 
	 */
	public List<Employee> getEmployees();

	/**
	 * Delete employe by id
	 * @param id
	 */
	void deleteEmployee(int id);

	/**
	 * Save Employee
	 * @param Employee to save
	 */
	void saveEmployee(Employee employee);

	/**
	 * 
	 * @param employeeid
	 * @return Employee
	 */
	Employee getEmployee(int empoyeeid);

}
