package com.astraltear.dbcp;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {
	private static DataSource datasource;
	private BasicDataSource ds;
	
	private final static String REAL = "jdbc:mysql://localhost:13306/spring_bank_app_db";

	private DataSource() throws IOException, SQLException, PropertyVetoException {
		ds = new BasicDataSource();
		
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("test");
		ds.setPassword("test");
		ds.setUrl(REAL);

		ds.setMinIdle(100);
		ds.setMaxIdle(100);
		ds.setMaxOpenPreparedStatements(180);

	}

	public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new DataSource();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.ds.getConnection();
	}
}
