package com.SampleServlet1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity

@Table(name = "department",uniqueConstraints = 
                           { @UniqueConstraint(columnNames = { "deptId" }) })
public class Department {
	@Id
	@Column(name="deptId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deptId;
	@Column(name="deptName",length = 50, nullable = false)
	private String deptName;
	

	public Department() {
		
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/*public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}*/
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
}
