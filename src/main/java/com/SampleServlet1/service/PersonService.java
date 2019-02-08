package com.SampleServlet1.service;



import java.util.List;

import com.SampleServlet1.model.EmployeeVO;
import com.SampleServlet1.model.Person;


public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);

	
}
