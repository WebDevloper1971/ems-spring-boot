package com.ems.starter.services;

import com.ems.starter.entities.Employee;
import com.ems.starter.repositories.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}

	public void delEmp(Long id) {
		repo.deleteById(id);
	}

	public Employee searchByEmail(String email) {
		ArrayList<Employee> empList = (ArrayList<Employee>) repo.findAll();
		for(Employee emp : empList){
			if(emp.getEmail().equals(email)){
				return emp;
			}
		}
		return null;
	}

	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
}
