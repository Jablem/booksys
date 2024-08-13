package ums_servlet_01.service;

import ums_servlet_01.dao.UserDaoImpl;
import ums_servlet_01.po.User;
import ums_servlet_01.dao.UserDao;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao dao = new UserDaoImpl();
    @Override
    public List<User> selectAll(User u) {
        return dao.selectAll(u);
    }

    @Override
    public User selectById(User u) {
        return null;
    }

    @Override
    public User selectByNameAndPass(User u) {
        return dao.selectByNameAndPass(u);
    }

    @Override
    public int removeUser(User u) {
        return dao.removeUser(u);
    }

    @Override
    public int addUser(User u) {
        return dao.addUser(u);
    }

    @Override
    public int updateUser(User u) {
        return dao.updateUser(u);
    }
}
