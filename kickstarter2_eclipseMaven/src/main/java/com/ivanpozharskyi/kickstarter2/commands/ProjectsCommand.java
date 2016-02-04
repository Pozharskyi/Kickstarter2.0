package com.ivanpozharskyi.kickstarter2.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.CategoriesDAO;
import com.ivanpozharskyi.kickstarter2.DAOInterface.ProjectsDAO;
import com.ivanpozharskyi.kickstarter2.entity.Category;
import com.ivanpozharskyi.kickstarter2.entity.Project;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class ProjectsCommand implements Command {
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ProjectsDAOException {

//	        log.log(Level.INFO, "RoutesCommand instance: created");
	        

			DAOFactory daoFactory = DAOFactory.getInstanse();
		    ProjectsDAO projectsDao =  (ProjectsDAO) daoFactory.getDAO(DAOType.PROJECTSDAO);
		    int category = Integer.parseInt(request.getParameter("category"));
//		    List<Project> projects = projectsDao.findAllProjects();

		    List<Project> projects = projectsDao.findProjectsByCategory(category);

	        request.setAttribute("category", category);
	        request.setAttribute("projects", projects);
//	        log.log(Level.INFO, "RoutesCommand: routesDAO.findAll(): ListSize: " + listRoutes.size());
	        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.PROJECTS_PAGE_PATH);
	        return page;
	    }
}
