package yy.service;

import yy.domain.User;

/**
 * �ļ�����UserService.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��4��13������10:31:28
 */
public interface UserService {
	
	void registerUser(User user);
	User loginUser(String userName,String userPwd);

}
