package com.vteba.bsh.user.action;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.bsh.user.model.User;
import com.vteba.bsh.user.service.spi.UserService;
import com.vteba.bsh.utils.ObjectId;

/**
 * 用户控制器
 * 
 * @author iyinlei@126.com
 * @date 2016年5月10日 下午12:32:17
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAction.class);

	// 这里建议使用接口定义
	@Autowired
	private UserService userServiceImpl;
	
	/**
	 * 跳转到用户列表
	 * @return 列表逻辑页
	 */
	@RequestMapping("/list")
	public String list(ModelMap model) {
		try {
			List<User> list = userServiceImpl.queryForList(null);
			model.put("list", list);
		} catch (Exception e) {
			LOGGER.error("查询用户列表错误", e.getMessage());
			return "error";
		}
		return "user/list";
	}
	
	/**
	 * 根据id查询用户
	 * @param id 主键
	 * @return 用户实体
	 */
	@RequestMapping("/detail")
	public String detail(String id, ModelMap model) {
		try {
			User user = userServiceImpl.get(id);
			model.put("model", user);
			return "user/detail";
		} catch (Exception e) {
			LOGGER.error("get user error=[{}]", e.getMessage());
			return "error";
		}
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	/**
	 * 执行实际的新增操作
	 * @param user 参数
	 * @return
	 */
	@RequestMapping("/doAdd")
	public String doAdd(User user) {
		try {
			user.setId(ObjectId.get().toString());
			user.setUpdateDate(new Date());
			userServiceImpl.save(user);
		} catch (Exception e) {
			LOGGER.error("[{}]", e.getMessage());
			return "error";
		}
		return "user/add";
	}
	
	/**
	 * 去修改用户
	 * @param id 用户id
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(String id, ModelMap model) {
		try {
			User user = userServiceImpl.get(id);
			model.put("model", user);
			return "user/edit";
		} catch (Exception e) {
			LOGGER.error("edit user error=[{}]", e.getMessage());
			return "error";
		}
	}
	
	/**
	 * 执行更新操作
	 * @param user 参数
	 * @return
	 */
	@RequestMapping("/update")
	public String update(User user) {
		try {
			if (user.getId() == null) {
				return "error";
			}
			user.setUpdateDate(new Date());
			userServiceImpl.updateById(user);
		} catch (Exception e) {
			LOGGER.error("[{}]", e.getMessage());
			return "error";
		}
		return "user/list";
	}
	
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return
	 */
	@ResponseBody // 返回json格式的数据
	@RequestMapping("/delete")
	public String delete(String id) {
		try {
			boolean result = userServiceImpl.delete(id);
			if (result) {
				return "success";
			}
		} catch (Exception e) {
			LOGGER.error("edit user error=[{}]", e.getMessage());
		}
		return "error";
	}
}
