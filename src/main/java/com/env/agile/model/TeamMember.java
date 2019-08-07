package com.env.agile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TeamMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "team_member_id", nullable = false, updatable = false)
	private long id;

	@Column(name = "name")
	public String name;

	@Column(name = "expertise")
	public String expertise;

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

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
}
