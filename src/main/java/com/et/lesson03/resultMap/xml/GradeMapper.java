package com.et.lesson03.resultMap.xml;

import java.util.List;

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
	 * һ�Զ�
	 * @param gid
	 * @return
	 */
	public Grade queryGrade(String gid);
	
}
