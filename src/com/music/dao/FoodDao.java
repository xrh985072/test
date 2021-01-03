package com.music.dao;

import java.util.List;
import com.music.pojo.Food;

public interface FoodDao {
    public int addFood(Food food);
    public int deleteFood(int mid);
    public int updateFood(int mid, Food food);
    public List<Food> searchFood(int mid);
    public List<Food> showFood();
}
