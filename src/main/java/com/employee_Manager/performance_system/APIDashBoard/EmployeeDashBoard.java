package com.employee_Manager.performance_system.APIDashBoard;

public class EmployeeDashBoard {

	private Integer attendaceScore;
	private Integer taskScore;
	private Integer feedbackScore;
	private Double overAllScore;
	private Integer pendingTask;

	public EmployeeDashBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAttendaceScore() {
		return attendaceScore;
	}

	public void setAttendaceScore(Integer attendaceScore) {
		this.attendaceScore = attendaceScore;
	}

	public Integer getTaskScore() {
		return taskScore;
	}

	public void setTaskScore(Integer taskScore) {
		this.taskScore = taskScore;
	}

	public Integer getFeedbackScore() {
		return feedbackScore;
	}

	public void setFeedbackScore(Integer feedbackScore) {
		this.feedbackScore = feedbackScore;
	}

	public Double getOverAllScore() {
		return overAllScore;
	}

	public void setOverAllScore(Double overAllScore) {
		this.overAllScore = overAllScore;
	}

	public Integer getPendingTask() {
		return pendingTask;
	}

	public void setPendingTask(Integer pendingTask) {
		this.pendingTask = pendingTask;
	}

	@Override
	public String toString() {
		return "EmployeeDashBoard [attendaceScore=" + attendaceScore + ", taskScore=" + taskScore + ", feedbackScore="
				+ feedbackScore + ", overAllScore=" + overAllScore + ", pendingTask=" + pendingTask + "]";
	}

}
