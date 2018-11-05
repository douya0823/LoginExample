package yy.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：RegisterFormBean.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月13日上午10:57:03
 */
public class RegisterFormBean {

	private String userName;
	private String userPwd;
	private String confirmPwd;
	private String birthday;


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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getconfirmPwd() {
		return confirmPwd;
	}
	public void setconfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	private Map<String, String> errors = new HashMap<>();
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
	public boolean validate(){
		boolean isOk=true;
		if(this.userName==null||"".equals(this.userPwd)){
			isOk=false;
			errors.put("userName", "用户名不能为空");
		}else{
			if((!this.userName.matches("[a-zA-Z]{3,8}"))){
				isOk=false;
				errors.put("userName", "用户名必须是3-8位字母");
			}
		}
		
		if(this.userPwd==null||"".equals(this.userPwd)){
			isOk=false;
			errors.put("userPwd", "密码不能为空");
		}else{
			if((!this.userPwd.matches("\\d{6,8}"))){
				isOk=false;
				errors.put("userPwd", "密码必须是6-8位数字");
			}
		}
		
		if(this.confirmPwd!=null){
			if(!this.confirmPwd.equals(this.userPwd)){
				isOk=false;
				errors.put("confirmPwd", "两次密码不一致");
			}
		}else{
			isOk=false;
			errors.put("confirmPwd", "确认密码不能为空");
		}
		
		if(this.birthday==null||"".equals(this.birthday)){
			isOk=false;
			errors.put("birthday", "生日不能为空");
		}
		
		return isOk;
	}
}
