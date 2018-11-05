package yy.service.impl;

import yy.dao.UserDao;
import yy.dao.impl.UserDaoImpl;
import yy.domain.User;
import yy.service.UserService;
import yy.web.exception.UserException;

/**
 * 文件名：UserServiceImpl.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月13日上午10:32:59
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public void registerUser(User user) {

		if (userDao.findByName(user.getUserName()) != null) {
			throw new UserException("用户名已被注册");
		} else {

			userDao.addUser(user);
		}

	}

	@Override
	public User loginUser(String userName, String userPwd) {

		return userDao.findUser(userName, userPwd);
	}

}
