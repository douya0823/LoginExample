package yy.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.w3c.dom.Element;

import yy.domain.User;
import yy.service.UserService;
import yy.service.impl.UserServiceImpl;
import yy.util.WebUtils;
import yy.web.exception.UserException;
import yy.web.formbean.RegisterFormBean;

/**
 * �ļ�����RegisterServlet.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��4��13������10:50:28
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterFormBean formBean = WebUtils.request2Bean(request, RegisterFormBean.class);
		if (formBean.validate() == false) {
			request.setAttribute("formBean", formBean);
			request.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formBean);
			user.setId(WebUtils.makeId());
			UserService userService = new UserServiceImpl();
			userService.registerUser(user);
			String message = String.format("ע��ɹ���3�����ת����½���棡<meta http-equiv='refresh' content='3;url=%s'/",
					request.getContextPath() + "/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
		} catch (UserException userException) {
			userException.printStackTrace();
			request.setAttribute("message", userException.getMessage());
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "�Բ���ע��ʧ�ܣ���");
			request.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(request, response);

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
