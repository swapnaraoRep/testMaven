package com.SampleServlet1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="employee_login2")
public class EmployeeVO_Login2 {
    @GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="employee"))
    @Id
	@Column(name="id")
	@GeneratedValue(generator="gen")
	private Integer id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    private EmployeeVO2 employee;
	

	

	public EmployeeVO_Login2() {
		
	}

	/*public EmployeeVO_Login2(EmployeeVO2 employeeVO) {
		 this.employee = employeeVO;
		 employee.setEmployeeLogin(this);
	}*/

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public EmployeeVO2 getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeVO2 employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeVO_Login2 [id=" + id + ", firstName=" + firstName + ", password=" + password + ", role=" + role
				+ ", employee=" + employee + "]";
	}
}
