package com.et.lesson02.annotion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.et.lesson02.Food;


/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface FoodMap {
	/**
	 * �������Ʋ�ѯ���еĲ�Ʒ��Ϣ
	 * @Param("foodName")����ָ������ ����foodname=#{foodName}
	 * @param foodName
	 * @return
	 */
	@Select("select * from food where  foodname=#{foodName} and price=#{price}")
	public List<Map> queryFood(@Param("foodName")String foodName,@Param("price")String price);
	/**
	 * ͨ����Ʒidɾ��
	 * @param foodId
	 */
	@Delete(" delete from FOOD where FOODID=#{0}")
	public void deleteFood(String foodId);
	
	/**
	 * ͨ������ģ������
	 * @param foodName
	 * @return
	 */
	@Select("select * from food where  foodname like '%${foodName}%'")
	public List<Food> queryFoodByName(@Param("foodName") String foodName);
	
	/**
	 * ����food
	 * before=true ��ʾinsert֮ǰִ��  false֮��
	 * @param food
	 */
	@SelectKey(before=true,keyProperty="foodId", resultType=int.class, statement = "select Food_SEC.Nextval from dual" )
	@Insert("insert into food values(#{foodId},#{foodName},#{price})")
	public void saveFood(Food food);
}
