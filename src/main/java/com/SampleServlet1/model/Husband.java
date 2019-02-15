package com.SampleServlet1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Husband",uniqueConstraints = 
{ @UniqueConstraint(columnNames = { "id" }) })
public class Husband {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="husbandName" ,length = 50, nullable = false)
	private String husbandName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHusbandName() {
		return husbandName;
	}
	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}
	
	@Override
	public String toString() {
		return "Husband [id=" + id + ", husbandName=" + husbandName + "]";
	}

}
