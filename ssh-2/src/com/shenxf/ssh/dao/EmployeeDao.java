package com.shenxf.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.shenxf.ssh.entities.Employee;

public class EmployeeDao extends BaseDao{
	
	public void delete(Integer id){
		String hql1="delete from Employee e where e.id=:id";
		getSession().createQuery(hql1).setInteger("id", id).executeUpdate();
	}
	
	public List<Employee> getAll(){
// 不用懒加载，用迫切左外连接同时初始化其关联的Department 对象		
		String hql = "FROM Employee e left outer join fetch e.department";
//		String hql = "FROM Employee";
		return getSession().createQuery(hql).list();
	}

	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	
	public Employee getEmployeeByLastName(String lastName){
		String hql = "from Employee e where e.lastName=:lastName_v";
		Query query = getSession().createQuery(hql).setString("lastName_v", lastName);
		return (Employee) query.uniqueResult();
	}
}
