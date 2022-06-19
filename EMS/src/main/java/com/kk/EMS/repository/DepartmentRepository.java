package com.kk.EMS.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kk.EMS.model.Department;
import com.kk.EMS.model.Employee;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	
}
