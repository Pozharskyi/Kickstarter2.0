    package com.ivanpozharskyi.kickstarter2.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.ProjectsDAOException;
import com.ivanpozharskyi.kickstarter2.DAOInterface.CategoriesDAO;
import com.ivanpozharskyi.kickstarter2.DAOInterface.ProjectsDAO;
import com.ivanpozharskyi.kickstarter2.connection.ConnectionManager;
import com.ivanpozharskyi.kickstarter2.entity.Project;

public class ProjectsDAOImpl implements ProjectsDAO{
//	CategoriesDAO categoriesDAO;
	
//	public ProjectsDAOImpl(CategoriesDAO categoriesDAO) {
//		this.categoriesDAO = categoriesDAO;
//	}
	@Override
	public int findSize() throws ProjectsDAOException {
		String query = "SELECT count(*) AS size FROM projects ";
		int size = 0;
		Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	    try{
			con = ConnectionManager.getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()){
				return size = resultSet.getInt("size");
			}
	    } catch(SQLException e){
	    	throw new ProjectsDAOException("Can not find Projects size", e);
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
	    if(size == 0){
//	    	TO DO loging
	    } else {
//	    	TO DO loging
	    }
	    return size;
	}
	@Override
	public void addProject(String name, String description, int moneyGot,
			int moneyNeed, int daysLeft, int category, int user) throws ProjectsDAOException{
		String query = "INSERT INTO projects (name, description, moneyGot, MoneyNeed, daysLeft, category, user)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement statement = null;
		try{
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, description);
			statement.setInt(3, moneyGot);
			statement.setInt(4, moneyNeed);
			statement.setInt(5, daysLeft);
			statement.setInt(6, category);
			statement.setInt(7, user);
			statement.execute();
		}  catch(SQLException e){
	    	throw new ProjectsDAOException("Can not add project", e);
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
	public void deleteProject(int id) throws ProjectsDAOException{
		String query = "DELETE FROM projects WHERE id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try{
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
		} catch(SQLException e){
	    	throw new ProjectsDAOException("Can not add project", e);
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
	public List<Project> findProjectsByCategory(int category) throws  ProjectsDAOException{
		String query = "SELECT * FROM projects INNER JOIN categories "
				+ "ON projects.category = categories.id "
				+ "WHERE categories.id = ?";
		List<Project> projects = new ArrayList<Project>();
		Project project = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{	
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, category);				 			
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				 project = new Project(resultSet.getInt("id")
							, resultSet.getString("name")
							, resultSet.getString("description")
							, resultSet.getInt("moneyGot")
							, resultSet.getInt("moneyNeed")
							, resultSet.getInt("daysLeft")
							, resultSet.getInt("category")
							, resultSet.getInt("user"));
				
				projects.add(project);
			}
		} catch(SQLException e){
			throw new ProjectsDAOException("Can not find projects in category = " + category, e );
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
		return projects;
	}
	@Override
	public List<Project> findAllProjects() throws ProjectsDAOException{
		String query = "SELECT * FROM projects";
		List<Project> projects= new ArrayList<Project>();
		Project project = null;
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			con = ConnectionManager.getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				 project = new Project(resultSet.getInt("id")
						, resultSet.getString("name")
						, resultSet.getString("description")
						, resultSet.getInt("moneyGot")
						, resultSet.getInt("moneyNeed")
						, resultSet.getInt("daysLeft")
						, resultSet.getInt("category")
						, resultSet.getInt("user"));
			
				
				projects.add(project);
			}
		} catch(SQLException e){
			throw new ProjectsDAOException("Can not find All projects ", e );
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
		return projects;
	}



	@Override
	public Project findProjectById(int id) throws ProjectsDAOException {
		String query = "SELECT * FROM projects WHERE id = ?";
		Project project = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				project = new Project(resultSet.getInt("id")
						, resultSet.getString("name")
						, resultSet.getString("description")
						, resultSet.getInt("moneyGot")
						, resultSet.getInt("moneyNeed")
						, resultSet.getInt("daysLeft")
						, resultSet.getInt("category")
						, resultSet.getInt("user"));
						
			} 
		} catch(SQLException e){
			throw new ProjectsDAOException("Can not find project by id ", e );
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
		return project;
	}
	@Override
	public List<Project> findProjectByName(String name) throws ProjectsDAOException {
		String query = "SELECT * FROM projects WHERE name = ?";
		List<Project> projects = new ArrayList<Project>();
		Project project = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				project = new Project(resultSet.getInt("id")
						, resultSet.getString("name")
						, resultSet.getString("description")
						, resultSet.getInt("moneyGot")
						, resultSet.getInt("moneyNeed")
						, resultSet.getInt("daysLeft")
						, resultSet.getInt("category")
						, resultSet.getInt("user"));
				projects.add(project);		
			} 
		} catch(SQLException e){
			throw new ProjectsDAOException("Can not find project by name ", e );
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
		return projects;
	}
	@Override
	public List<Project> findProjectByUser(String userLogin) throws ProjectsDAOException {
		String query = "SELECT * FROM projects INNER JOIN users ON projects.user = users.id WHERE users.login = ?";
		List<Project> projects = new ArrayList<Project>();
		Project project = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, userLogin);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				project = new Project(resultSet.getInt("id")
						, resultSet.getString("name")
						, resultSet.getString("description")
						, resultSet.getInt("moneyGot")
						, resultSet.getInt("moneyNeed")
						, resultSet.getInt("daysLeft")
						, resultSet.getInt("category")
						, resultSet.getInt("user"));
				projects.add(project);		
			} 
		} catch(SQLException e){
			throw new ProjectsDAOException("Can not find project by user ", e );
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
		return projects;
	}
//	public static void main(String[] args) throws  ProjectsDAOException {
////	CategoriesDAO categoriesDAO = new CategoriesDAOImpl();
//	ProjectsDAO projectsDAO = new ProjectsDAOImpl();
//	
//	System.out.println(projectsDAO.findSize());
////	System.out.println(projectsDAO.findProjectsByCategory(2));
////	projectsDAO.addProject("test3", "description3", 3, 300, 30, 2, 1);
//	System.out.println(projectsDAO.findAllProjects());
//	System.out.println(projectsDAO.findProjectsByCategory("sport"));	
//	
//}
}
