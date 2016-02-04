package com.ivanpozharskyi.kickstarter2.DAOInterface;

import java.util.List;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.QuestionsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.QuotesDAOException;
import com.ivanpozharskyi.kickstarter2.entity.Question;

public interface QuestionsDAO extends DAO{
	void deleteQuestion(int id) throws QuestionsDAOException;
	void addQuestion(String name, int project) throws QuotesDAOException;
	Question findQuestionById(int id) throws QuestionsDAOException;
	List<Question> findQuestionByProject(String project) throws QuestionsDAOException;
}
