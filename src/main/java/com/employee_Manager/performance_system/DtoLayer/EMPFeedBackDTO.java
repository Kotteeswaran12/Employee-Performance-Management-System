package com.employee_Manager.performance_system.DtoLayer;


public class EMPFeedBackDTO {

	private Integer id;

	private Integer communicationScore;
	private Integer teamworkScore;
	private Integer helpfullnessScore;
	private Integer knowledgeSharingScore;
	private String comments;

	private String employeName;

	private String reviewedBy;

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

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	@Override
	public String toString() {
		return "EMPFeedBackDTO [id=" + id + ", communicationScore=" + communicationScore + ", teamworkScore="
				+ teamworkScore + ", helpfullnessScore=" + helpfullnessScore + ", knowledgeSharingScore="
				+ knowledgeSharingScore + ", comments=" + comments + ", employeName=" + employeName + ", reviewedBy="
				+ reviewedBy + "]";
	}

}
