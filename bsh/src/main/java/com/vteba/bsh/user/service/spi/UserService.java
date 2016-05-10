package com.vteba.bsh.user.service.spi;

import java.util.List;

import com.vteba.bsh.user.model.User;

/**
 * 用户服务接口
 * 
 * @author iyinlei@126.com
 * @date 2016年5月10日 下午12:33:12
 */
public interface UserService {

	/**
	 * 根据id查询用户
	 * @param id 主键
	 * @return 用户实体
	 */
	public User get(String id);
	
	/**
	 * 保存用户
	 * @param user 待保存的用户
	 * @return true成功
	 */
	public boolean save(User user);
	
	/**
	 * 根据id删除用户
	 * @param id id
	 * @return true成功
	 */
	public boolean delete(String id);
	
	/**
	 * 根据id更新用户
	 * @param user 待更新的数据，含id
	 * @return true成功
	 */
	public boolean updateById(User user);
	
	/**
	 * 查询用户列表
	 * @param user 参数
	 * @return 用户list
	 */
	public List<User> queryForList(User user);
}
