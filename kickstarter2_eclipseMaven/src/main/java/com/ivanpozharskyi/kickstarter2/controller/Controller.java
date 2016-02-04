package com.ivanpozharskyi.kickstarter2.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;
import com.ivanpozharskyi.kickstarter2.commands.Command;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;
import com.ivanpozharskyi.kickstarter2.manager.MessageManager;

public class Controller extends HttpServlet {
	 
	 RequestHelper requestHelper = RequestHelper.getInstance();
//
//	@Autowired
//	CategoriesDAO categories;
//	@Autowired
//	ProjectsDao projectsDao;
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//
//		WebApplicationContext context = ContextLoader
//				.getCurrentWebApplicationContext();
//		final AutowireCapableBeanFactory beanFactory = context
//				.getAutowireCapableBeanFactory();
//		beanFactory.autowireBean(this);
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (UsersDAOException | CategoriesDAOException | ProjectsDAOException e) {
		
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (UsersDAOException | CategoriesDAOException | ProjectsDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws UsersDAOException, ServletException, IOException, CategoriesDAOException, ProjectsDAOException {
		        String page = null;
		        try{
		         
		            Command command=requestHelper.readCommand(request);
		      
		            page = command.execute(request,response);
		         
		        }catch (UsersDAOException e){
		            e.printStackTrace();
		         
		            request.setAttribute("errorMessage",
		                    MessageManager.getInstance().getProperty(
		                    MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
		      
		            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
		        }
		     
		        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		        dispatcher.forward(request, response);

		    }

}
