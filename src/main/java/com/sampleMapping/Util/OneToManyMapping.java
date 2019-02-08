package com.sampleMapping.Util;
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;

import com.SampleServlet1.model.Department;
import com.SampleServlet1.model.Employee; 
public class OneToManyMapping { 
	public static void main(String[]args){ 
		Configuration cfg = new Configuration(); 
		cfg.configure("hibernate.cfg.xml"); 
		SessionFactory sessionFactory = cfg.buildSessionFactory(); 
		Session session = sessionFactory.openSession(); 
		Employee emp = new Employee(); 
		Department dept1 = new Department();
		Department dept2 = new Department(); 
		emp.setId(2); 
		
		emp.setFirstName("Emp1");
		emp.setLastName("Emp1");
		emp.setEmail("swapna@gmail.com");
		dept1.setDeptId(1); 
		dept1.setDeptName("Dept1"); 
		dept2.setDeptId(2); 
		dept2.setDeptName("Dept2"); 
		emp.getDept().add(dept1); 
		emp.getDept().add(dept2);
		
		session.beginTransaction(); 
		session.save(emp); 
		session.save(dept1);
		session.save(dept2);
		session.getTransaction().commit(); 
		session.close(); 
		} 
	}

