package com.pcfc.service;

import java.util.List;

import com.pcfc.hibernate.model.Employee;

/**
 * Created Date : 2022-06-14
 * @author Nadeem
 *
 */
public interface EmployeeService {
	
	/**
	 * Fetch all employees
	 * @return List<Employee>
	 */
	public List<Employee> getEmployees();

	/**
	 * Save Employee
	 * @param employee
	 */
	void saveEmployee(Employee employee);

	/**
	 * Fetch Employee by id
	 * @param id
	 * @return Employee
	 */
	Employee getEmployee(Integer id);

	/**
	 * Delete Employee by id
	 * @param id
	 */
	void deleteEmployee(Integer id);

}
