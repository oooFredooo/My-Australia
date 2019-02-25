package com.myaustralia.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.myaustralia.common.DatabaseHelper;

public class DAO<T> {
	ResultSet res = null;
	Connection con = null;
	PreparedStatement pre = null;

	// set parameters for sql
	private void setParameter(String... parameter) {
		for (int i = 0; i < parameter.length; i++) {
			try {
				pre.setObject(i+1, parameter[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

    // fetch data from database to ResultSet
	public List<T> query(Class<T> cls, String sql, String... parameter) {
		List<T> list = new ArrayList<>();
		try {
			con = DatabaseHelper.getConnection();
			pre = con.prepareStatement(sql);
			setParameter(parameter);
			res = pre.executeQuery(); 

			while(res.next()) {
				T obj = cls.newInstance(); // create a new instance of this class
				setData(cls, obj); // assign values to the properties of obj
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseHelper.closeAll(res, pre, con);
		}
		return list; 
	}
	
    // fetch byte[] data from database to byteRes
	public byte[] queryByte(String colName, String sql, String... parameter) {
		byte[] byteRes = new byte[Integer.parseInt(ResourceBundle.getBundle("params").getString("maxImageSize"))];
		try {
			con = DatabaseHelper.getConnection();
			pre = con.prepareStatement(sql);
			setParameter(parameter);
			res = pre.executeQuery(); 
			while(res.next()) {
				byteRes = res.getBytes(colName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseHelper.closeAll(res, pre, con);
		}
		return byteRes; 
	}

    // insert, update, delete
	public int update(String sql, String... parameter) {
		int num = 0;
		try {
			con = DatabaseHelper.getConnection();
			pre = con.prepareStatement(sql);
			setParameter(parameter);
			num = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseHelper.closeAll(res, pre, con);
		}
		return num; // number of rows affected
	}

	// assign values of ResultSet to javabean by using setter methods of object properties
	private void setData(Class<T> cls, T obj) {
		/*
		 * use set(Object obj, Object value) to assign value to obj
		 * use ResultSet to get ResultSetMetaData, 
		 * use ResultSetMetaData to get column
		 */
		try {
			ResultSetMetaData rsmd = res.getMetaData();
			int col = rsmd.getColumnCount();
			for (int i = 1; i <= col; i++) {
				String DBField = rsmd.getColumnLabel(i); 
				Field field = cls.getDeclaredField(DBField); 
				field.setAccessible(true);
				field.set(obj, res.getObject(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}