package com.spring.jdbc.deo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.Student;

@Component("Studentdeo")
public class studentdeoimp  implements studentdeo {
	
	@Autowired
	private JdbcTemplate JDBCtemplate;
	


	public JdbcTemplate getJDBCtemplate() {
		return JDBCtemplate;
	}



	public void setJDBCtemplate(JdbcTemplate jDBCtemplate) {
		JDBCtemplate = jDBCtemplate;
	}



	public int insert(Student student) {
		String sql = "Insert into student(id,name,city) values(?,?,?)";
        int update = this.JDBCtemplate.update(sql,student.getId(),student.getName(),student.getCity());
		return update;
	}



	public int change(Student student) {
		
		String sql = "update student set name=? ,city=? where id=?";
        int update = this.JDBCtemplate.update(sql,student.getName(),student.getCity(),student.getId());
		return update;
	}



	public int delete(Student student) {
		String sql = "delete from student where id=?";
        int update = this.JDBCtemplate.update(sql,student.getId());
		return update;
	}


	public int delete(int  student) {
		String sql = "delete from student where id=?";
        int update = this.JDBCtemplate.update(sql,student);
		return update;
	}



	public Object viewdata(int student) {
		String sql = "select * from student where id=?";
		RowMapper<Object> rowMapper = new RowMapperimp();
        Object Student = this.JDBCtemplate.queryForObject(sql,rowMapper,student);
		return Student;	
	}



	public List<Object> allvalue() {
		// Selecting allvalues from database
		String sql = "Select * from student";
		List<Object> query = this.JDBCtemplate.query(sql, new RowMapperimp());
		return query;
	}

	

	

}
