package com.env.agile.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="description")
	public String description;
	
	@Column(name="owner")
	public String owner;
	
	@Column(name="creationDate")
	public Date creationDate;
	
	@Column(name="projectPhase")
	public String projectPhase;
	
	@Column(name="description")
	//@OneToMany(mappedBy="packing",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public ArrayList<TeamMember> teamMembers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getProjectPhase() {
		return projectPhase;
	}

	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}

	public ArrayList<TeamMember> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(ArrayList<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
