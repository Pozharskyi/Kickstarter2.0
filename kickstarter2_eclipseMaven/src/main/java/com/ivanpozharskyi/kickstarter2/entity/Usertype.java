package com.ivanpozharskyi.kickstarter2.entity;

import java.io.Serializable;

public class Usertype implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String type;
	public Usertype(int id, String type) {
		this.id = id;
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (!(obj instanceof Usertype)) {
			return false;
		}
		Usertype other = (Usertype) obj;
		if (id != other.id) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Usertype [id=" + id + ", type=" + type + "]";
	}
	
}
