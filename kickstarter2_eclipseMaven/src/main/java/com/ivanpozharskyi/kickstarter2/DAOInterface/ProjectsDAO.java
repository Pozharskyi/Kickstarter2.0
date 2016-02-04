package com.ivanpozharskyi.kickstarter2.DAOInterface;

import java.util.List;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.entity.Project;

public interface ProjectsDAO extends DAO{
	int findSize() throws ProjectsDAOException;
	void addProject(String name, String description, int moneyGot,
			int moneyNeed, int daysLeft, int category, int user) throws ProjectsDAOException;
	void deleteProject(int id) throws ProjectsDAOException;
	List<Project> findAllProjects() throws ProjectsDAOException;
	Project findProjectById(int id) throws ProjectsDAOException;
	List<Project> findProjectByName(String name) throws ProjectsDAOException;
	List<Project> findProjectByUser(String userLogin)
			throws ProjectsDAOException;
	List<Project> findProjectsByCategory(int category)
			throws ProjectsDAOException;
}
