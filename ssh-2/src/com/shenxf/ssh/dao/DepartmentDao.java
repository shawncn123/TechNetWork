package com.shenxf.ssh.dao;

import java.util.List;

import com.shenxf.ssh.entities.Department;

public class DepartmentDao extends BaseDao{

	public List<Department> getAll(){
		
		String hql="from Department";
		return getSession().createQuery(hql).list();
		
	}
	
}
