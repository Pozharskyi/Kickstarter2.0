package com.ivanpozharskyi.kickstarter2.DAOInterface;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.QuotesDAOException;
import com.ivanpozharskyi.kickstarter2.entity.Quote;

public interface QuotesDAO extends DAO{
	void deleteQuote(int id) throws QuotesDAOException;
	void addQuote(String name, String author) throws QuotesDAOException;
	Quote findRandom() throws QuotesDAOException;
	int findSize() throws QuotesDAOException;
}
