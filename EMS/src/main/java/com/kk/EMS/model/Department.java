package com.kk.EMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dId;
	@Column(name="dName")
	private String dName;
	@Column(name="dCode")
	private String dCode;
	
	public Department() {}
	
	public Department(long dId, String dName, String dCode) {
		super();
		this.dId = dId;
		this.dName = dName;
		this.dCode = dCode;
	}

	public long getdId() {
		return dId;
	}

	public void setdId(long dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdCode() {
		return dCode;
	}

	public void setdCode(String dCode) {
		this.dCode = dCode;
	}

	@Override
	public String toString() {
		return "Department [dId=" + dId + ", dName=" + dName + ", dCode=" + dCode + "]";
	}
	
	
}
