package com.jp.katesystem.repository;

import com.jp.katesystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByName(String name); //通过用户名name查找用户，注意要按照JPA的格式使用驼峰命名法
    User findByNameAndPassword(String name, String password);//通过用户名name和密码查找用户
}
