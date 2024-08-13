package com.jablem.stusys.dao;

import com.jablem.stusys.po.Student;
import java.util.List;

public interface StudentDao {
    public List<Student> selectAll();
    public Student select(Student s);
    public Student selectByNameAndPass(Student s);
    public int removeStudent(Student s);
    public int addStudent(Student s);
    public int updateStudent(Student s);
}
