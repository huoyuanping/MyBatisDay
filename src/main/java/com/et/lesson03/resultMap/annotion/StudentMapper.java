package com.et.lesson03.resultMap.annotion;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.et.lesson03.resultMap.xml.Student;

/**
 *���һ
 * @author Administrator
 *
 */
public interface StudentMapper {
	/**
	 * ͨ����Ų�ѯѧ��
	 * ������ͬ��Ҫӳ��@Result(column="ganme",property="ganme1")
	 * ��ͬ��ʱ���Զ�ӳ��
	 *���һ
	 * one=@One(select="ȫ·��.�ӿ���.������ ")
	 * @param 
	 * @return
	 */
	@Results({
		@Result(column="gid",property="grade",one=@One(select="com.et.lesson03.resultMap.annotion.GradeMapper.queryGradeById"))
	})
	@Select("select * from student where sid=#{0}")
	public Student queryStudentById(String sid);
	
	
	/**
	 * һ�Զ�
	 * @param gid
	 * @return
	 */
	@Select("select * from student where gid=#{0}")
	public List<Student> queryStudentByGid(String gid);
}
