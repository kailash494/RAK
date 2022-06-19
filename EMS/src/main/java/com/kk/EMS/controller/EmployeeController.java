package com.kk.EMS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kk.EMS.exception.ResourceNotFoundException;
import com.kk.EMS.model.Department;
import com.kk.EMS.model.Employee;
import com.kk.EMS.repository.DepartmentRepository;
import com.kk.EMS.repository.EmployeeRepository;
import com.kk.EMS.repository.EmployeeRepositoryCustomImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeRepositoryCustomImpl empCustomRepo;
	@Autowired
	private DepartmentRepository departmentRepository;

	// get list of employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	// add employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	// get employee by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found :" + id));
		return ResponseEntity.ok(employee);
	}

//	 get employee by name or eNo
	@PostMapping("/employees/search")
	public ResponseEntity<Employee> getEmployeeByEName(@RequestBody Employee employeeInput) {

		Employee employee = empCustomRepo.findUserByEmployeeNoOrEmployeeName(employeeInput.geteNo(),
				employeeInput.getEmployeeName());
		if (employee == null) {
			throw new ResourceNotFoundException("Employee not found ");
		}

		return ResponseEntity.ok(employee);
	}

	// update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found :" + id));
		Department department = departmentRepository.getById(employeeDetails.getDepartment().getdId());

		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.seteNo(employeeDetails.geteNo());
		employee.setDoj(employeeDetails.getDoj());
		employee.setSalary(employeeDetails.getSalary());

		employee.setDepartment(department);

		employeeRepository.save(employee);

		return ResponseEntity.ok(employee);

	}

	// delete employee
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> DeleteEmployee(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found :" + id));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);

		return ResponseEntity.ok(response);

	}

}
