package com.pcfc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcfc.hibernate.dao.EmployeeDAO;
import com.pcfc.hibernate.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee getEmployee(Integer id) {
		return employeeDAO.getEmployee(id);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteEmployee(Integer id) {
		employeeDAO.deleteEmployee(id);
	}

}
