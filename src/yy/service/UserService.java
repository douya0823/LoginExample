package yy.service;

import yy.domain.User;

/**
 * 文件名：UserService.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月13日上午10:31:28
 */
public interface UserService {
	
	void registerUser(User user);
	User loginUser(String userName,String userPwd);

}
