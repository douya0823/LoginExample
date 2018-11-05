package yy.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * �ļ�����RegisterFormBean.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��4��13������10:57:03
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
			errors.put("userName", "�û�������Ϊ��");
		}else{
			if((!this.userName.matches("[a-zA-Z]{3,8}"))){
				isOk=false;
				errors.put("userName", "�û���������3-8λ��ĸ");
			}
		}
		
		if(this.userPwd==null||"".equals(this.userPwd)){
			isOk=false;
			errors.put("userPwd", "���벻��Ϊ��");
		}else{
			if((!this.userPwd.matches("\\d{6,8}"))){
				isOk=false;
				errors.put("userPwd", "���������6-8λ����");
			}
		}
		
		if(this.confirmPwd!=null){
			if(!this.confirmPwd.equals(this.userPwd)){
				isOk=false;
				errors.put("confirmPwd", "�������벻һ��");
			}
		}else{
			isOk=false;
			errors.put("confirmPwd", "ȷ�����벻��Ϊ��");
		}
		
		if(this.birthday==null||"".equals(this.birthday)){
			isOk=false;
			errors.put("birthday", "���ղ���Ϊ��");
		}
		
		return isOk;
	}
}
