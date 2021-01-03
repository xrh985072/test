package com.music.dao;

import java.util.List;

import com.music.pojo.Order;
public interface OrderDao {
    public int addOrder(Order order);
    public int deleteOrder(int mid);
    public int updateOrder(int mid, Order order);
    public List<Order> showOrder();
}
