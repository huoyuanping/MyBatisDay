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
 * 接口
 * @author Administrator
 *
 */
public interface FoodMap {
	/**
	 * 根据名称查询所有的菜品信息
	 * @Param("foodName")可以指定参数 例如foodname=#{foodName}
	 * @param foodName
	 * @return
	 */
	@Select("select * from food where  foodname=#{foodName} and price=#{price}")
	public List<Map> queryFood(@Param("foodName")String foodName,@Param("price")String price);
	/**
	 * 通过菜品id删除
	 * @param foodId
	 */
	@Delete(" delete from FOOD where FOODID=#{0}")
	public void deleteFood(String foodId);
	
	/**
	 * 通过名字模糊查找
	 * @param foodName
	 * @return
	 */
	@Select("select * from food where  foodname like '%${foodName}%'")
	public List<Food> queryFoodByName(@Param("foodName") String foodName);
	
	/**
	 * 插入food
	 * before=true 表示insert之前执行  false之后
	 * @param food
	 */
	@SelectKey(before=true,keyProperty="foodId", resultType=int.class, statement = "select Food_SEC.Nextval from dual" )
	@Insert("insert into food values(#{foodId},#{foodName},#{price})")
	public void saveFood(Food food);
}
