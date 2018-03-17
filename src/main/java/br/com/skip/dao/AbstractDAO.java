package br.com.skip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import br.com.skip.util.DBProperties;

public abstract class AbstractDAO<T> implements DAOInterface<T> {

	private Connection connection;
	
	public AbstractDAO() {
		try {
			
			String driver = DBProperties.getInstance().getProperty("database.driver");
			String url = DBProperties.getInstance().getProperty("database.url");
			String user = DBProperties.getInstance().getProperty("database.username");
			String pass = DBProperties.getInstance().getProperty("database.password");
			
			Class.forName(driver);
			connection =  DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}
