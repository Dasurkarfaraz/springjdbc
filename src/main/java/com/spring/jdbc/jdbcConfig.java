package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.deo.studentdeo;
import com.spring.jdbc.deo.studentdeoimp;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.deo"})
public class jdbcConfig {

		@Bean(name = {"ds"})
		public DataSource getDataSource() {
			
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
			ds.setUsername("root");
			ds.setPassword("3diadmin");
			return ds;
			
		}
		@Bean(name = {"JDBCtemplate"})
		public JdbcTemplate getTeamplete() {
			JdbcTemplate jdbcTemplate = new JdbcTemplate();
			jdbcTemplate.setDataSource(getDataSource());
			return jdbcTemplate;
		}
//		@Bean("Studentdeo")
//		public studentdeo  getStudentDeo(){
//			studentdeoimp studentdeoimp = new studentdeoimp();
//			studentdeoimp.setJDBCtemplate(getTeamplete());
//			return studentdeoimp;
//			
//			}
}
