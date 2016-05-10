package com.vteba.bsh.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vteba.bsh.user.model.User;

/**
 * 用户Dao接口，使用Spring提供的Spring-Data-JPA实现。
 * 
 * @author iyinlei@126.com
 * @date 2016年5月10日 下午12:35:46
 */
public interface UserDao extends JpaRepository<User, String> {

}
