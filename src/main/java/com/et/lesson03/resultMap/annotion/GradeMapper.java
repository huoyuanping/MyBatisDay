package com.et.lesson03.resultMap.annotion;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.et.lesson03.resultMap.xml.Grade;

/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface GradeMapper {
	/**
	 * ��ѯ���еİ༶
	 * @param 
	 * @return
	 */
	public List queryAllGrade();
	
	/**
	 * ͨ��id�������еİ༶
	 * @param gid
	 * @return
	 * һ�Զ�
	 */
	@Results({
		@Result(column="gid",property="studentList",javaType=ArrayList.class,many=@Many(
				select="com.et.lesson03.resultMap.annotion.StudentMapper.queryStudentByGid"
				))
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGrade(String gid);
	
	/**
	 * ���һ
	 * @param gid
	 * @return
	 */
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeById(String gid);
	
}
