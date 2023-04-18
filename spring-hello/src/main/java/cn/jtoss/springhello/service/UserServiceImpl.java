package cn.jtoss.springhello.service;

import cn.jtoss.springhello.dao.UserDaoImpl;
import cn.jtoss.springhello.entity.User;

import java.util.List;

/**
 * @author jason
 */
public class UserServiceImpl {
    private UserDaoImpl userDao;

    public UserServiceImpl() {
    }

    public List<User> findUserList() {
        return this.userDao.findUserList();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
