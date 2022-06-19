package com.kk.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kk.EMS.model.Department;
import com.kk.EMS.repository.DepartmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/")
public class DepartmentController {

		@Autowired
		private DepartmentRepository departmentRepository;

		// get list of department
		@GetMapping("/department")
		public List<Department> getDepartment() {
			return departmentRepository.findAll();
		}

}
