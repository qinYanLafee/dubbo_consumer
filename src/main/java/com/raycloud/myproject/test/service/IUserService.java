package com.raycloud.myproject.test.service;

import com.raycloud.myproject.test.entity.User;
import com.raycloud.myproject.test.exception.NameOrPasswordException;
import com.raycloud.myproject.test.exception.UserNotExistException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 001117020012 on 2017/2/17.
 */
public interface IUserService {
    //登陆的方法
    public void login(String username, String password)
            throws UserNotExistException, NameOrPasswordException, IOException, SQLException;

    public List<String> queryAddress(int page, String name) throws IOException;

    public List<User> getPage(int page);
    public int  totlePage();
    public int  surePage(int page);

}
