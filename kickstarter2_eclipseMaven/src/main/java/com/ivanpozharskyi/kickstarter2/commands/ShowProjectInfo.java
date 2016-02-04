package com.ivanpozharskyi.kickstarter2.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.ProjectsDAO;
import com.ivanpozharskyi.kickstarter2.entity.Project;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class ShowProjectInfo implements Command{
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ProjectsDAOException {

//	        log.log(Level.INFO, "RoutesCommand instance: created");
	        

			DAOFactory daoFactory = DAOFactory.getInstanse();
		    ProjectsDAO projectsDao =  (ProjectsDAO) daoFactory.getDAO(DAOType.PROJECTSDAO);
		    int projectId = Integer.parseInt(request.getParameter("project"));
//		    List<Project> projects = projectsDao.findAllProjects();

		    Project project = projectsDao.findProjectById(projectId);

	     
	        request.setAttribute("project", project);
//	        log.log(Level.INFO, "RoutesCommand: routesDAO.findAll(): ListSize: " + listRoutes.size());
	        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.PROJECTINFO_PAGE_PATH);
	        return page;
	    }
}
