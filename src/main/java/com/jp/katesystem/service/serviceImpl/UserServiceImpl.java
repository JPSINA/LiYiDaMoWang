package com.jp.katesystem.service.serviceImpl;

import com.jp.katesystem.domain.User;
import com.jp.katesystem.repository.UserDao;
import com.jp.katesystem.service.UserService;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String name, String password) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userDao.findByNameAndPassword(name, password);
        // 重要信息置空
        if(user != null){
            user.setPassword("");
        }
        return user;
    }


    @Override
    public User registService(User user) {
        //当新用户的用户名已存在时
        if(userDao.findByName(user.getName())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }

}
