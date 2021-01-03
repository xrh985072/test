package com.music.servlet;

import com.music.dao.OrderDao;
import com.music.dao.impl.OrderDaoImpl;
import com.music.pojo.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class OrderManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 OrderDao orderDao = new OrderDaoImpl();
	 
    public OrderManagerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String state = request.getParameter("state");
		
		System.out.println("order state:"+state);

		System.out.println("ttest"+state);
		if("delete".equals(state)){
			delete(request,response);
		}else if("add".equals(state) ){
			add(request,response);
		}else if ("orderList".equals(state)){
			orderList(request,response);
		}else if("update".equals(state)){
			update(request,response);
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mid = Integer.parseInt(request.getParameter("orderid"));
		System.out.println("!!!!!!!!!!!!!!!!!!");
		System.out.println(mid);
		int count = orderDao.deleteOrder(mid);
		if(count>0){
			List<Order> orderlist = orderDao.showOrder();
			request.setAttribute("orderList", orderlist);
			request.getRequestDispatcher("OrderManager.jsp").forward(request, response);
		}
		System.out.println("deleteeeeee");
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("---------------------");
		Integer orderid =Integer.valueOf(request.getParameter("orderid"));
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		Integer number = Integer.valueOf(request.getParameter("number"));
		Double price = Double.valueOf(request.getParameter("price"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String ordertime = request.getParameter("ordertime");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String logintime=sdf.format(new Date());
//		fileSize = fileSize+"MB";
//		System.out.println("people:"+people);
		Order order = new Order(orderid, id, username, number, price, phone, address, ordertime);
		System.out.println("tsss?"+order);
		System.out.println(order.toString());
		int count =orderDao.addOrder(order);
		if(count>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update.................................");
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		int mid = Integer.parseInt(request.getParameter("orderid"));
		System.out.println(mid);
		Order order = new Order( id, username,  phone , address);
		System.out.println("111"+order);
		 orderDao.updateOrder(mid, order);
		System.out.println("updateeeeeee");
		
	}
	protected void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orderlist = orderDao.showOrder();
		request.setAttribute("orderList", orderlist);
		request.getRequestDispatcher("OrderManager.jsp").forward(request, response);
	}

}
