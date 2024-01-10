package com.spring.jdbc.deo;

import java.util.List;

import com.spring.jdbc.Student;

public interface studentdeo {
	public int change(Student student);
	public int insert(Student student);
	public int delete(Student student);
	public int delete(int i);
	public Object viewdata(int std);
	public List<Object> allvalue();

}
