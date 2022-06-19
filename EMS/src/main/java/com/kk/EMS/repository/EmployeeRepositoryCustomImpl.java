package com.kk.EMS.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.kk.EMS.model.Employee;

@Component
public class EmployeeRepositoryCustomImpl implements EmployeeRespositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee findUserByEmployeeNoOrEmployeeName(Integer eNo, String eName) {
		String query = "select e from Employee e where ";
		Boolean flag = false;
		if (eNo != null) {
			query = query + " e.eNo=" + eNo;
			flag = true;
		}

		if (eName != null && !eName.equals("")) {
			if (flag) {
				query = query + " and e.employeeName='" + eName + "'";
			} else
				query = query + " e.employeeName='" + eName + "'";
		}

		Query q = entityManager.createQuery(query);
		if (q.getResultList().isEmpty()) {
			return null;
		}
		Employee e = (Employee) q.getResultList().get(0);

		return e;
	}

}
