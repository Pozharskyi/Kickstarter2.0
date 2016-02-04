package com.ivanpozharskyi.kickstarter2.DAOInterface;

import java.util.List;
import java.util.Set;



import com.ivanpozharskyi.kickstarter2.DAOExeptions.CategoriesDAOException;
import com.ivanpozharskyi.kickstarter2.entity.Category;

public interface CategoriesDAO extends DAO{
	void addCategory(String name) throws CategoriesDAOException;
	Category findCategoryById(int id) throws CategoriesDAOException;
	int findSize() throws CategoriesDAOException;
	List<Category> findAll() throws CategoriesDAOException;
	void deleteCategory(int id) throws CategoriesDAOException; 				
}
