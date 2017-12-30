package com.et.lesson03.resultMap.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * 一对多
 * 班级实体
 * @author Administrator
 *
 */
public class Grade {
	private int gid;
	private String gname;
	private List<Student>  studentList=new ArrayList<Student>();
	
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
}
