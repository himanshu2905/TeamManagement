package com.team.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private int rating;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
	
}
