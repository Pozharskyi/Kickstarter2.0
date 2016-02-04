package com.ivanpozharskyi.kickstarter2.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.DAO;
import com.ivanpozharskyi.kickstarter2.DAOInterface.UsersDAO;
import com.ivanpozharskyi.kickstarter2.entity.User;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;
import com.ivanpozharskyi.kickstarter2.manager.MessageManager;

public class LoginCommand implements Command {

	private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

   public String execute(HttpServletRequest request, HttpServletResponse response)
           throws UsersDAOException{
	   DAOFactory daoFactory = DAOFactory.getInstanse();
	   UsersDAO usersDao =  (UsersDAO) daoFactory.getDAO(DAOType.USERSDAO);
       String page = null;

       String login = request.getParameter(PARAM_NAME_LOGIN);
       String pass = request.getParameter(PARAM_NAME_PASSWORD);

       if (usersDao.checkLogin(login,pass)){
    	   User user = usersDao.findUserByLogin(login);
           request.setAttribute("user",login);
           request.getSession().setAttribute("user", user);
  
           page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.MAIN_PAGE_PATH);
       }else{
           request.setAttribute("errorMessage",
                   MessageManager.getInstance().getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
           page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
       }
       return page;
   }
	
}
