package com.jablem.stusys.service;

import com.jablem.stusys.dao.StudentDao;
import com.jablem.stusys.dao.StudentsDaoImpl;
import com.jablem.stusys.po.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentDao dao = new StudentsDaoImpl();

    @Override
    public List<Student> selectAll() {
        return dao.selectAll();
    }


    @Override
    public Student select(Student s) {
        return dao.select(s);
    }

    @Override
    public Student selectByNameAndPass(Student s) {
        return dao.selectByNameAndPass(s);
    }

    @Override
    public int removeStudent(Student s) {
        return dao.removeStudent(s);
    }

    @Override
    public int addStudent(Student s) {
        return dao.addStudent(s);
    }

    @Override
    public int updateStudent(Student s) {
        return dao.updateStudent(s);
    }
}
