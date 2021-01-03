package com.music.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.music.dao.FoodDao;
import com.music.dao.impl.FoodDaoImpl;
import com.music.pojo.Food;
public class FoodList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    FoodDao foodDao = new FoodDaoImpl();

    public FoodList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String state = request.getParameter("state");
        System.out.println(state);
        List<Food> foodlist = foodDao.showFood();
        request.setAttribute("FoodList", foodlist);
        System.out.println("foodlist:state" +state);

        if("NewFood".equals(state)){

            request.getRequestDispatcher("NewMusic.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("FoodList.jsp").forward(request, response);
        }
    }

}
