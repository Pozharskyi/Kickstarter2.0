package com.ivanpozharskyi.kickstarter2.entity;

import java.io.Serializable;

public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	
	public Category(int id,String name){
		this.id = id;
		this.name = name;
	}
	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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
		if (!(obj instanceof Category)) {
			return false;
		}
		Category other = (Category) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "Category [name=" + name + ", id=" + id + "]";
	}
	
	

}
