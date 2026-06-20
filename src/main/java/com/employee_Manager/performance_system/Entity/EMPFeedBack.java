package com.employee_Manager.performance_system.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_feedback")
public class EMPFeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer communicationScore;
	private Integer teamworkScore;
	private Integer helpfullnessScore;
	private Integer knowledgeSharingScore;
	private String comments;

	@ManyToOne
	private Employees employees;

	@ManyToOne
	private Employees reviewedBy;
	
	

	public EMPFeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommunicationScore() {
		return communicationScore;
	}

	public void setCommunicationScore(Integer communicationScore) {
		this.communicationScore = communicationScore;
	}

	public Integer getTeamworkScore() {
		return teamworkScore;
	}

	public void setTeamworkScore(Integer teamworkScore) {
		this.teamworkScore = teamworkScore;
	}

	public Integer getHelpfullnessScore() {
		return helpfullnessScore;
	}

	public void setHelpfullnessScore(Integer helpfullnessScore) {
		this.helpfullnessScore = helpfullnessScore;
	}

	public Integer getKnowledgeSharingScore() {
		return knowledgeSharingScore;
	}

	public void setKnowledgeSharingScore(Integer knowledgeSharingScore) {
		this.knowledgeSharingScore = knowledgeSharingScore;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Employees getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(Employees reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	@Override
	public String toString() {
		return "EMPFeedBack [id=" + id + ", communicationScore=" + communicationScore + ", teamworkScore="
				+ teamworkScore + ", helpfullnessScore=" + helpfullnessScore + ", knowledgeSharingScore="
				+ knowledgeSharingScore + ", comments=" + comments + "]";
	}

}
