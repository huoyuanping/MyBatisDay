 package com.et.lesson05.xml;

import java.io.Serializable;

/**
 * ��ѯѧ��ʱ���༶Ҳ���
 * @author Administrator
 *
 */
public class Student implements Serializable{
	private String sid;
	private String sname;
	private Integer sex;
	private Integer age;
	private String address;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
