package com.ivanpozharskyi.kickstarter2.commands;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.CategoriesDAO;
import com.ivanpozharskyi.kickstarter2.DAOInterface.UsersDAO;
import com.ivanpozharskyi.kickstarter2.entity.Category;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class CategoriesCommand implements Command{

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws CategoriesDAOException {

//	        log.log(Level.INFO, "RoutesCommand instance: created");
	        

			DAOFactory daoFactory = DAOFactory.getInstanse();
		    CategoriesDAO categoriesDao =  (CategoriesDAO) daoFactory.getDAO(DAOType.CATEGORIESDAO);
		    List<Category> categories = categoriesDao.findAll();

	        
	        request.setAttribute("categories", categories);
//	        log.log(Level.INFO, "RoutesCommand: routesDAO.findAll(): ListSize: " + listRoutes.size());
	        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.CATEGORIES_PAGE_PATH);
	        return page;
	    }

	

}
