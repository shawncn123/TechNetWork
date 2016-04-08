package com.shenxf.ssh.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.shenxf.ssh.entities.Employee;
import com.shenxf.ssh.service.DepartmentService;
import com.shenxf.ssh.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String list() {

		request.put("employees", employeeService.getAll());
		return "list";

	}

	private Integer id;

	public void setId(Integer id) {
		this.id = id;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String delete() {
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			
		}
//		return SUCCESS;    使用ajax后改成下面程序
		return "ajax-success";
	}

	public String input(){
		request.put("departments", departmentService.getAll());
		return INPUT;
	}
	
	public String save(){
		model.setCreateTime(new Date());
		employeeService.saveOrUpdate(model);
		System.out.println(model);
		return SUCCESS;
	}
	
	public void prepareSave(){
		model = new Employee();
	}
	
	private String lastName;
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String validateLastName() throws UnsupportedEncodingException{
		if(employeeService.lastNameIsValid(lastName)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax-success";
	}
	
	
	private Map<String, Object> request;
	private Map<String, Object> session;

	@Override
	public void setRequest(Map<String, Object> arg0) {

		this.request = arg0;

	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private Employee model;

	@Override
	public Employee getModel() {
		return model;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
