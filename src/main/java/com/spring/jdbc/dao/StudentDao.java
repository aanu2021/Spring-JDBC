package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import java.util.List;

public interface StudentDao {
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(int id);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
    public List<Student> getAllStudentsByCity(String city);
    public List<Student> getAllStudentsByIdAndCity(int id1, int id2, String city);
}
