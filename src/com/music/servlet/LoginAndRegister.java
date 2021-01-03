package com.music.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.dao.UserDao;
import com.music.pojo.User;
import com.music.dao.impl.UserDaoImpl;

public class LoginAndRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao userDao = new UserDaoImpl();
    public LoginAndRegister() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String state = request.getParameter("state");
		int flag=0;
		
		if("login".equals(state)){
			User user = new User(username,password);
			int count = userDao.loginUser(user);
			
			if("admin".equals(username)){
				flag=1;
				request.getSession().setAttribute("flagaa", flag);
				System.out.println("admin  flag="+flag);
			}else{
				flag=0;
				request.getSession().setAttribute("flagaa", flag);
				System.out.println("not admin  flag="+flag);
			}
			
			if(count>0){
				request.getSession().setAttribute("SESSION_user", user.getUsername());
				System.out.println(count);
				request.getSession().setAttribute("SESSION_userid", count);
				if(flag==1){
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else{
					request.getRequestDispatcher("index1.jsp").forward(request,response);
				}
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else if ("register".equals(state)){
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date=sdf.format(new Date());
			System.out.println(sdf.format(new Date()));
			User user = new User(username,password,phone,email,date);
			request.getSession().setAttribute("SESSION_user", user.getUsername());
			int count = userDao.addUser(user);
			if(count>0){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else {

		}
	}

}
