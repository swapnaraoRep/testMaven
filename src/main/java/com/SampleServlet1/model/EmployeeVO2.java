package com.SampleServlet1.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//http://websystique.com/hibernate/hibernate-one-to-one-bidirectional-with-shared-primary-key-annotation-example/
//http://websystique.com/hibernate/hibernate-one-to-one-bidirectional-with-shared-primary-key-annotation-example/
@Entity
@Table(name="employeeBD11")
public class EmployeeVO2 implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	@Column(name="email")
	private String email;

	@OneToOne(mappedBy="employee" ,cascade=CascadeType.ALL)
	private EmployeeVO_Login2 employeeLogin;
	
	
	

	public EmployeeVO2() {
	
		// TODO Auto-generated constructor stub
	}
	public EmployeeVO2(EmployeeVO_Login2 employeeLogin) {
		 this.employeeLogin = employeeLogin;
		 employeeLogin.setEmployee(this);
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public EmployeeVO_Login2 getEmployeeLogin() {
		return employeeLogin;
	}

	public void setEmployeeLogin(EmployeeVO_Login2 employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	@Override
	public String toString() {
		return "EmployeeVO2 [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
}