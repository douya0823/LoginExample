package yy.dao;

import yy.domain.User;

/**
 * �ļ�����UserDao.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��4��12������5:13:16
 */
public interface UserDao {
	
	User findUser(String userName,String userPwd);
	void addUser(User user);
	User findByName(String userName);

}
