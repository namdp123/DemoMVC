package controller;

import java.sql.SQLException;

import model.EmployeeModel;
import object.Employee;

public class EmployeeController {
	private EmployeeModel model;

	 public EmployeeController() {
	   model = new EmployeeModel();
	 }

	 public int insertEmployee(Employee valueObject) {
	   int cnt = 0;
	   try {
	     cnt = model.insert(valueObject);
	   } catch (SQLException ex) {
	      System.err.println("Error: " + ex.toString());
	   }
	   return cnt;
	 }

	 public Employee displayEmployee(Employee emp) {
	   Employee valueObject = null;
	   try {
		   valueObject = model.display(emp);
	   } catch (SQLException ex) {
	     System.err.println("Error: " + ex.toString());
	   }
	   return valueObject;
	 }

}
