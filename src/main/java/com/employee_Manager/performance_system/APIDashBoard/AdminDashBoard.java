package com.employee_Manager.performance_system.APIDashBoard;

public class AdminDashBoard {

	private Integer totalEmployees;
	private Integer totalManagers;
	private Integer totalDepartments;
	private Integer pendingLeaves;
	private Integer completedTask;

	public AdminDashBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTotalEmployees() {
		return totalEmployees;
	}

	public void setTotalEmployees(Integer totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

	public Integer getTotalManagers() {
		return totalManagers;
	}

	public void setTotalManagers(Integer totalManagers) {
		this.totalManagers = totalManagers;
	}

	public Integer getTotalDepartments() {
		return totalDepartments;
	}

	public void setTotalDepartments(Integer totalDepartments) {
		this.totalDepartments = totalDepartments;
	}

	public Integer getPendingLeaves() {
		return pendingLeaves;
	}

	public void setPendingLeaves(Integer pendingLeaves) {
		this.pendingLeaves = pendingLeaves;
	}

	public Integer getCompletedTask() {
		return completedTask;
	}

	public void setCompletedTask(Integer completedTask) {
		this.completedTask = completedTask;
	}

	@Override
	public String toString() {
		return "AdminDashBoard [totalEmployees=" + totalEmployees + ", totalManagers=" + totalManagers
				+ ", totalDepartments=" + totalDepartments + ", pendingLeaves=" + pendingLeaves + ", completedTask="
				+ completedTask + "]";
	}

}
