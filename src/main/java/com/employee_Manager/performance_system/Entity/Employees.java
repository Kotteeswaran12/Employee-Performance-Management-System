package com.employee_Manager.performance_system.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true , nullable = false , name = "emp_code")
	private String empcode;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "larst_name")
	private String lastname;
	private Long phone;
	private String gender;
	private LocalDate dob;
	private String address;
	private LocalDate joindate;
	private double salary;
	private String designation;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	@JsonBackReference
	private Employees manager;

	@OneToOne
	@JoinColumn(name = "user_id", unique = true)
	private UserInfo user;

	@OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Employees> subordinate = new ArrayList<Employees>();

	@ManyToOne
	@JoinColumn(name = "department_Id")
	private Departments departments;

	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<ApplyLeave> applyLeaves = new ArrayList<ApplyLeave>();

	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<Attendance> attendances = new ArrayList<Attendance>();

	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<EMPFeedBack> feedBacks = new ArrayList<EMPFeedBack>();

	@OneToMany(mappedBy = "assignedTo")
	private List<TaskAssignments> assignedTask = new ArrayList<TaskAssignments>();

	@OneToMany(mappedBy = "assignedBy")
	private List<TaskAssignments> taskAssignmentsByMe = new ArrayList<TaskAssignments>();

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public List<ApplyLeave> getApplyLeaves() {
		return applyLeaves;
	}

	public void setApplyLeaves(List<ApplyLeave> applyLeaves) {
		this.applyLeaves = applyLeaves;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getJoindate() {
		return joindate;
	}

	public void setJoindate(LocalDate joindate) {
		this.joindate = joindate;
	}

	public double getSalary() {
		return salary;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public List<EMPFeedBack> getFeedBacks() {
		return feedBacks;
	}

	public void setFeedBacks(List<EMPFeedBack> feedBacks) {
		this.feedBacks = feedBacks;
	}

	public List<TaskAssignments> getAssignedTask() {
		return assignedTask;
	}

	public void setAssignedTask(List<TaskAssignments> assignedTask) {
		this.assignedTask = assignedTask;
	}

	public List<TaskAssignments> getTaskAssignmentsByMe() {
		return taskAssignmentsByMe;
	}

	public void setTaskAssignmentsByMe(List<TaskAssignments> taskAssignmentsByMe) {
		this.taskAssignmentsByMe = taskAssignmentsByMe;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public List<Employees> getSubordinate() {
		return subordinate;
	}

	public void setSubordinate(List<Employees> subordinate) {
		this.subordinate = subordinate;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", emp_code=" + empcode + ", first_name=" + firstname + ", last_name="
				+ lastname + ", phone=" + phone + ", gender=" + gender + ", dob=" + dob + ", address=" + address
				+ ", joindate=" + joindate + ", salary=" + salary + ", designation=" + designation + ", departments="
				+ departments + "]";
	}

}
