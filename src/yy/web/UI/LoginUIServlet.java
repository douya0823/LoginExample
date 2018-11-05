package yy.web.UI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件名：LoginUIServlet.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月13日下午3:47:37
 */
public class LoginUIServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}



}
