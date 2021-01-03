package com.music.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.music.dao.FoodDao;
import com.music.pojo.Food;
import com.music.util.JDBCUtil;

public class FoodDaoImpl implements FoodDao {

    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;;
    ResultSet rs = null;

    @Override
        public int addFood(Food food) {
        int count = -1;
        String sql = "insert into food (name,inventory,price,salenumber,t_type) values(?,?,?,?,?)";
        conn = JDBCUtil.getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,food.getName());
            pstmt.setInt(2,food.getInventory());
            pstmt.setDouble(3,food.getPrice());
            pstmt.setInt(4,0);
            pstmt.setString(5,food.getT_type());
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
    public int deleteFood(int mid) {

        int count = -1;
        String sql = "delete from food where id=?";
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

    public List<Food> searchFood(int mid) {
        List<Food> list = new ArrayList<Food>();
        String sql="select * from food where id="+mid;
        conn=JDBCUtil.getConn();
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Food food =
                        new Food(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("inventory"),
                                rs.getDouble("price"),
                                rs.getInt("salenumber"),
                                rs.getString("t_type")
                        );
                list.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return   list;
    }


    @Override
    public int updateFood(int mid, Food food) {
        int count = -1;
        String sql = "update food set name=?,inventory=?,price=? where id=?";

        conn = JDBCUtil.getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,food.getName());
            pstmt.setInt(2,food.getInventory());
            pstmt.setDouble(3,food.getPrice());
            pstmt.setInt(4,mid);

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.closeAll(conn, rs, pstmt, stmt);
        }

        return count;



    }

    @Override
    public List<Food> showFood() {
        List<Food> list = new ArrayList<Food>();
        String sql="select * from food ";
        conn=JDBCUtil.getConn();
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Food food =
                        new Food(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("inventory"),
                                rs.getDouble("price"),
                                rs.getInt("salenumber"),
                                rs.getString("t_type")
                        );
                list.add(food);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return   list;
    }

}
