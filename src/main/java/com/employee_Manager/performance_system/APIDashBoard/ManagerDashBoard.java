package com.employee_Manager.performance_system.APIDashBoard;

public class ManagerDashBoard {

	private Integer teamSize;
	private Integer pendingLeave;
	private Integer pendingReviews;
	private Integer taskAssigned;

	public ManagerDashBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public Integer getPendingLeave() {
		return pendingLeave;
	}

	public void setPendingLeave(Integer pendingLeave) {
		this.pendingLeave = pendingLeave;
	}

	public Integer getPendingReviews() {
		return pendingReviews;
	}

	public void setPendingReviews(Integer pendingReviews) {
		this.pendingReviews = pendingReviews;
	}

	public Integer getTaskAssigned() {
		return taskAssigned;
	}

	public void setTaskAssigned(Integer taskAssigned) {
		this.taskAssigned = taskAssigned;
	}

	@Override
	public String toString() {
		return "ManagerDashBoard [teamSize=" + teamSize + ", pendingLeave=" + pendingLeave + ", pendingReviews="
				+ pendingReviews + ", taskAssigned=" + taskAssigned + "]";
	}

}
