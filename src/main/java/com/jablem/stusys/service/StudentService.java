package com.jablem.stusys.service;

import com.jablem.stusys.po.Student;

import java.util.List;

public interface StudentService {
    public List<Student> selectAll();
    public Student select(Student s);
    public Student selectByNameAndPass(Student s);
    public int removeStudent(Student s);
    public int addStudent(Student s);
    public int updateStudent(Student s);
}
