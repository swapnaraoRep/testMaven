package com.SampleServlet1.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.SampleServlet1.model.Department;
import com.SampleServlet1.model.Employee;
import com.SampleServlet1.model.EmployeeVO;
import com.SampleServlet1.model.EmployeeVO2;



@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public List<EmployeeVO> getAllEmployees() 
	{
		List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
		
		EmployeeVO vo1 = new EmployeeVO();
		vo1.setId(1);
		vo1.setFirstName("Lokesh");
		vo1.setLastName("Gupta");
		employees.add(vo1);
		
		EmployeeVO vo2 = new EmployeeVO();
		vo2.setId(2);
		vo2.setFirstName("Raj");
		vo2.setLastName("Kishore");
		employees.add(vo2);
		
		return employees;
	}

	@Override
	public void addPerson(EmployeeVO e) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(e);
		System.out.println("Person saved successfully, Person Details="+e);
	}
	@Override
	public void addEmplyeeDepartment(Employee p) {
		// TODO Auto-generated method stub
		System.out.println("******************** Details=");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		System.out.println("******************** Details="+p);
	}
	@Override
	public void addEmplyeeRole(EmployeeVO p) {
		// TODO Auto-generated method stub
		System.out.println("******************** Details=");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		System.out.println("******************** Details="+p);
		
	}
	@Override
	public void addEmplyeeRoleBIDirectional(EmployeeVO2 p) {
		// TODO Auto-generated method stub
		System.out.println("******************** Details=");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		System.out.println("******************** Details="+p);
	}
	@Override
	public void addDepartment(Department dept) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dept);
		
	}
}