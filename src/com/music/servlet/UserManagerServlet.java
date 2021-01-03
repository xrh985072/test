package com.music.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.dao.UserDao;
import com.music.dao.impl.UserDaoImpl;
import com.music.pojo.User;

public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();

    public UserManagerServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String state = request.getParameter("state");
		System.out.println("state:"+state);
		if("delete".equals(state)){
			delete(request,response);
		}else if("add".equals(state) ){
			add(request,response);
		}else if ("userList".equals(state)){
			userList(request,response);
		}else if("update".equals(state)){
			update(request,response);
		}
		
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int uid = Integer.parseInt(request.getParameter("userid"));
		int count = userDao.deleteUser(uid);
		if(count>0){
			List<User> userlist = userDao.findUser();
			request.setAttribute("userList", userlist);
			request.getRequestDispatcher("UserManager.jsp").forward(request, response);
		}
		
	}
	protected void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userlist = userDao.findUser();
		request.setAttribute("userList", userlist);
		request.getRequestDispatcher("UserManager.jsp").forward(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=sdf.format(new Date());
		
		User user = new User(username,password,phone,email,date);
		int count = userDao.addUser(user);
		if(count>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("userid"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		System.out.println(uid);
		
		User user = new User(username,password,phone,email);
		int count = userDao.updateUser(uid, user);
		if(count>0){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}

}
