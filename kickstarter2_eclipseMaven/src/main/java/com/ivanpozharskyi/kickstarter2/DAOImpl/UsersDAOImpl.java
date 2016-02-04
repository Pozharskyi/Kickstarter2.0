package com.ivanpozharskyi.kickstarter2.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;
import com.ivanpozharskyi.kickstarter2.DAOInterface.UsersDAO;
import com.ivanpozharskyi.kickstarter2.connection.ConnectionManager;
import com.ivanpozharskyi.kickstarter2.connection.DataSourse;
import com.ivanpozharskyi.kickstarter2.entity.User;


public class UsersDAOImpl implements UsersDAO{
	@Override
	public int findSize() throws UsersDAOException {
		String query = "SELECT count(*) AS size FROM users ";
		int size = 0;
		Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	    try{
//			con = ConnectionManager.getConnection();
	    	con = DataSourse.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()){
				return size = resultSet.getInt("size");
			}
	    } catch(SQLException e){
	    	throw new UsersDAOException("Can not find users size", e);
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
	public void addUser(String login, String password, String email,
			String firstName, String lastName) throws UsersDAOException {
		String query = "INSERT INTO users (login, password, email, firstName , lastName, usertype)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement statement = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, login);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.setString(4, firstName);
			statement.setString(5, lastName);
			statement.setInt(6, 2);			//TO DO now hardcode all users as regular user
			statement.execute();
		}  catch(SQLException e){
	    	throw new UsersDAOException("Can not add user", e);
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
	public void updateUser(String login, String password, String email,
			String firstName, String lastName) throws UsersDAOException {
		String query = "update kickstarter.users set email = ?, firstname = ?, lastname = ? where login = ? AND password = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, login);
			statement.setString(5, password);
			statement.execute();
		}  catch(SQLException e){
	    	throw new UsersDAOException("Can not update user", e);
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
	public void deleteUser(int id) throws UsersDAOException{
		String query = "DELETE FROM users WHERE id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
		} catch(SQLException e){
	    	throw new UsersDAOException("Can not delete user", e);
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
	public List<User> findAllUsers() throws UsersDAOException{
		String query = "SELECT * FROM users";
		List<User> users= new ArrayList<>();
		User user = null;
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				 user = new User(resultSet.getInt("id")
						, resultSet.getString("login")
						, resultSet.getString("password")
						, resultSet.getString("email")
						, resultSet.getString("firstName")
						, resultSet.getString("lastName")
						, resultSet.getInt("usertype"));
							
				users.add(user);
			}
		} catch(SQLException e){
			throw new UsersDAOException("Can not find All users ", e );
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
		if(null == user){
			//to do loging
		} else {
			//to do loging
		}
		//to do loging
		return users;
	}
	@Override
	public List<User> findUsersByUsertype(String usertype) throws UsersDAOException{
		String query = "SELECT * FROM users INNER JOIN usertype ON users.usertype = usertype.id WHERE usertype.type = ?";
		List<User> users= new ArrayList<>();
		User user = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, usertype);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				 user = new User(resultSet.getInt("id")
						, resultSet.getString("login")
						, resultSet.getString("password")
						, resultSet.getString("email")
						, resultSet.getString("firstName")
						, resultSet.getString("lastName")
						, resultSet.getInt("usertype"));
							
				users.add(user);
			}
		} catch(SQLException e){
			throw new UsersDAOException("Can not find user ", e );
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
		if(null == user){
			//to do loging
		} else {
			//to do loging
		}
		//to do loging
		return users;
	}
	@Override
	public User findUserById(int id) throws UsersDAOException{
		String query = "SELECT * FROM users WHERE id = ?";	
		User user = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				 user = new User(resultSet.getInt("id")
						, resultSet.getString("login")
						, resultSet.getString("password")
						, resultSet.getString("email")
						, resultSet.getString("firstName")
						, resultSet.getString("lastName")
						, resultSet.getInt("usertype"));
							
			}
		} catch(SQLException e){
			throw new UsersDAOException("Can not find user ", e );
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
		if(null == user){
			//to do loging
		} else {
			//to do loging
		}
		//to do loging
		return user;
	}
	@Override
	public User findUserByLogin(String login) throws UsersDAOException{
		String query = "SELECT * FROM users WHERE login = ?";	
		User user = null;
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				 user = new User(resultSet.getInt("id")
						, resultSet.getString("login")
						, resultSet.getString("password")
						, resultSet.getString("email")
						, resultSet.getString("firstName")
						, resultSet.getString("lastName")
						, resultSet.getInt("usertype"));
							
			}
		} catch(SQLException e){
			throw new UsersDAOException("Can not find user ", e );
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
		if(null == user){
			//to do loging
		} else {
			//to do loging
		}
		//to do loging
		return user;
	}
	@Override
	public boolean checkLogin(String login, String password) throws UsersDAOException {
		String query = "SELECT * FROM users where login = ? and password = ?";	
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		boolean result = false;
		try{
//			con = ConnectionManager.getConnection();
			con = DataSourse.getInstance().getConnection();
				statement = con.prepareStatement(query);
				statement.setString(1, login);
				statement.setString(2, password);
				resultSet = statement.executeQuery();
				 if(resultSet.next()){
					 result = true;
					 return result;
				 };
		} catch(SQLException e){
			throw new UsersDAOException("Can not find user ", e );
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
		return result;
	}
	public static void main(String[] args) throws UsersDAOException {
		
		UsersDAOImpl usersDAO = new UsersDAOImpl();
		
		System.out.println(usersDAO.findSize());
//		System.out.println(projectsDAO.findProjectsByCategory(2));
//		projectsDAO.addProject("test3", "description3", 3, 300, 30, 2, 1);
//		usersDAO.addUser("login2", "password2", "email2", "firstName2", "lastName2");
		
		System.out.println(usersDAO.findAllUsers());	
		System.out.println(usersDAO.checkLogin("root", "root"));
		
	}
}
