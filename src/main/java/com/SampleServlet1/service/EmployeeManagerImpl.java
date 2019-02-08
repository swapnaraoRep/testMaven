package com.SampleServlet1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SampleServlet1.dao.EmployeeDAO;
import com.SampleServlet1.model.Department;
import com.SampleServlet1.model.Employee;
import com.SampleServlet1.model.EmployeeVO;
import com.SampleServlet1.model.EmployeeVO2;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

	@Autowired
	EmployeeDAO dao;
	
	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	public List<EmployeeVO> getAllEmployees() 
	{
		return dao.getAllEmployees();
	}

	@Override
	@Transactional
	public void addPerson(EmployeeVO p) {
		dao.addPerson(p);
		
	}

	@Override
	@Transactional
	public void addEmplyeeDepartment(Employee p) {
		// TODO Auto-generated method stub
		dao.addEmplyeeDepartment(p);
	}

	@Override
	@Transactional
	public void addEmplyeeRole(EmployeeVO p) {
		// TODO Auto-generated method stub
		dao.addEmplyeeRole(p);
	}

	@Transactional
	public void addEmplyeeRoleBIDirectional(EmployeeVO2 p) {
		// TODO Auto-generated method stub
		dao.addEmplyeeRoleBIDirectional(p);
		
	}

	@Override
	@Transactional
	public void addDepartment(Department dept) {
		// TODO Auto-generated method stub
		dao.addDepartment(dept);
		
	}
}
