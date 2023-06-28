package com.example.forumbackend.service.serviceImp;

import com.example.forumbackend.domain.User;
import com.example.forumbackend.mapper.UserDao;
import com.example.forumbackend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user != null) user.setPassword("");
        return user;
    }

    @Override
    public User registerService(User user) {
        if (userDao.findByUsername(user.getUsername()) != null) {
            //存在该用户
            return null;
        } else {
            userDao.addUser(user);
            System.out.println(user);
            if (user != null) user.setPassword("");
            return user;
        }
    }
}
