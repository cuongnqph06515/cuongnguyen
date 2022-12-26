package com.cuongnguyen.dao;

import java.sql.SQLException;
import java.util.List;

import com.cuongnguyen.model.Category;

public interface iCategory {
	public List<Category> getCategory() throws SQLException;
	public Category getCategoryById(Integer maLoaiHang) throws SQLException;
	public void updateCategory(Category category) throws SQLException;
	public void addCategory(Category category) throws SQLException;
	public void deleteCategory(Integer categoryCode) throws SQLException;
}
