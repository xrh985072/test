package com.music.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.dao.OrderDao;
import com.music.dao.impl.OrderDaoImpl;
import com.music.pojo.Order;
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderDao orderDao = new OrderDaoImpl();

    public OrderList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String state = request.getParameter("state");
		List<Order> orderlist = orderDao.showOrder();
		request.setAttribute("orderList", orderlist);
		System.out.println("orderlist:state" +state);

		if("NewOrder".equals(state)){
			
			request.getRequestDispatcher("NewMusic.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("OrderList.jsp").forward(request, response);
		}
	}

}
