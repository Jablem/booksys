package ums_servlet_01.service;

import ums_servlet_01.po.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll(User u);
    public User selectById(User u);
    public User selectByNameAndPass(User u);
    public int removeUser(User u);
    public int addUser(User u);
    public int updateUser(User u);
}
