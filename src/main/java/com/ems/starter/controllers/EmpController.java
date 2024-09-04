package com.ems.starter.controllers;

import com.ems.starter.entities.Employee;
import com.ems.starter.services.EmpService;
import com.ems.starter.services.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	@Autowired
	private ImgService imgService;


	@Value("${project.image}")
	private String path;

	@GetMapping("/")
	public String home(Model model) {
		List<Employee> employees = service.getAllEmployees();
		Collections.reverse(employees);
		model.addAttribute("employees", employees);
		return "index";
	}
	
	@GetMapping("/add")
	public String addEmpForm(Model model) {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session,@RequestParam("fileImage") MultipartFile image) {
		String filepath = imgService.uploadImage(path, image);
		Employee emp = service.searchByEmail(e.getEmail());
		if(emp == null){
			e.setImg(filepath);
			service.addEmp(e);
			session.setAttribute("msg", "Employee Added Successfully....");
			return "redirect:/";
		}

		return "error";
	}
}
