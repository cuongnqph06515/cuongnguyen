package com.cuongnguyen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cuongnguyen.connectDB.ConnectDB;
import com.cuongnguyen.models.loaihang;

public class loaihangDAO {
	
	public static loaihangDAO instance;
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public static loaihangDAO getInstace() {
    	if(instance == null) {
    		instance = new loaihangDAO();
    	}
    	return instance;
    }
    
    public List<loaihang> getLoaiHang() throws SQLException {
    	
    	try {
    		connect = ConnectDB.getConnection();
        	statement = connect.createStatement();
        	resultSet = statement.executeQuery("select * from loaihang");
        	List<loaihang> lstLoaihang = new ArrayList<>();
        	while(resultSet.next()) {
        		lstLoaihang.add(new loaihang(resultSet.getInt(1),resultSet.getString(2)));
        	}
        	connect.close();
        	return lstLoaihang;
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	connect.close();
        }
    	return null;
    }
    
    public void updateLoaiHang(loaihang lhang) throws SQLException {
    	try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("update loaihang set tenloaihang= ? where maloaihang= ?");
    		preparedStatement.setString(1, lhang.getTenloaihang());
    		preparedStatement.setInt(2, lhang.getMaloaihang());
    		preparedStatement.executeUpdate();
    		connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
        	connect.close();
        }
    }
    
    public void addLoaiHang(loaihang lhang) throws SQLException {
    	try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("insert into loaihang values(?,?)");
    		preparedStatement.setString(2, lhang.getTenloaihang());
    		preparedStatement.setInt(1, lhang.getMaloaihang());
    		preparedStatement.executeUpdate();
    		connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
        	connect.close();
        }
    }
    
    public void deleteLoaiHang(Integer maLoaiHang) throws SQLException {
    	try {
    		connect = ConnectDB.getConnection();
    		preparedStatement = connect.prepareStatement("delete from loaihang where maloaihang= ?");
    		preparedStatement.setInt(1, maLoaiHang);
    		preparedStatement.execute();
    		connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
        	connect.close();
        }
    }
}
