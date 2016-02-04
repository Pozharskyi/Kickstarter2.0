package com.ivanpozharskyi.kickstarter2.entity;

import java.io.Serializable;

public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private int moneyGot;
	private int moneyNeed;
	private int daysLeft;
	private int category;
	private int user;

	public Project(int id, String name, String description, int moneyGot,
			int moneyNeed, int daysLeft, int category, int user) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.moneyGot = moneyGot;
		this.moneyNeed = moneyNeed;
		this.daysLeft = daysLeft;
		this.category = category;
		this.user = user;
	}

	// public String getDetailDescription() {
	// String result = "id: " + id + " Name: " + name + " description: "
	// + description + " moneyGot: " + moneyGot + " moneyNeed: "
	// + moneyNeed + " daysLeft: " + daysLeft;
	// return result;
	// }

	public int getId() {
		return id;
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

	public int getMoneyGot() {
		return moneyGot;
	}

	public void setMoneyGot(int moneyGot) {
		this.moneyGot = moneyGot;
	}

	public int getMoneyNeed() {
		return moneyNeed;
	}

	public void setMoneyNeed(int moneyNeed) {
		this.moneyNeed = moneyNeed;
	}

	public int getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category;
		result = prime * result + daysLeft;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + moneyGot;
		result = prime * result + moneyNeed;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + user;
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
		if (!(obj instanceof Project)) {
			return false;
		}
		Project other = (Project) obj;
		if (category != other.category) {
			return false;
		}
		if (daysLeft != other.daysLeft) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (moneyGot != other.moneyGot) {
			return false;
		}
		if (moneyNeed != other.moneyNeed) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (user != other.user) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description="
				+ description + ", moneyGot=" + moneyGot + ", moneyNeed="
				+ moneyNeed + ", daysLeft=" + daysLeft + ", category="
				+ category + ", user=" + user + "]";
	}



	// public void addQuestionAndAnswers(QuestionStorage questionStorage) {
	// this.questionStorage = questionStorage;
	//
	// }
}
