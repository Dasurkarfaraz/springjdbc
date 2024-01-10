package com.spring.jdbc.deo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Student;

public class RowMapperimp implements RowMapper<Object>{

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setCity(rs.getString(2));
		student.setName(rs.getString(3));
		return student;
	}

}
