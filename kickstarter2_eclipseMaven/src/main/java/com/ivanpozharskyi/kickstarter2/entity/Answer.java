package com.ivanpozharskyi.kickstarter2.entity;

import java.io.Serializable;

public class Answer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int question;
	public Answer(int id, String name, int question) {
		this.id = id;
		this.name = name;
		this.question = question;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + question;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) obj;
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (question != other.question) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", name=" + name + ", question=" + question
				+ "]";
	}
	
}
