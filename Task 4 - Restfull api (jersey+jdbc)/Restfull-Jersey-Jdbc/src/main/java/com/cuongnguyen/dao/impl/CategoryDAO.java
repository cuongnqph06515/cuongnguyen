package com.cuongnguyen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cuongnguyen.config.ConnectDB;
import com.cuongnguyen.dao.iCategory;
import com.cuongnguyen.model.Category;

public class CategoryDAO implements iCategory{
	private static final Logger logger = Logger.getLogger(CategoryDAO.class);
	public static CategoryDAO instance;
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public static CategoryDAO getInstace() {
    	if(instance == null) {
    		instance = new CategoryDAO();
    	}
    	return instance;
    }
    
    @Override
    public List<Category> getCategory() throws SQLException {
    	
    	try {
    		connect = ConnectDB.getConnection();
        	statement = connect.createStatement();
        	resultSet = statement.executeQuery("select * from loaihang");
        	List<Category> lstCategory = new ArrayList<>();
        	while(resultSet.next()) {
        		lstCategory.add(new Category(resultSet.getInt(1),resultSet.getString(2)));
        	}
        	return lstCategory;
        }catch(Exception e) {
        	logger.error(e.getMessage());
        	e.printStackTrace();
        }finally {
        	connect.close();
        }
    	return null;
    }
    
    @Override
    public void updateCategory(Category category) throws SQLException {
    	try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("update loaihang set tenloaihang= ? where maloaihang= ?");
    		preparedStatement.setString(1, category.getTenloaihang());
    		preparedStatement.setInt(2, category.getMaloaihang());
    		preparedStatement.executeUpdate();
		} catch (Exception e) {
			logger.error("err updateCategory() in CategoryDAO: ", e);
			e.printStackTrace();
		}
    	finally {
        	connect.close();
        }
    }
    
    @Override
    public void addCategory(Category category) throws SQLException {
    	try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("insert into loaihang values(?,?)");
    		preparedStatement.setString(2, category.getTenloaihang());
    		preparedStatement.setInt(1, category.getMaloaihang());
    		preparedStatement.execute();
		} catch (Exception e) {
			logger.error("err addCategory() in CategoryDAO: ", e);
			e.printStackTrace();
		}
    	finally {
        	connect.close();
        }
    }
    @Override
    public void deleteCategory(Integer categoryCode) throws SQLException {
    	try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("delete from loaihang where maloaihang= ?");
    		preparedStatement.setInt(1, categoryCode);
    		preparedStatement.execute();
		} catch (Exception e) {
			logger.error("err deleteCategory() in CategoryDAO: ", e);
			e.printStackTrace();
		}
    	finally {
        	connect.close();
        }
    }

	@Override
	public Category getCategoryById(Integer categoryCode) throws SQLException {
		Category category=null;
		try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("select * from loaihang where maloaihang= ?");
    		preparedStatement.setInt(1, categoryCode);
    		resultSet = preparedStatement.executeQuery();
        	while(resultSet.next()) {
        		category = new Category();
        		category.setMaloaihang(resultSet.getInt(1));
            	category.setTenloaihang(resultSet.getString(2));
        	}
        }catch(Exception e) {
        	logger.error(e.getMessage());
        	e.printStackTrace();
        }finally {
        	connect.close();
        }
    	return category;
	}
}
