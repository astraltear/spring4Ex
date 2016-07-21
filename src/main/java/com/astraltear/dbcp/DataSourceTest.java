package com.astraltear.dbcp;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DataSource.getInstance().getConnection();

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("select * from simpletable where id=?");

			pstmt = con.prepareStatement(strbuf.toString());
			pstmt.setInt(1, 10);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) 	{ try { rs.close(); 	} catch (Exception e) {} }
			if (pstmt != null) 	{ try { pstmt.close(); 	} catch (Exception e) {} }
			if (con != null) 	{ try { con.close(); 	} catch (Exception e) {} }
		}
	}

}
