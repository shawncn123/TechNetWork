package com.shenxf.ssh.service;

import java.util.List;

import com.shenxf.ssh.dao.DepartmentDao;
import com.shenxf.ssh.entities.Department;

public class DepartmentService {
	
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
	
}
