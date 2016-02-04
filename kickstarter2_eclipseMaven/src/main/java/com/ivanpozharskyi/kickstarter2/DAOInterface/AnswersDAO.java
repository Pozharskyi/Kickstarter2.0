package com.ivanpozharskyi.kickstarter2.DAOInterface;

import java.util.List;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.AnswersDAOException;
import com.ivanpozharskyi.kickstarter2.entity.Answer;

public interface AnswersDAO extends DAO{
	public void deleteAnswer(int id) throws AnswersDAOException;
	void addAnswer(String name, int question) throws AnswersDAOException;
	Answer findAnswerById(int id) throws AnswersDAOException;
	List<Answer> findAnswerByQuestion(String question)
			throws AnswersDAOException;
}
