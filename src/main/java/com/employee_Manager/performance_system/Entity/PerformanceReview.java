package com.employee_Manager.performance_system.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class PerformanceReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer attendanceScore;
	private Integer taskScore;
	private Integer feedbackScore;
	private Integer qualityScore;
	private Double overallScore;
	private String remarks;
	private LocalDate reviewDate;

	@ManyToOne
	private Employees employees;

	@ManyToOne
	private Employees reviewBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

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

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Employees getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(Employees reviewBy) {
		this.reviewBy = reviewBy;
	}

	public PerformanceReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PerformanceReview [id=" + id + ", attendanceScore=" + attendanceScore + ", taskScore=" + taskScore
				+ ", feedbackScore=" + feedbackScore + ", qualityScore=" + qualityScore + ", overallScore="
				+ overallScore + ", remarks=" + remarks + ", reviewDate=" + reviewDate + "]";
	}

}
