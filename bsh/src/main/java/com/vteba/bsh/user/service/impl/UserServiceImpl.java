package com.vteba.bsh.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vteba.bsh.user.dao.UserDao;
import com.vteba.bsh.user.model.User;
import com.vteba.bsh.user.service.spi.UserService;

/**
 * 用户接口服务实现
 * 
 * @author iyinlei@126.com
 * @date 2016年5月10日 下午12:33:50
 */
//spring默认的Bean命名规则是首字母小写，即userServiceImpl
@Service
// 开启事务，对运行时异常进行回滚
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	// 注入UserDao
	@Autowired
	private UserDao userDao;
	
	public User get(String id) {
		return userDao.findOne(id);
	}

	@Override
	public boolean save(User user) {
		try {
			userDao.save(user);
		} catch (Exception e) {
			LOGGER.error("保存用户错误。error=[{}].", e.getMessage());
			throw new RuntimeException("保存用户错误。", e);
		}
		return true;
	}

	@Override
	public boolean delete(String id) {
		try {
			userDao.delete(id);
			return true;
		} catch (Exception e) {
			// 都应该捕获异常，记录日志，抛出该层对应的异常（简单起见，这里直接抛运行时了），这是异常一般的处理方式。
			LOGGER.error("删除用户错误。error=[{}].", e.getMessage());
			throw new RuntimeException("删除用户错误。", e);
		}
	}

	@Override
	public boolean updateById(User user) {
		try {
			userDao.save(user);
			return true;
		} catch (Exception e) {
			LOGGER.error("修改用户错误。error=[{}].", e.getMessage());
			throw new RuntimeException("修改用户错误。", e);
		}
	}
	
	public List<User> queryForList(User user) {
		return userDao.findAll();
	}
}
