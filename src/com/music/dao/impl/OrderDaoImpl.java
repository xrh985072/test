package com.music.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.music.dao.OrderDao;
import com.music.pojo.Order;
import com.music.util.JDBCUtil;

public class OrderDaoImpl implements OrderDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;;
    ResultSet rs = null;

    @Override
    public int addOrder(Order order) {
        int count = -1;
        String sql = "insert into o_order (orderid,id,username,number,price,phone,address,ordertime) values(?,?,?,?,?,?,?,?)";
        conn = JDBCUtil.getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,order.getOrderid());
            pstmt.setString(2,order.getId());
            pstmt.setString(3,order.getUsername());
            pstmt.setInt(4,order.getNumber());
            pstmt.setDouble(5,order.getPrice());
            pstmt.setString(6,order.getPhone());
            pstmt.setString(7,order.getAddress());
            pstmt.setString(8,order.getOrdertime());
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
    public int deleteOrder(int mid) {

        int count = -1;
        String sql = "delete from o_order where orderid=?";
        conn = JDBCUtil.getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,mid);

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
    public int updateOrder(int mid, Order order) {
        int count = -1;
        String sql = "update o_order set id=?,username=?,phone=?,address=? where orderid=?";

        conn = JDBCUtil.getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,order.getId());
            pstmt.setString(2,order.getUsername());
            pstmt.setString(3,order.getPhone());
            pstmt.setString(4,order.getAddress());
            pstmt.setInt(5,mid);

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.closeAll(conn, rs, pstmt, stmt);
        }

        return count;



    }

    @Override
    public List<Order> showOrder() {
        List<Order> list = new ArrayList<Order>();
        String sql="select orderid,id,username,number,price,phone,address,ordertime from o_order ";
        conn=JDBCUtil.getConn();
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Order order =
                        new Order(rs.getInt("orderid"),
                                rs.getString("id"),
                                rs.getString("username"),
                                rs.getInt("number"),
                                rs.getDouble("price"),
                                rs.getString("phone"),
                                rs.getString("address"),
                                rs.getString("ordertime")
                        );
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return   list;

    }

}
