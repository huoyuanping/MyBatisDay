package com.et.lesson03.resultMap.xml;
/**
 * 多对一
 * 查询学生时将班级也查出
 * @author Administrator
 *
 */
public class Student {
	private int sid;
	private String sname;
	private Grade grade;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}
