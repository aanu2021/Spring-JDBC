package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate NamedParameterJdbcTemplate;        

    public StudentDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate NamedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.NamedParameterJdbcTemplate = NamedParameterJdbcTemplate;
    }

    public StudentDaoImpl() {
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return NamedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate NamedParameterJdbcTemplate) {
        this.NamedParameterJdbcTemplate = NamedParameterJdbcTemplate;
    }
    
    @Override
    public int insertStudent(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int rows = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return rows;
    }

    @Override
    public int updateStudent(Student student) {
        String query = "update student set name = ? , city = ? where id = ?";
        int rows = jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return rows;
    }

    @Override
    public int deleteStudent(int id) {
        String query = "delete from student where id = ?";
        int rows = jdbcTemplate.update(query,id);
        return rows;
    }    

    @Override
    public Student getStudent(int id) {
        RowMapper<Student> rowMapper = new RowMapperImpl();
        String query = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
       RowMapper<Student> rowMapper = new RowMapperImpl();
       String query = "select * from student";
       List<Student> students = jdbcTemplate.query(query, rowMapper);
       return students;
    }

    @Override
    public List<Student> getAllStudentsByCity(String city) {
       String query = "select * from student where city = :city";
       MapSqlParameterSource params = new MapSqlParameterSource();
       params.addValue("city", city);
       List<Student> students = NamedParameterJdbcTemplate.query(query,params, new RowMapperImpl());
       return students;
    }

    @Override
    public List<Student> getAllStudentsByIdAndCity(int id1, int id2, String city) {
        String query = "select * from student where (id >= :id1 and id <= :id2) or (city = :city)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id1", id1);
        params.addValue("id2", id2);
        params.addValue("city",  city);
        List<Student> students = NamedParameterJdbcTemplate.query(query,params,new RowMapperImpl());
        return students;
    }
    
}
