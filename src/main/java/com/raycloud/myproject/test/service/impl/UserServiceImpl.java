package com.raycloud.myproject.test.service.impl;


import com.raycloud.myproject.test.dao.IUserDAO;
import com.raycloud.myproject.test.entity.User;
import com.raycloud.myproject.test.exception.NameOrPasswordException;
import com.raycloud.myproject.test.exception.UserNotExistException;
import com.raycloud.myproject.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 001117020012 on 2017/2/17.
 */
@Service("UserService")
public class UserServiceImpl  implements IUserService {
    @Autowired
    private IUserDAO iUserDAO;
    @Autowired
    private IUserDAO userDAO;

    @Override
    public int surePage(int page) {
        int totleNum=iUserDAO.selectNumber();
        int surePage=0;
        if(page<=0){
            page=totleNum;
        }else if(page>totleNum){
            page=1;
        }
        return page;

    }

    @Override
    public void login(String username, String password) throws UserNotExistException, NameOrPasswordException, IOException, SQLException {
        User user = iUserDAO.selectUsersByName(username);
        if(user == null){
            throw new UserNotExistException("用户不存在");
        }
        if(!password.equals(user.getPassword())){
            throw new NameOrPasswordException("用户名或密码错误！");
        }

    }
    public List<User> getPage(int page){
        int totleNum=iUserDAO.selectNumber();
        if(page<=0){
            page=totleNum;
        }else if(page>totleNum){
            page=1;
        }
        List<User> list = iUserDAO.selectUsersByPage(page);
        return list;
    }

    @Override
    public int totlePage() {
       int totlePage=iUserDAO.selectNumber();
       return totlePage;
    }

    @Override
    public List<String> queryAddress(int page,String name) throws IOException {
        List<String> list = userDAO.queryByName(page,name);
        return list;
    }

    public IUserDAO getiUserDAO() {
        return iUserDAO;
    }

    public void setiUserDAO(IUserDAO iUserDAO) {
        this.iUserDAO = iUserDAO;
    }
}
