package com.shenxf.ssh.service;

import java.util.List;

import com.shenxf.ssh.dao.EmployeeDao;
import com.shenxf.ssh.entities.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public Boolean lastNameIsValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	public List<Employee> getAll(){
//		测试没有员工信息的情况
//		List<Employee> employees = employeeDao.getAll();
//		employees.clear();
//		return employees;
		return employeeDao.getAll();
	}
	
}
