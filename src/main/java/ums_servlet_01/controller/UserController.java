package ums_servlet_01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ums_servlet_01.po.User;
import ums_servlet_01.service.UserService;
import ums_servlet_01.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private final UserService service = new UserServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("act");
        if("selectAll".equals(act)){
            selectAll(req,resp);
        }else if("addUser".equals(act)){
            addUser(req,resp);
        }else if("updateUser".equals(act)){
            updateUser(req,resp);
        }else if("removeUser".equals(act)){
            removeUser(req,resp);
        }else if("login".equals(act)){
            selectByNameAndPass(req,resp);
        }else if("logout".equals(act)){
            logout(req,resp);
        }else {
            System.out.println("--in UserController, act error");
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("user");

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print("logout_ok");
        out.close();
    }

    private void selectByNameAndPass(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        User u = new User();
        u.setUname(uname);
        u.setPass(pass);

        User user = service.selectByNameAndPass(u);
        System.out.println("user="+user);
        req.getSession().setAttribute("user", user);

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print(om.writeValueAsString(user));
        out.close();
    }

    //	http://localhost:8080/user?act=selectAll&uname=t&birthday=2024
    protected void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String birthdate = req.getParameter("birthday");
        User u = new User();
        u.setUname(uname);
        u.setDate(birthdate);

        List<User> list = service.selectAll(u);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print(om.writeValueAsString(list));
        out.close();
    }
    //	http://localhost:8080/user?act=addUser&uname=t&pass=123&birthday=2024-08-09
    protected void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        String birthdate = req.getParameter("birthday");
        User u = new User();
        u.setUname(uname);
        u.setPass(pass);
        u.setDate(birthdate);

        int i = service.addUser(u);

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print(i);
        out.close();
    }
    //	http://localhost:8080/user?act=updateUser&uname=tom62&pass=6662&birthday=2024-02-02&id=1
    protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String uname = req.getParameter("uname");
        String pass = req.getParameter("pass");
        String birthdate = req.getParameter("birthday");
        User u = new User();
        u.setId(id);
        u.setUname(uname);
        u.setPass(pass);
        u.setDate(birthdate);

        int i = service.updateUser(u);

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print(i);
        out.close();
    }
    protected void removeUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        User u = new User();
        u.setId(id);

        int i = service.removeUser(u);

        PrintWriter out = resp.getWriter();
        ObjectMapper om = new ObjectMapper();
        out.print(i);
        out.close();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
