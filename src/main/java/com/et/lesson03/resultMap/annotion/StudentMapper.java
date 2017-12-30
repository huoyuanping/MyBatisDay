package com.et.lesson03.resultMap.annotion;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.et.lesson03.resultMap.xml.Student;

/**
 *多对一
 * @author Administrator
 *
 */
public interface StudentMapper {
	/**
	 * 通过编号查询学生
	 * 列名不同是要映射@Result(column="ganme",property="ganme1")
	 * 相同的时候自动映射
	 *多对一
	 * one=@One(select="全路径.接口名.方法名 ")
	 * @param 
	 * @return
	 */
	@Results({
		@Result(column="gid",property="grade",one=@One(select="com.et.lesson03.resultMap.annotion.GradeMapper.queryGradeById"))
	})
	@Select("select * from student where sid=#{0}")
	public Student queryStudentById(String sid);
	
	
	/**
	 * 一对多
	 * @param gid
	 * @return
	 */
	@Select("select * from student where gid=#{0}")
	public List<Student> queryStudentByGid(String gid);
}
