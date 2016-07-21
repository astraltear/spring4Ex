package com.astraltear.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProcedureTest {

	public static void main(String[] args) throws InterruptedException {
//		callProcedure();
//		callCutRequestcbProc();
//		callCutRequestQueueExists();
		callUserRegistProc();
	}
	
	private static void callUserRegistProc() throws InterruptedException {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		System.out.println("callUserRegistProc ....................");
		
		try {
			con = MySQLDataSource.getInstance().getConnection();
			
			int idx=1;
			
			StringBuffer strbuf = new StringBuffer();
			strbuf.append("{call user_regist_proc(?,?,?,?,?,?,?)}");
			
			cs = con.prepareCall(strbuf.toString());
//			(IN `I_USER_ID` VARCHAR(50), IN `I_PASSWD` VARCHAR(200), IN `I_IS_SNS_JOIN` VARCHAR(1), IN `I_JOIN_PATH` VARCHAR(1), 
//			IN `I_PHONE_NO` VARCHAR(20), IN `I_AUTH_TYPE` VARCHAR(1), OUT `O_RESULT` INT)
			
			cs.setString(idx++, "darap4");
			cs.setString(idx++, "123456");
			cs.setString(idx++, "N");
			cs.setString(idx++, "M");
			cs.setString(idx++, "010-2222-3333");
			cs.setString(idx++, "P"); // P E
			
			System.out.println(idx);
			
			cs.registerOutParameter(idx, java.sql.Types.INTEGER);

			rs = cs.executeQuery();
			int resultCode =cs.getInt(idx);
			
			System.out.println("callUserRegistProc resultCode:"+resultCode);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) 	{ try { rs.close(); 	} catch (Exception e) {} }
			if (cs != null) 	{ try { cs.close(); 	} catch (Exception e) {} }
			if (con != null) 	{ try { con.close(); 	} catch (Exception e) {} }
		}
		
		System.out.println("end............");
	}
	
	
	private static void callCutRequestQueueExists() throws InterruptedException {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		System.out.println("init....................");
		
		try {
			con = MySQLDataSource.getInstance().getConnection();

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("{call cut_request_queue_exists(?, ?)}");

			cs = con.prepareCall(strbuf.toString());
			cs.setInt(1, 1);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);

			rs = cs.executeQuery();
			int exists =cs.getInt(2);
			
			System.out.println("callCutRequestQueueExists exists:"+exists);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) 	{ try { rs.close(); 	} catch (Exception e) {} }
			if (cs != null) 	{ try { cs.close(); 	} catch (Exception e) {} }
			if (con != null) 	{ try { con.close(); 	} catch (Exception e) {} }
		}
		
		System.out.println("end............");
	}
	
	private static void callCutRequestcbProc() throws InterruptedException {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		System.out.println("init....................");
		
		try {
			con = MySQLDataSource.getInstance().getConnection();

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("{call cut_requestcb_proc(?, ?, ?, ?)}");

			cs = con.prepareCall(strbuf.toString());
			cs.setInt(1, 2);
			cs.setInt(2, 333333);
			cs.setInt(3, 4444444);
			cs.registerOutParameter(4, java.sql.Types.INTEGER);

			rs = cs.executeQuery();
			int exists =cs.getInt(4);
			
			System.out.println("cut_requestcb_proc exists:"+exists);
			



		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) 	{ try { rs.close(); 	} catch (Exception e) {} }
			if (cs != null) 	{ try { cs.close(); 	} catch (Exception e) {} }
			if (con != null) 	{ try { con.close(); 	} catch (Exception e) {} }
		}
		
		System.out.println("end............");
	}

	private static void callProcedure() throws InterruptedException {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		System.out.println("init....................");
		Thread.sleep(5000);
		
		System.out.println("run.............");
		
		try {
			con = MySQLDataSource.getInstance().getConnection();

			StringBuffer strbuf = new StringBuffer();
			strbuf.append("{call taskListexists(?)}");

			cs = con.prepareCall(strbuf.toString());
			cs.registerOutParameter(1, java.sql.Types.INTEGER);

			rs = cs.executeQuery();
			int exists =cs.getInt(1);
			
			System.out.println("taskListexists exists:"+exists);
			
			if (exists > 0) {
				strbuf.setLength(0);
				strbuf.append("{call taskListupdate(?)}");
				
				cs = con.prepareCall(strbuf.toString());
				cs.registerOutParameter(1, java.sql.Types.INTEGER);
				rs = cs.executeQuery();
				exists =cs.getInt(1);
				System.out.println("taskListupdate exists:"+exists);
				
				strbuf.setLength(0);
				strbuf.append("{call taskListdelete(?)}");
				
				cs = con.prepareCall(strbuf.toString());
				cs.registerOutParameter(1, java.sql.Types.INTEGER);
				rs = cs.executeQuery();
				exists =cs.getInt(1);
				System.out.println("taskListdelete exists:"+exists);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) 	{ try { rs.close(); 	} catch (Exception e) {} }
			if (cs != null) 	{ try { cs.close(); 	} catch (Exception e) {} }
			if (con != null) 	{ try { con.close(); 	} catch (Exception e) {} }
		}
		
		System.out.println("end............");
	}
	
	

}
