package yy.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件名：User.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月12日下午5:05:10
 */
public class User implements Serializable{
	private static final long serialVersionUID=-4313782718477229465L;
	
	private String id;
	private String userName;
	private String userPwd;
	private Date birthday;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

}
