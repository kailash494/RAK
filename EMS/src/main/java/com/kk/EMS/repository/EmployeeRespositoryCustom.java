package com.kk.EMS.repository;

import com.kk.EMS.model.Employee;

public interface EmployeeRespositoryCustom {
	Employee findUserByEmployeeNoOrEmployeeName(Integer eNo,String eName);
}
