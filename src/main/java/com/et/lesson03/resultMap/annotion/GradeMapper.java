package com.et.lesson03.resultMap.annotion;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.et.lesson03.resultMap.xml.Grade;

/**
 * 接口
 * @author Administrator
 *
 */
public interface GradeMapper {
	/**
	 * 查询所有的班级
	 * @param 
	 * @return
	 */
	public List queryAllGrade();
	
	/**
	 * 通过id查找所有的班级
	 * @param gid
	 * @return
	 * 一对多
	 */
	@Results({
		@Result(column="gid",property="studentList",javaType=ArrayList.class,many=@Many(
				select="com.et.lesson03.resultMap.annotion.StudentMapper.queryStudentByGid"
				))
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGrade(String gid);
	
	/**
	 * 多对一
	 * @param gid
	 * @return
	 */
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeById(String gid);
	
}
