package com.jablem.stusys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jablem.stusys.po.Student;
import com.jablem.stusys.service.StudentService;
import com.jablem.stusys.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentController extends HttpServlet {
    private final StudentService service = new StudentServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("act");
        if("selectAll".equals(act)){
            selectAll(req,resp);
        } else if("selectStudent".equals(act)){
            selectStudent(req,resp);
        }else if("addStudent".equals(act)){
            addStudent(req,resp);
        }else if("updateStudent".equals(act)){
            updateStudent(req,resp);
        }else if("removeStudent".equals(act)){
            removeStudent(req,resp);
        }else if("login".equals(act)){
            selectByNameAndPass(req,resp);
        }else if("logout".equals(act)){
            logout(req,resp);
        }else {
            System.out.println("--in StudentController, act error");
        }
    }

    private void selectStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //        if(req.getSession().getAttribute("admin") = null){
        //            return;
        //        }
        int id = Integer.parseInt(req.getParameter("id"));
        String stuname = req.getParameter("stuname");
        String pass = req.getParameter("pass");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String birthdate = req.getParameter("birthdate");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        Student s = new Student(id, stuname, gender, pass, birthdate, age, address, phone);

        Student student = service.select(s);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        try {
            out.print(om.writeValueAsString(student));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("student");
        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print("logout_ok");
        out.close();
    }

    private void selectByNameAndPass(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();

        if(req.getSession().getAttribute("student") != null){
            out.println("already_login");
            return;
        }
        if(req.getSession()==null){
            req.getSession().removeAttribute("student");
        }
        String stuname = req.getParameter("stuname");
        String pass = req.getParameter("pass");
        Student s = new Student();
        s.setStuname(stuname);
        s.setPass(pass);

        Student student = service.selectByNameAndPass(s);
        req.getSession().setAttribute("student", student);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        out.println(om.writeValueAsString(student));
        out.close();
    }

    private void removeStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        if(req.getSession().getAttribute("admin") = null){
//            return;
//        }
        int id = Integer.parseInt(req.getParameter("id"));
        Student s = new Student();
        s.setId(id);
        int i = service.removeStudent(s);

        PrintWriter out = resp.getWriter();
        out.println(i);
        out.close();
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String stuname = req.getParameter("stuname");
        String pass = req.getParameter("pass");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String birthdate = req.getParameter("birthdate");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        Student s = new Student();
        s.setStuname(stuname);
        s.setPass(pass);
        s.setAge(age);
        s.setGender(gender);
        s.setBirthdate(birthdate);
        s.setAddress(address);
        s.setPhone(phone);

        int i = service.updateStudent(s);
        PrintWriter out = resp.getWriter();
        out.println(i);
        out.close();
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getSession()==null){
            req.getSession().removeAttribute("student");
        }
        int id = Integer.parseInt(req.getParameter("id"));
        String stuname = req.getParameter("stuname");
        String pass = req.getParameter("pass");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String birthdate = req.getParameter("birthdate");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        Student s = new Student(id, stuname, gender, pass, birthdate, age, address, phone);

        int i = service.addStudent(s);
        Student student = service.selectByNameAndPass(s);
        req.getSession().setAttribute("student", student);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        try {
            out.print(om.writeValueAsString(student));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Student> list = service.selectAll();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        PrintWriter out = resp.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        out.print(objectMapper.writeValueAsString(list));
        out.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
