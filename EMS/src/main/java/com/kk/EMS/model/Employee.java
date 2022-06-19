package com.kk.EMS.model;

import java.util.Date;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="employees")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="eNo")
	private Integer eNo;
	@Column(name="eName")
	private String employeeName;
	@Column(name="doj")
	private Date doj;
	@Column(name="salary")
	private long salary;
	@OneToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name = "dId", referencedColumnName = "dId")
	private Department department;
	
	
	public Employee() {}


	
	public Employee(long id, Integer eNo, String eName, Date doj, long salary, Department department) {
		super();
		this.id = id;
		this.eNo = eNo;
		this.employeeName = eName;
		this.doj = doj;
		this.salary = salary;
		this.department = department;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Integer geteNo() {
		return eNo;
	}


	public void seteNo(Integer eNo) {
		this.eNo = eNo;
	}






	public String getEmployeeName() {
		return employeeName;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public Date getDoj() {
		return doj;
	}


	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department2) {
		this.department = department2;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", eNo=" + eNo + ", eName=" + employeeName + ", doj=" + doj + ", salary=" + salary
				+ ", department=" + department + "]";
	}
	
	
	
	

}
