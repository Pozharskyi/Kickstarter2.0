package com.ivanpozharskyi.kickstarter2.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.QuestionsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOExeptions.QuotesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOInterface.QuestionsDAO;
import com.ivanpozharskyi.kickstarter2.connection.ConnectionManager;
import com.ivanpozharskyi.kickstarter2.entity.Question;

public class QuestionsDAOImpl implements QuestionsDAO {
	private static Logger log = Logger.getLogger(QuestionsDAOImpl.class
			.getName());

	@Override
	public void deleteQuestion(int id) throws QuestionsDAOException {
		log.info("deleting question with id = " + id);
		String query = "DELETE FROM questions WHERE id = ?";
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
			log.error("Can not delete quote", e);
			throw new QuestionsDAOException("Can not delete question ", e);
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
				log.error("can not close connection", e);

			}
		}

	}

	@Override
	public void addQuestion(String name, int project) throws QuotesDAOException {
		String query = "INSERT INTO quotes (name,project) VALUES (?,?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			log.trace("open connection");
			con = ConnectionManager.getConnection();
			log.trace("create prepered statement");
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, project);
			statement.execute();
		} catch (SQLException e) {
			throw new QuotesDAOException("Can not add question", e);
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
	public Question findQuestionById(int id) throws QuestionsDAOException {
		String query = "SELECT * FROM questions WHERE id = ?";
		Question question = null;
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				question = new Question(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("project"));

			}
		} catch (SQLException e) {
			throw new QuestionsDAOException("Can not find question", e);
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
		if (null == question) {
			// to do loging
		} else {
			// TO DO loging
		}

		return question;
	}

	@Override
	public List<Question> findQuestionByProject(String project)
			throws QuestionsDAOException {
		String query = "SELECT * FROM questions INNER JOIN projects ON questions.project = projects.id WHERE projects.name = ?";
		List<Question> questions = new ArrayList<>();
		Question question = null;
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, project);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				question = new Question(resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getInt("project"));
				questions.add(question);
			}
		} catch (SQLException e) {
			throw new QuestionsDAOException("Can not find question", e);
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
		if (null == question) {
			// to do loging
		} else {
			// TO DO loging
		}

		return questions;
	}
//
//	public static void main(String[] args) throws QuestionsDAOException {
//
//		QuestionsDAOImpl questionsDAOImpl = new QuestionsDAOImpl();
//
//		System.out.println(questionsDAOImpl
//				.findQuestionByProject("batmanProject"));
//
//	}
}
