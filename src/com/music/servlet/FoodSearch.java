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
@WebServlet("/FoodSearch")
public class FoodSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;
    FoodDao foodDao = new FoodDaoImpl();

    public FoodSearch() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dsajiodasjiod");

        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String state = request.getParameter("state");
        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(state);
        List<Food> foodsearch = foodDao.searchFood(id);
        System.out.println("ddd"+id);
        request.setAttribute("foodList", foodsearch);
        request.setAttribute("list",foodsearch);
        System.out.println("foodsearch:state" +state);
        System.out.println("abc"+request.getParameter("foodList"));

        if("NewFood".equals(state)){

            request.getRequestDispatcher("error.jsp").forward(request, response);
        }else{
//            System.out.println(312421);
//            request.getRequestDispatcher("FoodManager.jsp").forward(request, response);
            request.getRequestDispatcher("shiyan2.jsp").forward(request, response);
        }
    }

}
