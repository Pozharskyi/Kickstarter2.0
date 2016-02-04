package com.ivanpozharskyi.kickstarter2.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.ProjectsDAO;
import com.ivanpozharskyi.kickstarter2.entity.User;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class AddProjectCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ProjectsDAOException {
		ProjectsDAO projectsDao = (ProjectsDAO) DAOFactory.getInstanse()
				.getDAO(DAOType.PROJECTSDAO);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int moneyGot = Integer.parseInt(request.getParameter("moneyGot"));
		int moneyNeed = Integer.parseInt(request.getParameter("moneyNeed"));
		int daysLeft = Integer.parseInt(request.getParameter("daysLeft"));
		int category = Integer.parseInt(request.getParameter("category"));
//		int user = Integer.parseInt(request.getParameter("user"));
		User user = (User) request.getSession().getAttribute("user");
		projectsDao.addProject(name, description, moneyGot, moneyNeed,
				daysLeft, category, user.getId()); // add project to DB

		String page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.PROJECTS_PAGE_PATH);
		return page;
	}

}
