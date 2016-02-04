package com.ivanpozharskyi.kickstarter2.DAOExeptions;

public class ProjectsDAOException extends Exception{

	public ProjectsDAOException() {
		super();
	}

	public ProjectsDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProjectsDAOException(String message) {
		super(message);
	}
	
}
