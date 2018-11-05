package yy.dao;

import yy.domain.User;

/**
 * 文件名：UserDao.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月12日下午5:13:16
 */
public interface UserDao {
	
	User findUser(String userName,String userPwd);
	void addUser(User user);
	User findByName(String userName);

}
