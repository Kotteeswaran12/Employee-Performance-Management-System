package com.employee_Manager.performance_system.RequestDTO;

import java.time.LocalDate;


public class PerformanceReviewRequestDTO {


	private Integer attendanceScore;
	private Integer taskScore;
	private Integer feedbackScore;
	private Integer qualityScore;
	private Double overallScore;
	private String remarks;
	private LocalDate reviewDate;

	
	

	public Integer getAttendanceScore() {
		return attendanceScore;
	}

	public void setAttendanceScore(Integer attendanceScore) {
		this.attendanceScore = attendanceScore;
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

	public Integer getQualityScore() {
		return qualityScore;
	}

	public void setQualityScore(Integer qualityScore) {
		this.qualityScore = qualityScore;
	}

	public Double getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(Double overallScore) {
		this.overallScore = overallScore;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	

	@Override
	public String toString() {
		return "PerformanceReviewDTO [ attendanceScore=" + attendanceScore + ", taskScore=" + taskScore
				+ ", feedbackScore=" + feedbackScore + ", qualityScore=" + qualityScore + ", overallScore="
				+ overallScore + ", remarks=" + remarks + ", reviewDate=" + reviewDate + "]";
	}

}
