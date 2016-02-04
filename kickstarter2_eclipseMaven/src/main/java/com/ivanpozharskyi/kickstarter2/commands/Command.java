package com.ivanpozharskyi.kickstarter2.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;

public interface Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws UsersDAOException, CategoriesDAOException, ProjectsDAOException;//TO DO throws
}
