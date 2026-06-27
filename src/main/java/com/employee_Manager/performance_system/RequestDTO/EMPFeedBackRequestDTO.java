package com.employee_Manager.performance_system.RequestDTO;


public class EMPFeedBackRequestDTO {

	

	private Integer communicationScore;
	private Integer teamworkScore;
	private Integer helpfullnessScore;
	private Integer knowledgeSharingScore;
	private String comments;

	
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

	

	@Override
	public String toString() {
		return "EMPFeedBackDTO [ communicationScore=" + communicationScore + ", teamworkScore="
				+ teamworkScore + ", helpfullnessScore=" + helpfullnessScore + ", knowledgeSharingScore="
				+ knowledgeSharingScore + ", comments=" + comments + "]";
	}

}
