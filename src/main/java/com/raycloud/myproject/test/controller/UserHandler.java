package com.raycloud.myproject.test.controller;

import com.raycloud.myproject.test.controller.request.PageRequest;
import com.raycloud.myproject.test.controller.response.Response;
import com.raycloud.myproject.test.controller.response.returnPage;
import com.raycloud.myproject.test.entity.User;
import com.raycloud.myproject.test.exception.NameOrPasswordException;
import com.raycloud.myproject.test.exception.UserNotExistException;
import com.raycloud.myproject.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by 001117020012 on 2017/2/17.
 */
@SessionAttributes(value={"users"})
@Controller
public class UserHandler {
    @Autowired
    @Qualifier("UserService")
    private IUserService service;

    /**
     * REST风格
     * @param name
     * @param password
     * @throws NameOrPasswordException  login
     * @throws com.raycloud.myproject.test.exception.UserNotExistException   login
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public  String login(@RequestParam("name") String name,
                              @RequestParam("password") String password  ,Map<String,Object> map)
            throws NameOrPasswordException, UserNotExistException, IOException, SQLException {
        service.login(name,password);
         return "users";
    }
  /*  @RequestMapping(value="/getPage/{pageNum}",method= RequestMethod.GET)
    public String getPage(@PathVariable int pageNum,Map<String,Object> map) {
        System.out.println(pageNum);
        List<User> users = service.getPage(pageNum);
        int totlePage=service.totlePage();
        map.put("totlePage",totlePage);
        map.put("users",users);
        map.put("pageNum",pageNum);
        return "users";
    }
*/
    @RequestMapping(value="/getPage/{pageNum}",method= RequestMethod.GET)
    public ModelAndView getPage(PageRequest pageRequest) {
        int pageNum=pageRequest.getPageNum();
        pageNum=service.surePage(pageNum);
        int totlePage=service.totlePage();
        List<User> user = service.getPage(pageNum);
        returnPage page=new returnPage();
        ModelAndView modelAndview=new ModelAndView("users");
        Response res=new Response();
        page.setListUser(user);
        page.setPageNum(pageNum);
        page.setTotlePage(totlePage);
        res.setData(page);
        modelAndview.addObject("res",res);
        return modelAndview;
    }

   @RequestMapping(value="/getPage1",method= RequestMethod.POST)
    public ModelAndView getPage1 (@RequestParam(value="pageNum",required=false,defaultValue="0")int pageNum) {
       int totlePage=service.totlePage();
       pageNum=service.surePage(pageNum);
       List<User> user = service.getPage(pageNum);
       returnPage page=new returnPage();
       ModelAndView modelAndview=new ModelAndView("users");
       Response res=new Response();
       page.setListUser(user);
       page.setPageNum(pageNum);
       page.setTotlePage(totlePage);
       res.setData(page);
       modelAndview.addObject("res",res);
       return modelAndview;
    }


}
