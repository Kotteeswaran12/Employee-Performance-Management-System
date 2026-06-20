package com.employee_Manager.performance_system.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dept")
public class Departments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dept;

	@OneToMany(mappedBy = "departments", cascade = CascadeType.ALL)
//	@JsonManagedReference
	private List<Employees> employees = new ArrayList<Employees>();

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Departments [id=" + id + ", dept=" + dept + ", employees=" + employees + "]";
	}

	

}
