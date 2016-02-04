package com.ivanpozharskyi.kickstarter2.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.QuotesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOInterface.QuotesDAO;
import com.ivanpozharskyi.kickstarter2.connection.ConnectionManager;
import com.ivanpozharskyi.kickstarter2.connection.DataSourse;
import com.ivanpozharskyi.kickstarter2.entity.Quote;

public class QuotesDAOImpl implements QuotesDAO{
	private static Logger log = Logger.getLogger(QuotesDAOImpl.class.getName());
	@Override
	public void deleteQuote(int id) throws QuotesDAOException {
	    log.info("deleting quote with id = " + id );
		String query = "DELETE FROM quotes WHERE id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			log.trace("Open connection");
//			con = ConnectionManager.getConnection();
			DataSourse datasourse = DataSourse.getInstance();
			con = datasourse.getConnection();
			log.trace("Create preperedStatement");
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
			log.info("Quote with id = " + id + "deleted");
		} catch (SQLException e) {
			log.error("Can not delete quote",e);
			throw new QuotesDAOException("Can not delete quote ", e);
		} finally {

			try {
				if (statement != null) {
					statement.close();
					log.trace("preparedStetement close");
				}
				if (con != null) {
					con.close();
					log.trace("connection close");
				}
			} catch (SQLException e) {
				log.error("can not close connection",e);
		
			}
		}

	}
	@Override
	public void addQuote(String name, String author) throws QuotesDAOException {
		String query = "INSERT INTO quotes (name,author) VALUES (?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			log.trace("open connection");
//			con = ConnectionManager.getConnection();
			DataSourse datasourse = DataSourse.getInstance();
			con = datasourse.getConnection();

			log.trace("create prepered statement");
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, author);
			statement.execute();
		} catch (SQLException e) {
			throw new QuotesDAOException("Can not add quote", e);
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// To do loging
			}
		}

	}
	@Override
	public Quote findRandom() throws QuotesDAOException {
		String query = "SELECT name,author FROM quotes ORDER BY RAND() LIMIT 1";
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Quote quote = null;
		try{
			con = ConnectionManager.getConnection();
//			DataSourse datasourse = DataSourse.getInstance();
//			con = datasourse.getConnection();

			
			statement = con.createStatement();
			log.trace("Get the resultSet");
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				log.trace("find quote to return");
				String quoteName = resultSet.getString("name");
				String quoteAuthor = resultSet.getString("author");
				quote = new Quote(quoteName, quoteAuthor);
				log.info("quote founded");
			}
		} catch(SQLException e){
			throw new QuotesDAOException();
		}finally {
			try {
				if(resultSet != null){
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// To do loging
			}
		}
		if(null == quote){
			//to do loging
		} else {
			//to do loging
		}
		//to do loging
		return quote;
	}
	@Override
	public int findSize() throws QuotesDAOException {
		int size = 0;
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			con = ConnectionManager.getConnection();
//			DataSourse datasourse = DataSourse.getInstance();
//			con = datasourse.getConnection();

			String query = "SELECT count(*) AS size FROM quotes  ";
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				return size = resultSet.getInt("size");
			}
			
		} catch(SQLException e){
			throw new QuotesDAOException("Can not find size",e);
		} finally {
		
			try {
				if(resultSet != null){
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// To do loging
			}
		}
		if (size == 0){
			//to do loging
		} else {
			//to do loging
		}
		return size;
		
	}

	public static void main(String[] args) throws QuotesDAOException {
		QuotesDAOImpl quotesDAOImpl = new QuotesDAOImpl();
		// quotesDAOImpl.addQuote("quoteTest2","authorTest2");
		System.out.println(quotesDAOImpl.findRandom().toString());
		// quotesDAOImpl.deleteQuote(5);
		System.out.println(quotesDAOImpl.findSize());

	}
}
