package com.ivanpozharskyi.kickstarter2.DAOFactory;

import com.ivanpozharskyi.kickstarter2.DAOImpl.AnswersDAOImpl;
import com.ivanpozharskyi.kickstarter2.DAOImpl.CategoriesDAOImpl;
import com.ivanpozharskyi.kickstarter2.DAOImpl.ProjectsDAOImpl;
import com.ivanpozharskyi.kickstarter2.DAOImpl.QuestionsDAOImpl;
import com.ivanpozharskyi.kickstarter2.DAOImpl.QuotesDAOImpl;
import com.ivanpozharskyi.kickstarter2.DAOImpl.UsersDAOImpl;
import com.ivanpozharskyi.kickstarter2.DAOInterface.DAO;

public class DAOFactory {
	private static DAOFactory instance;
	private DAOFactory(){
		
	}
	public static DAOFactory getInstanse(){
		if(instance == null){
			instance = new DAOFactory();
		}
		return instance;
	}
	public DAO getDAO(DAOType daoType){
		DAO result = null;
		switch(daoType){
		case USERSDAO: result =  new UsersDAOImpl(); break;
		case QUESTIONSDAO: result =  new QuestionsDAOImpl(); break;
		case ANSWERSDAO: result =  new AnswersDAOImpl(); break;
		case PROJECTSDAO: result =  new ProjectsDAOImpl(); break;
		case CATEGORIESDAO: result =  new CategoriesDAOImpl(); break;
		case QUOTESDAO: result =  new QuotesDAOImpl(); break;
		}
		return result;
		
	}
}
