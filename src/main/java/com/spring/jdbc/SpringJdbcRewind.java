package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcRewind {

    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao)context.getBean("studentDao");
        
        /*
        
        Student student = new Student(3,"Manas Pratim Biswas","Bangalore");
        int rows = studentDao.insertStudent(student);
        System.out.println("Rows inserted : " + rows);
        
        */
        
        /*
        
        Student student = new Student(2,"Ayush Sharma","Kerala");
        int rows = studentDao.updateStudent(student);
        System.out.println("Rows affected : " + rows);
        
        */
        
        /*
        
        int rows = studentDao.deleteStudent(3);
        System.out.println("Rows deleted : " + rows);
        
        */
        
        /*
        
        Student student = studentDao.getStudent(1);
        System.out.println(student.toString());
        
        */
        
        /*
        
        List<Student> students = studentDao.getAllStudents();
        for(Student student : students){
            System.out.println(student.toString());
        }
        
        */        
        
        /*
        
        List<Student> students = studentDao.getAllStudentsByCity("Kolkata");
        for(Student student : students){
            System.out.println(student.toString());
        }         
        
        */
  
        /*
        
        List<Student> students = studentDao.getAllStudentsByIdAndCity(3, 4, "Kolkata");
        for(Student student : students){
            System.out.println(student.toString());
        }  
        
        */
       
        
    }
}
