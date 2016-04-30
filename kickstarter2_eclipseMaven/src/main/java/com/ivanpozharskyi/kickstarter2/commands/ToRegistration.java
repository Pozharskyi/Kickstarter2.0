package com.ivanpozharskyi.kickstarter2.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class ToRegistration implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws UsersDAOException, CategoriesDAOException, ProjectsDAOException {
		String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.REGISTRATION_PAGE_PATH);
		return page;
	}

}
