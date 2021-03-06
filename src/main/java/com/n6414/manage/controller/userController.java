package com.n6414.manage.controller;

import com.n6414.manage.domain.User;
import com.n6414.manage.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import java.util.List;
import java.util.Objects;

@Slf4j
@RequestMapping("user")
@RestController
public class userController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("getAllUsers")
    public Object getAllUsers(HttpServletRequest request, HttpServletResponse response) {

        List<User> user = userMapper.selectAllUsers();
        JSONObject json = new JSONObject();
        System.out.println(user);
        json.put("user", user);
        return json;

    }


    @GetMapping("login")
    public Object login(HttpServletRequest request, HttpServletResponse response) {

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User user = userMapper.selectUser(userName);
        System.out.println(userName);
        JSONObject json = new JSONObject();
        if (user == null) {
            json.put("code", "1001");
            json.put("message", "登录失败");
            return json;
        }
        if (Objects.equals(passWord, user.getPassWord())) {
            json.put("code", "1000");
            json.put("message", "登录成功");
            json.put("id", user.getId());
            json.put("role", user.getRole());
            json.put("trueName", user.getTrueName());
            json.put("userName", user.getUserName());
            return json;
        }
        json.put("code", "1002");
        json.put("message", "登录失败,密码错误");
        return json;
    }

    @GetMapping("searchUser")
    public Object searchUser(HttpServletRequest request, HttpServletResponse response) {
        String trueName = request.getParameter("trueName");
        String userName = request.getParameter("userName");
        List resultCount = userMapper.searchUser(trueName, userName);
        System.out.println(resultCount);
        JSONObject json = new JSONObject();
        if (resultCount.isEmpty()) {
            json.put("code", "1000");
            json.put("message", "success");
            return json;
        } else {
            json.put("code", "1001");
            json.put("message", "faild");
            return json;
        }
    }

    @GetMapping("register")
    public Object register(HttpServletRequest request, HttpServletResponse response) {
        String trueName = request.getParameter("trueName");
        String nickName = request.getParameter("nickName");
        String address = request.getParameter("address");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        int resultCount = userMapper.saveUser(trueName, nickName, address, userName, passWord);
        JSONObject json = new JSONObject();
        if (resultCount == 0) {
            json.put("code", "1001");
            json.put("message", "注册失败");
            return json;
        }
        json.put("code", "1000");
        json.put("message", "注册成功");
        return json;
    }

}
