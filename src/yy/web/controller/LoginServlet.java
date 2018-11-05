package yy.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yy.domain.User;
import yy.service.UserService;
import yy.service.impl.UserServiceImpl;

/**
 * 文件名：LoginServlet.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月13日下午5:39:46
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName=request.getParameter("userName");
			String userPwd=request.getParameter("userPwd");
			UserService userService = new UserServiceImpl();
			User user=userService.loginUser(userName, userPwd);
			if(user==null){
				String message=String.format("用户名或密码错误，2秒后跳转到登陆页面<meta http-equiv='refresh' content='2;url=%s'", request.getContextPath()+"/loginUIServlet");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
			}else{
				String message=String.format("登陆成功，2秒后跳转到首页<meta http-equiv='refresh' content='2;url=%s'", request.getContextPath()+"/IndexUIServlet");
				request.setAttribute("message", message);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
			}

	}


		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}



}
