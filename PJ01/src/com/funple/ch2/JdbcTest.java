package com.funple.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JdbcTest {

	private Connection getDBConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {

			conn = DriverManager
					.getConnection("jdbc:mysql://192.168.0.201/test?user=maktbdev&password=akzmxnqRoqkf123$");
			System.out.println("conn " + conn.getCatalog());
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}

	public void viewTable(Connection con) {

		Statement stmt = null;
		String query = "select tid,tname from mytable ";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String tname = rs.getString("tname");
				int tid = rs.getInt("tid");
				System.out.print("tid : " + tid);
				System.out.println(", tname : " + tname);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void viewTable2(Connection con, int param1) {
		PreparedStatement pstmt = null;
		String query = "select tid,tname from mytable where tid = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, param1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String tname = rs.getString("tname");
				int tid = rs.getInt("tid");
				System.out.print("tid : " + tid);
				System.out.println(", tname : " + tname);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void insertTable(Connection con, int param1, String param2) {
		PreparedStatement pstmt = null;
		String query = "insert into mytable( tid , tname ) values ( ? , ? )";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, param1);
			pstmt.setString(2, param2);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void updateTable(Connection con, int param1, String param2) {
		PreparedStatement pstmt = null;
		String query = "update mytable set tname = ? where tid = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(2, param1);
			pstmt.setString(1, param2);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void deleteTable(Connection con, int param1) {
		PreparedStatement pstmt = null;
		String query = "delete from mytable where tid = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, param1);
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public List<MyTableBean> getMyTableList(Connection con) {
		List<MyTableBean> list = new ArrayList<MyTableBean>();
		Statement stmt = null;
		String query = "select tid,tname from mytable ";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				MyTableBean bean = new MyTableBean();
				String tname = rs.getString("tname");
				int tid = rs.getInt("tid");
				System.out.print("tid : " + tid);
				System.out.println(", tname : " + tname);
				bean.setTid(tid);
				bean.setTname(tname);
				list.add(bean);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public List<HashMap> getMyTableHashMapList(Connection con) {
		List<HashMap> list = new ArrayList<HashMap>();
		Statement stmt = null;
		String query = "select tid,tname from mytable ";
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				HashMap bean = new HashMap();
				String tname = rs.getString("tname");
				int tid = rs.getInt("tid");
				//System.out.print("tid : " + tid);
				//System.out.println(", tname : " + tname);
				bean.put("tid", tid);
				bean.put("tname", tname);
				list.add(bean);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return list;
	}
	public void insertTable(Connection con, MyTableBean paramBean) {
		PreparedStatement pstmt = null;
		String query = "insert into mytable( tid , tname ) values ( ? , ? )";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, paramBean.getTid());
			pstmt.setString(2, paramBean.getTname());
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcTest jt = new JdbcTest();
		Connection conn = jt.getDBConnection();
		// jt.viewTable2(conn,1);
		// jt.insertTable(conn , 15 , "15번");
		// jt.updateTable(conn , 15 , "shhan");
		// jt.deleteTable(conn , 3 );
		// jt.viewTable(conn);
		/*List<MyTableBean> myList = jt.getMyTableList(conn);
		System.out.println("myList.size() = " + myList.size());
		for (int i = 0; i < myList.size(); i++) {
			MyTableBean myBean = myList.get(i);
			System.out.print("myBean" + myBean.getTid());
			System.out.println(", tname =" + myBean.getTname());
		}
		List<HashMap> list = jt.getMyTableHashMapList(conn);
		for (int i = 0; i < list.size(); i++) {
			HashMap map = list.get(i);
			System.out.print("map tid = " + map.get("tid"));
			System.out.println(" , tname = " + map.get("tname"));
		}*/
		MyTableBean bean = new MyTableBean();
		bean.setTid(32);
		bean.setTname("테스트중입니다.");
		jt.insertTable(conn , bean);
		List<MyTableBean> myList = jt.getMyTableList(conn);
		System.out.println("myList.size() = " + myList.size());
		for (int i = 0; i < myList.size(); i++) {
			MyTableBean myBean = myList.get(i);
			System.out.print("myBean" + myBean.getTid());
			System.out.println(", tname =" + myBean.getTname());
		}
	}

}
