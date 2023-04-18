package cn.jtoss.springhello.dao;

import cn.jtoss.springhello.entity.User;

import java.util.Collections;
import java.util.List;

/**
 * @author jason
 */
public class UserDaoImpl {
    public UserDaoImpl() {
    }

    public List<User> findUserList() {
        return Collections.singletonList(new User("jason", 18));
    }
}
