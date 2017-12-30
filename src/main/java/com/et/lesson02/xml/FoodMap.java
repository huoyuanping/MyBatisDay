package com.et.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.et.lesson02.Food;

/**
 * 接口
 * @author Administrator
 *
 */
public interface FoodMap {
	/**
	 * 根据名称查询所有的菜品信息
	 * @param foodName
	 * @return
	 */
	public List queryFood(String foodName,String price);
	/**
	 * 通过菜品id删除
	 * @param foodId
	 */
	public void deleteFood(String foodId);
	
	/**
	 * 通过名字模糊查找
	 * @param foodName
	 * @return
	 */
	public List queryFoodByName(@Param("foodName") String foodName);
	
	/**
	 * 插入food
	 * @param food
	 */
	public void saveFood(Food food);
}
