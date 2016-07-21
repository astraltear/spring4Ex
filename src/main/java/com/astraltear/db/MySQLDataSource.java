package com.astraltear.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class MySQLDataSource {
	private static MySQLDataSource datasource;
	private BasicDataSource ds;
	
	private final static String REAL = "jdbc:mysql://1.201.137.49:13306/audienb2c";

	private MySQLDataSource() throws IOException, SQLException, PropertyVetoException {
		ds = new BasicDataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("audien");
		ds.setPassword("dheldjs");
		ds.setUrl(REAL);


	}

	public static MySQLDataSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new MySQLDataSource();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.ds.getConnection();
	}
}
