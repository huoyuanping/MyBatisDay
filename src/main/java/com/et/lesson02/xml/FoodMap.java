package com.et.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.et.lesson02.Food;

/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface FoodMap {
	/**
	 * �������Ʋ�ѯ���еĲ�Ʒ��Ϣ
	 * @param foodName
	 * @return
	 */
	public List queryFood(String foodName,String price);
	/**
	 * ͨ����Ʒidɾ��
	 * @param foodId
	 */
	public void deleteFood(String foodId);
	
	/**
	 * ͨ������ģ������
	 * @param foodName
	 * @return
	 */
	public List queryFoodByName(@Param("foodName") String foodName);
	
	/**
	 * ����food
	 * @param food
	 */
	public void saveFood(Food food);
}
