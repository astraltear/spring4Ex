package com.astraltear.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.astraltear.dbcp.DataSource;

public class MysqlTextDataTypeTest {
	
	Connection con = null;
	
	public Connection initConnect() throws SQLException, IOException, PropertyVetoException {
		this.con = DataSource.getInstance().getConnection();
		return this.con;
	}
	
	public void releaseConnect() {
		if (this.con != null) 	{ try { this.con.close(); 	} catch (Exception e) {} }
	}

	public static void main(String[] args) throws SQLException, IOException, PropertyVetoException {
		
		
		MysqlTextDataTypeTest dataTypeTest = new MysqlTextDataTypeTest();
		dataTypeTest.initConnect();
		
		dataTypeTest.insertData();
		
		dataTypeTest.getData();
		
		dataTypeTest.releaseConnect();
	}
	
	public void insertData() {
		PreparedStatement pstmt = null;
		
		try {

			StringBuffer strbuf = new StringBuffer();
			/*
CREATE TABLE `bigtable` (
	`varcharType` VARCHAR(20000) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`defaultTextType` TEXT NULL COLLATE 'utf8_unicode_ci',
	`mediumTextType` MEDIUMTEXT NULL COLLATE 'utf8_unicode_ci',
	`longTextType` LONGTEXT NULL COLLATE 'utf8_unicode_ci'
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB

MEDIUMTEXT 80000자 정도가 적당하다. 
;

			 */
			strbuf.append("insert into bigtable values(?,?,?,?)");

			pstmt = con.prepareStatement(strbuf.toString());
			
			String  varcharType="";
			StringBuffer defaultTextType = new StringBuffer();
			StringBuffer mediumTextType=new StringBuffer();
			StringBuffer longTextType=new StringBuffer();
			
			for (int i = 0; i < 20000; i++) { // varchar 2000 과 text 컬럼의 차이는 별로 없다 
				varcharType+="가";
			}
			
			for (int i = 0; i < 20000; i++) { // varchar 2000 과 text 컬럼의 차이는 별로 없다 
				defaultTextType.append("읽");
			}
			
			for (int i = 0; i < 87000; i++) {
				mediumTextType.append("밝");
			}
			
			for (int i = 0; i < 87900; i++) {
				longTextType.append("녕");
			}
			
			pstmt.setString(1, varcharType);
			pstmt.setString(2, defaultTextType.toString());
			pstmt.setString(3, mediumTextType.toString());
			pstmt.setString(4, longTextType.toString());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) 	{ try { pstmt.close(); 	} catch (Exception e) {} }
			
		}
		
	}
	
	public void getData() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("select * from bigtable");

			pstmt = con.prepareStatement(strbuf.toString());

			rs = pstmt.executeQuery();
			
			String  varcharType="";
			String  defaultTextType="";
			String  mediumTextType="";
			String  longTextType="";
			
			while (rs.next()) {
				varcharType= rs.getString("varcharType");
				defaultTextType= rs.getString("defaultTextType");
				mediumTextType= rs.getString("mediumTextType");
				longTextType= rs.getString("longTextType");
				
			}
			
			System.out.println("varcharType["+varcharType+"]");
			System.out.println("defaultTextType["+defaultTextType+"]");
			System.out.println("mediumTextType["+mediumTextType+"]");
			System.out.println("longTextType["+longTextType+"]");


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) 	{ try { rs.close(); 	} catch (Exception e) {} }
			if (pstmt != null) 	{ try { pstmt.close(); 	} catch (Exception e) {} }
			
		}
	}

}
