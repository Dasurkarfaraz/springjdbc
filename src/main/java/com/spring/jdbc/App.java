package com.spring.jdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.deo.studentdeo;
import com.spring.jdbc.deo.studentdeoimp;

public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context=  new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
        studentdeo sbean = context.getBean("Studentdeo", studentdeo.class);
        
        Student student= new Student();
        student.setCity("Mumbai");
        student.setId(10);
        student.setName("Dasurkar");
        int update = sbean.insert(student);
        Object viewdata1 = sbean.viewdata(10);
        System.out.println(viewdata1);
        System.out.println("Result is this... "+update);
        student.setCity("Thane Maharashtra");
        student.setId(10);
        student.setName("Jack");
        int update1 = sbean.change(student);
        System.out.println("Result is this... "+update1);
        Object viewdata = sbean.viewdata(10);
        System.out.println(viewdata);
        List<Object> allvalue = sbean.allvalue();
       // System.out.println(allvalue +"\n");
        for (Object object : allvalue) {
			System.out.println(object);
		}
        int delete = sbean.delete(student);
        System.out.println("Delete result..." +delete);
//        int delete2 = sbean.delete(68);
//        System.out.println(delete2);
        
        
    }
}
