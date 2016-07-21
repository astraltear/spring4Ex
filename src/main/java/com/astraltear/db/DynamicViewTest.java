package com.astraltear.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DynamicViewTest {
	
/*
펑션생성
create function cut_request_queue_param_func() returns INTEGER DETERMINISTIC NO SQL return @p1;

뷰생성 
create view cut_request_queue_view as
select * from cut_request_queue where status = cut_request_queue_param_func() ;

select s.* from (select @p1:=1 p) parm , cut_request_queue_view s;
 */

	public static void main(String[] args) {
		dynamicView();
	}

	private static void dynamicView() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("init....................");
		
		try {
			con = MySQLDataSource.getInstance().getConnection();

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("select s.* from (select @p1:=2 p) parm , cut_request_queue_view s");
			pstmt = con.prepareStatement(strbuf.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getString(6));
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
		
		System.out.println("end............");

	}

}
