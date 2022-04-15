package com.brainmentors.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utils.Encryption;

//Contains DB CRUD Operations
public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try {
			conn = CommonDAO.createConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedpwd = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedpwd);
			rs = pstmt.executeQuery();
			return rs.next();
//			if(rs.next()) {
//				return true;
//			}else {
//				return false;
//			}
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	
	//public int add(string userid, char[] password, String city, String address, String phone, String postal, String std)
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
		System.out.println("Rec: " + userDTO.getUserid() + "  " + userDTO.getPassword() + " " +userDTO.getEmail() + " " + userDTO.getCity() + " " + userDTO.getPhone());
		Connection connection = null;
		Statement stmt = null;
		try { //guarded region
		connection = CommonDAO.createConnection();  //Step-1 Create Connection
		//Step-2 We do a query
		stmt = connection.createStatement();
		int record = stmt.executeUpdate("insert into users (userid, password, email, city, phone) values('"+userDTO.getUserid()+"', '"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"', '"+userDTO.getEmail()+"', '"+userDTO.getCity()+"', '"+userDTO.getPhone()+"')");  //Insert,Delete,Update
		return record;
		}
		finally {  //Always execute(Resource Clean)
			if(stmt != null) {
				stmt.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	public static int changePassword(String userid, char[] np) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		Connection con = null;
		PreparedStatement pmt = null;
		int rs1 = 0;
		final String sql = "UPDATE users set password=? where userid=?";
		try {
		con = CommonDAO.createConnection();
		pmt = con.prepareStatement(sql);
		String encryptedpwd = Encryption.passwordEncrypt(new String(np));
		pmt.setString(1, encryptedpwd);
		pmt.setString(2, userid);
		rs1 = pmt.executeUpdate();
		return rs1;
		}
		finally {
			if(con != null) {
				con.close();
			}
			if(pmt != null) {
				pmt.close();
			}
		}
	}
}
