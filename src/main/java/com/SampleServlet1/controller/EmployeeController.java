package com.SampleServlet1.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SampleServlet1.model.Department;
import com.SampleServlet1.model.Employee;
import com.SampleServlet1.model.EmployeeVO;
import com.SampleServlet1.model.EmployeeVO2;
import com.SampleServlet1.model.EmployeeVO_Login;
import com.SampleServlet1.model.EmployeeVO_Login2;
import com.SampleServlet1.model.Husband;
import com.SampleServlet1.model.Wife;
import com.SampleServlet1.service.EmployeeManager;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeManager manager;
	private final static Logger logger = Logger.getLogger(EmployeeController.class);
	private Validator validator;

	public EmployeeController() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@RequestMapping("/employee")
	public String LoadForm(Model model) {
		model.addAttribute("employeeVO", new EmployeeVO());
		return "AddEmployee";
	}

	@RequestMapping("/getAllEmployees")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees", manager.getAllEmployees());

		return "employeesListDisplay";
	}

	@RequestMapping("/checkEmployee")
	public String checkEmployee(@ModelAttribute("employeeVO") EmployeeVO employeeVO, BindingResult result,
			Model model) {
		System.out.println(result + "\n" + employeeVO.getFirstName());
		if (employeeVO.getEmail().isEmpty()) {
			logger.debug("email.NotEmpty");
			result.rejectValue("email", "email.NotEmpty");

			return "AddEmployee";
		}
		if (employeeVO.getFirstName().isEmpty()) {
			logger.debug("firstName.NotEmpty");
			result.rejectValue("firstName", "firstName.NotEmpty");
			return "AddEmployee";
		} else {
			model.addAttribute("employees", manager.getAllEmployees());
			return "employeesListDisplay";
		}
		// manager.add
		// application code

	}

	@RequestMapping("/AddEmployee")
	public String addEmployee(@ModelAttribute("employeeVO") EmployeeVO employeeVO, BindingResult result, Model model) {
		System.out.println(result + "\n" + employeeVO.getFirstName());
		Set<ConstraintViolation<EmployeeVO>> violations = validator.validate(employeeVO);

		for (ConstraintViolation<EmployeeVO> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			System.out.println("message" + message);
			result.addError(new FieldError("employeeVO", propertyPath,

					"Invalid " + propertyPath + "(" + message + ")"));
		}
		if (result.hasErrors()) {
			System.out.println("IN IF CONDITION");
			return "AddEmployee";
		}

		else {
			System.out.println("e CONDITION");
			manager.addPerson(employeeVO);
			model.addAttribute("employeeVO", employeeVO);
			return "employeesListDisplay";
		}

		// manager.add
		// application code

	}

	@RequestMapping("/employee-management/employees/update")
	public String updateEmployee(EmployeeVO employee) {
		// application code
		return "employeesDetail";
	}

	@RequestMapping(value = { "/employee-management/employees/remove", "/employee-management/employees/delete" })
	public String removeEmployee(@RequestParam("id") String employeeId) {
		// application code
		return "employeesList";
	}
	
	@RequestMapping("/employee1M")
	public String addEmployeeDepartment()
	{
		Employee emp = new Employee(); 
		Department dept1 = new Department();
		Department dept2 = new Department(); 
		//emp.setId(2); 
		
		emp.setFirstName("Emp1");
		emp.setLastName("Emp1");
		emp.setEmail("swapna@gmail.com");
		//dept1.setDeptId(1); 
		dept1.setDeptName("Dept1"); 
		//dept2.setDeptId(2); 
		dept2.setDeptName("Dept2"); 
		emp.getDept().add(dept1); 
		emp.getDept().add(dept2);
		manager.addEmplyeeDepartment(emp);
		return "helloWorld";
	}
	@RequestMapping("/LoadEmployee1To1")
	public String LoadEmployeeAndRole(Model model)
	{
		model.addAttribute("employee", new EmployeeVO());
		return "Employee1To1";
		
	}
	@RequestMapping("/LoadEmployee1To1Bidirectional")
	public String LoadEmployeeAndRoleBi(Model model)
	{
		model.addAttribute("employee", new EmployeeVO2());
		return "Employee1To1";
		
	}
	@RequestMapping("/employee1-1")
	public String addEmployeeAndRole(@ModelAttribute("employee") EmployeeVO2 employeeVO,Model model)
	{
	//1-1 unidirectional
		/*employeeVO.getEmployeeLogin().setFirstName(employeeVO.getFirstName());
		manager.addEmplyeeRole(employeeVO);*/
		
	//1-1 bidirectinal w/o joinColumn
		
		employeeVO.setFirstName("Hello");
		employeeVO.setLastName("checking");
		employeeVO.setEmail("Take@gmail.com");
		employeeVO.getEmployeeLogin().setFirstName(employeeVO.getFirstName());
		employeeVO.getEmployeeLogin().setPassword(employeeVO.getFirstName());
		employeeVO.getEmployeeLogin().setRole(employeeVO.getFirstName());
		employeeVO.setEmployeeLogin(employeeVO.getEmployeeLogin());
		employeeVO.getEmployeeLogin().setEmployee(employeeVO);
		/*EmployeeVO_Login2 employeeLogin=new EmployeeVO_Login2();
		employeeLogin.setFirstName("checking");
		employeeLogin.setPassword("checking");
		employeeLogin.setRole("checking");
		EmployeeVO2 employee= employeeVO.getEmployeeLogin().getEmployee();
		
		 if (employee == null)
			 employee = new EmployeeVO2(employeeLogin); 
		
		 System.out.println("((((((((((((("+employee.getFirstName());
		 */
		
		System.out.println("before"+employeeVO);
		manager.addEmplyeeRoleBIDirectional(employeeVO);
		
		return "helloWorld";
	}
	@RequestMapping("/createDepartment")
	public String addEmployeeAndRole()
	{
		Department dept = new Department(); 
		
		dept.setDeptName("IT");
		manager.addDepartment(dept);
		return "helloWorld";
	}
	@RequestMapping("/create1To1Withprimary")
	public String addWifeAndHusband()
	{
		Husband hus=new Husband();
		hus.setHusbandName("Helll0");
		Wife w=new Wife();
		w.setWifeName("Hai");
		
		manager.addHusband(hus);
		w.setId(hus.getId());
		w.setHusband(hus);
        manager.addWife(w);
    
		return "helloWorld";
	}
	
	
}