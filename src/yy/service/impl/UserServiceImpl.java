package yy.service.impl;

import yy.dao.UserDao;
import yy.dao.impl.UserDaoImpl;
import yy.domain.User;
import yy.service.UserService;
import yy.web.exception.UserException;

/**
 * �ļ�����UserServiceImpl.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��4��13������10:32:59
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public void registerUser(User user) {

		if (userDao.findByName(user.getUserName()) != null) {
			throw new UserException("�û����ѱ�ע��");
		} else {

			userDao.addUser(user);
		}

	}

	@Override
	public User loginUser(String userName, String userPwd) {

		return userDao.findUser(userName, userPwd);
	}

}
