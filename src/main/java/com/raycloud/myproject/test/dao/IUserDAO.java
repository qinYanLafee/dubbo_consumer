package com.raycloud.myproject.test.dao;

import com.raycloud.myproject.test.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 001117020012 on 2017/2/23.
 */
public interface IUserDAO {
    public User selectUsersByName(String name) throws SQLException;

    public List<User> selectUsersByPage(int page);

    public List<String> queryByName(int page, String name);

    public User queryById(int id);

    public int selectNumber();
}
