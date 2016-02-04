package com.ivanpozharskyi.kickstarter2.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.AnswersDAOException;
import com.ivanpozharskyi.kickstarter2.DAOInterface.AnswersDAO;
import com.ivanpozharskyi.kickstarter2.connection.ConnectionManager;
import com.ivanpozharskyi.kickstarter2.entity.Answer;


public class AnswersDAOImpl implements AnswersDAO{
	private static Logger log = Logger.getLogger(QuestionsDAOImpl.class.getName());
	@Override
	public void deleteAnswer(int id) throws AnswersDAOException {
	    log.info("deleting answer with id = " + id );
		String query = "DELETE FROM answers WHERE id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			log.trace("Open connection");
			con = ConnectionManager.getConnection();
			log.trace("Create preperedStatement");
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
			log.info("Question with id = " + id + "deleted");
		} catch (SQLException e) {
			log.error("Can not delete quote",e);
			throw new AnswersDAOException("Can not delete answer ", e);
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
	public void addAnswer(String name, int question) throws AnswersDAOException {
		String query = "INSERT INTO answers (name,question) VALUES (?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			log.trace("open connection");
			con = ConnectionManager.getConnection();
			log.trace("create prepered statement");
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, question);
			statement.execute();
		} catch (SQLException e) {
			throw new AnswersDAOException("Can not add answer", e);
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
	public Answer findAnswerById(int id) throws AnswersDAOException {
		String query = "SELECT * FROM answers WHERE id = ?";
		Answer answer = null;
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				answer = new Answer(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("question"));

			}
		} catch (SQLException e) {
			throw new AnswersDAOException("Can not find answer", e);
		} finally {
			try {
				if (resultSet != null) {
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
		if (null == answer) {
			// to do loging
		} else {
			// TO DO loging
		}

		return answer;
	}
	@Override
	public List<Answer> findAnswerByQuestion(String question)
			throws AnswersDAOException {
		String query = "SELECT * FROM answers INNER JOIN questions ON answers.question = questions.id WHERE questions.name = ?";
		List<Answer> answers = new ArrayList<>();
		Answer answer = null;
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, question);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				answer = new Answer(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("question"));
				answers.add(answer);
			}
		} catch (SQLException e) {
			throw new AnswersDAOException("Can not find answer", e);
		} finally {
			try {
				if (resultSet != null) {
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
		if (null == answer) {
			// to do loging
		} else {
			// TO DO loging
		}

		return answers;
	}
	
//	public static void main(String[] args) throws AnswersDAOException {
//
//		AnswersDAOImpl answersDAOImpl = new AnswersDAOImpl();
//
//		System.out.println(answersDAOImpl.findAnswerById(1));
//		System.out.println(answersDAOImpl.findAnswerByQuestion("question1"));
//
//	}
}
