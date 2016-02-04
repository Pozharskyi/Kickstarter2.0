package com.ivanpozharskyi.kickstarter2.DAOInterface;

import java.util.List;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.UsersDAOException;
import com.ivanpozharskyi.kickstarter2.entity.User;

public interface UsersDAO extends DAO{
	public int findSize() throws UsersDAOException;
	void addUser(String login, String password, String email,
			String firstName, String lastName) throws UsersDAOException;
	public void updateUser(String login, String password, String email,
			String firstName, String lastName) throws UsersDAOException;
	public void deleteUser(int id) throws UsersDAOException;
	public List<User> findAllUsers() throws UsersDAOException;
	public List<User> findUsersByUsertype(String usertype) throws UsersDAOException;
	public User findUserById(int id) throws UsersDAOException;
	public User findUserByLogin(String login) throws UsersDAOException;
	boolean checkLogin(String login, String password) throws UsersDAOException;
}
