package com.ivanpozharskyi.kickstarter2.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOFactory;
import com.ivanpozharskyi.kickstarter2.DAOFactory.DAOType;
import com.ivanpozharskyi.kickstarter2.DAOInterface.UsersDAO;
import com.ivanpozharskyi.kickstarter2.entity.User;
import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;
import com.ivanpozharskyi.kickstarter2.manager.MessageManager;

public class RegistrationCommand implements Command {
	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String LOGIN = "login";

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws UsersDAOException {
		DAOFactory daoFactory = DAOFactory.getInstanse();
		UsersDAO usersDao = (UsersDAO) daoFactory.getDAO(DAOType.USERSDAO);
		String page = null;

		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		String email = request.getParameter(EMAIL);
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		usersDao.addUser(login, password, email, firstName, lastName);	//add user in DB
		User user =  usersDao.findUserByLogin(login);
		request.getSession().setAttribute("user", user);
//		request.getSession().setAttribute("password", password);
		request.setAttribute("user", login);
		page = ConfigurationManager.getInstance().getProperty(
				ConfigurationManager.MAIN_PAGE_PATH);
		
		return page;
	}
}
