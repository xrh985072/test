package com.music.servlet;

import com.music.dao.FoodDao;
import com.music.dao.impl.FoodDaoImpl;
import com.music.pojo.Food;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class FoodManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    FoodDao foodDao = new FoodDaoImpl();

    public FoodManagerServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String state = request.getParameter("state");
        System.out.println(request.getParameterNames());
        Enumeration<String> a=request.getParameterNames();
        while(a.hasMoreElements()){
            System.out.println(a.nextElement());
        }
        System.out.println("没显示吗"+request.getParameter("state"));
        System.out.println(request.getParameter("id"));
        System.out.println("food state:"+state);

        System.out.println("ttest"+state);
        if("delete".equals(state)){
            delete(request,response);
        }else if("add".equals(state) ){
            add(request,response);
        }else if ("foodList".equals(state)){
            foodList(request,response);
        }else if("update".equals(state)){
            update(request,response);
        }else if("search".equals(state)){
            System.out.println(321321312);
            search(request,response);
        }

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int mid = Integer.parseInt(request.getParameter("id"));
        System.out.println("!!!!!!!!!!!!!!!!!!");
        System.out.println(mid);
        int count = foodDao.deleteFood(mid);
        if(count>0){
            List<Food> foodlist = foodDao.showFood();
            request.setAttribute("FoodList", foodlist);
            request.getRequestDispatcher("FoodManager.jsp").forward(request, response);
        }
        System.out.println("deleteeeeee");
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---------------------");
        String name =request.getParameter("name");
        Integer inventory = Integer.valueOf(request.getParameter("inventory"));
        Double price =Double.valueOf(request.getParameter("price"));
//        Integer salenumber = Integer.valueOf(request.getParameter("salenumber"));
        String t_type = request.getParameter("t_type");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String logintime=sdf.format(new Date());
//		fileSize = fileSize+"MB";
//		System.out.println("people:"+people);
        Food food = new Food(name,inventory,price,t_type);
        System.out.println(food.toString());
        int count =foodDao.addFood(food);
        if(count>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("update.................................");
        String name =request.getParameter("name");
        Integer inventory = Integer.valueOf(request.getParameter("inventory"));
        Double price =Double.valueOf(request.getParameter("price"));
        int mid = Integer.parseInt(request.getParameter("id"));
        System.out.println(mid);
        Food food = new Food(name, inventory , price );
        System.out.println("111"+food);
        foodDao.updateFood(mid, food);
        System.out.println("mmm"+food);
        System.out.println("updateeeeeee");

    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
        int mid = Integer.parseInt(request.getParameter("id"));
        System.out.println("mmm"+mid);
        List<Food> foodsearch = foodDao.searchFood(mid);
        System.out.println(foodsearch);

        request.setAttribute("FoodList", foodsearch);

        System.out.println("111111111111111111111111111111111111111111111111111111111111");
        System.out.println(foodsearch);
        request.getRequestDispatcher("shiyan.jsp").forward(request, response);
//        request.getRequestDispatcher("FoodManager.jsp").forward(request, response);
//        request.getRequestDispatcher("/FoodSearch").forward(request, response);
    }

    protected void foodList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Food> foodlist = foodDao.showFood();
        request.setAttribute("FoodList", foodlist);
        request.setAttribute("state","foodList");
        request.getRequestDispatcher("FoodManager.jsp").forward(request, response);
    }

}
