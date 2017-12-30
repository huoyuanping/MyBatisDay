package com.et.lesson04.annotation;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.et.lesson04.xml.Student;

public class StudentProvier {
	/**
	 * 通过键值对方式传参
	 * ${}在注解中会失效
	 * 提供sql语句方法的参数是Map  键值对
	 * 对象的属性取值用别名.属性名
	 * @return
	 */
	public  String queryStudentByIdSql(Map map){
		Student st=(Student)map.get("stu");
		String sql=" select * from student where 1=1 ";
		if(st.getSname()!=null &&!"".equals(st.getSname())){
			st.setSname("%"+st.getSname()+"%");
			sql+=" and sname like #{stu.sname}";
		}
		if(st.getAddress()!=null && !"".equals(st.getAddress())){
			st.setAddress("%"+st.getAddress()+"%");
			sql+=" and address like #{stu.address}";
		}
		return sql;
	}
	
	public  String queryStudentBySql(Map map){
		Student st=(Student)map.get("stu");
		SQL sql=new SQL();
		sql.SELECT("*").FROM("student");
		if(st.getSname()!=null &&!"".equals(st.getSname())){
			st.setSname("%"+st.getSname()+"%");
			sql.WHERE(" sname like #{stu.sname}");
			
		}
		if(st.getAddress()!=null && !"".equals(st.getAddress())){
			st.setAddress("%"+st.getAddress()+"%");
			sql.AND();
			sql.WHERE(" address like #{stu.address}");
		}
		return sql.toString();
	}
	
	public String updateStudentSql(Map map){
		Student st=(Student)map.get("stud");
		SQL sql=new SQL();
		sql.UPDATE("student");
			if(st.getSname()!=null || !"".equals(st.getSname())){
			
				sql.SET("sname=#{stud.sname}");
			}
			if(st.getSex()!=null || !"".equals(st.getSex()) ){
				sql.SET("sex=#{stud.sex}");
			}
			
			if(st.getAge()!=null || !"".equals(st.getAge())){
				sql.SET("age=#{stud.age}");
			}
			sql.WHERE("sid=#{stud.sid}");
			return sql.toString();
	}	
	
	public String queryStudentAndGradeBySql(Map map){
		List<String> list=(List<String>)map.get("gradeList");
		SQL sql=new SQL();
		sql.SELECT("*").FROM("student");
		String str="";
		for (String stu : list) {
			str+=stu+",";
		}
		String st=str.substring(0, str.length()-1);
		sql.WHERE(" gid in ("+st+")");
		return sql.toString();
	}	
	
}
