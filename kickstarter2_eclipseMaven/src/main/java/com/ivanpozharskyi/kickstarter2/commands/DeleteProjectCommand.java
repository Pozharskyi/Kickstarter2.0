package com.ivanpozharskyi.kickstarter2.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.ProjectsDAO;
import com.ivanpozharskyi.kickstarter2.entity.Project;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class DeleteProjectCommand implements Command{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ProjectsDAOException {
		DAOFactory daoFactory = DAOFactory.getInstanse();
	    ProjectsDAO projectsDao =  (ProjectsDAO) daoFactory.getDAO(DAOType.PROJECTSDAO);
	    int projectId = Integer.parseInt(request.getParameter("project"));
//	    List<Project> projects = projectsDao.findAllProjects();

	    projectsDao.deleteProject(projectId);

     
        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.PROJECTS_PAGE_PATH);
        return page;
    }
	

}
