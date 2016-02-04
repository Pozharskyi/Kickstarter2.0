package com.ivanpozharskyi.kickstarter2.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.DAOInterface.CategoriesDAO;
import com.ivanpozharskyi.kickstarter2.connection.ConnectionManager;
import com.ivanpozharskyi.kickstarter2.entity.Category;

public class CategoriesDAOImpl implements CategoriesDAO {

	// public CategoriesDAOImpl(ConnectionManager connectionManager) {
	//
	// this.connection = connectionManager.getConnection();
	// }

	public CategoriesDAOImpl() {
	}
	@Override
	public void addCategory(String name) throws CategoriesDAOException {
		String query = "INSERT INTO categories (name)" + "VALUES(?)";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, name);
			statement.execute();
		} catch (SQLException e) {
			throw new CategoriesDAOException("Can not add category", e);
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

	// public void dropCategories() throws SQLException {
	// Statement statement = connection.createStatement();
	// statement.execute("DROP TABLE categories");
	//
	// }
	@Override
	public void deleteCategory(int id) throws CategoriesDAOException {
		String query = "DELETE FROM categories WHERE id = ?";
		Connection con = null;
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			throw new CategoriesDAOException("Can not add delete category", e);
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
	public Category findCategoryById(int id) throws CategoriesDAOException {
		String query = "SELECT * FROM categories WHERE id = ?";
		Category category = null;
		Connection con = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionManager.getConnection();
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				category = new Category(resultSet.getInt("id"),
						resultSet.getString("name"));

			}
		} catch (SQLException e) {
			throw new CategoriesDAOException("Can not find category", e);
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
		if (null == category) {
			// to do loging
		} else {
			// TO DO loging
		}

		return category;
	}
    @Override
	public int findSize() throws CategoriesDAOException {
		String query = "SELECT count(*) FROM categories";
		int size = 0;
		Connection con = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			con = ConnectionManager.getConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				size = resultSet.getInt("count(*)");
			}
		} catch (SQLException e) {
			throw new CategoriesDAOException("Can not find size", e);
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
		if (0 == size) {
			// to do loging
		} else {
			// TO DO loging
		}
		return size;
	}
    @Override
	public List<Category> findAll() throws CategoriesDAOException {	// look for different realisation
		List<Category> categories = new LinkedList<Category>();

		try {
			for (int i = 1; i <= findSize(); i++) {
				categories.add(findCategoryById(i));
			}
		} catch (CategoriesDAOException e) {
			throw new CategoriesDAOException("Can not find All categories ", e);
//			TO DO loging
		}
		if (categories.isEmpty()){
//			TO DO loging
		} else {
//			TO DO loging
		}
		return categories;
	}

//	public static void main(String[] args) throws  CategoriesDAOException {
//		CategoriesDAOImpl categoriesDAOImpl = new CategoriesDAOImpl();
//
//		System.out.println(categoriesDAOImpl.findAll());
//		System.out.println(categoriesDAOImpl.findSize());
//
//	}

}
