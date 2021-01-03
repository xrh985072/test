package com.music.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.music.dao.UserDao;
import com.music.pojo.User;
import com.music.util.JDBCUtil;

public class UserDaoImpl implements UserDao{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;;
	ResultSet rs = null;
	
	@Override
	public int addUser(User user) {
		int count = -1;
		String sql = "insert into user (username,password,email,phone,logintime) values(?,?,?,?,?)";
		conn = JDBCUtil.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getPhone());
			pstmt.setString(5,  user.getLogintime());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, rs, pstmt, stmt);
		}
		
		return count;
	}

	@Override
	public int loginUser(User user) {
		int count=0;
		 String sql="select count(1) as cnum from user where username =? and password=?";
		 conn=JDBCUtil.getConn();
		 try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt("cnum");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return count;
	}

	@Override
	public List<User> findUser() {
		List<User> list = new ArrayList<User>();
		 String sql="select id,username,password,email,phone,logintime from user  ";
		 conn=JDBCUtil.getConn();
		 try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				User user = 
				new User(rs.getInt("id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("logintime"));
				list.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return   list;
	}

	@Override
	public int deleteUser(int uid) {
		
		int count = -1;
		String sql = "delete from user where id=?";
		conn = JDBCUtil.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,uid);

			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, rs, pstmt, stmt);
		}
		
		return count;
	}


	@Override
	public int updateUser(int uid, User user) {

		int count = -1;
		String sql = "update user set username=? , password=? , email=? ,phone=? where id=?";
		conn = JDBCUtil.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getPhone());
			pstmt.setInt(5,uid);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeAll(conn, rs, pstmt, stmt);
		}
		
		return count;
	}}
