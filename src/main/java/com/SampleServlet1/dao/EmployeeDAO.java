package com.SampleServlet1.dao;



import java.util.List;

import com.SampleServlet1.model.Department;
import com.SampleServlet1.model.Employee;
import com.SampleServlet1.model.EmployeeVO;
import com.SampleServlet1.model.EmployeeVO2;
import com.SampleServlet1.model.Husband;
import com.SampleServlet1.model.Wife;


public interface EmployeeDAO 
{
	public List<EmployeeVO> getAllEmployees();
	public void addPerson(EmployeeVO e);
	public void addEmplyeeDepartment(Employee p);
	public void addEmplyeeRole(EmployeeVO p);
	public void addEmplyeeRoleBIDirectional(EmployeeVO2 p);
	public void addDepartment(Department dept);
	public void addHusband(Husband hus);
	public void addWife(Wife wife);
}