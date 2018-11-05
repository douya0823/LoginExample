package yy.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 文件名：WebUtils.java
 * 描述：封装客户端提交的数据到formBean中
 * 作者：sz06025
 * 日期：2018年4月13日上午11:13:08
 */
public class WebUtils {
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean = clazz.newInstance();
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String string = (String) e.nextElement();
				String value = request.getParameter(string);
				BeanUtils.setProperty(bean, string,value);
			}
			return bean;
		} catch (Exception e) {
			 throw new RuntimeException(e);
		}
		
	}
	
	public static String makeId(){
		return  UUID.randomUUID().toString();
	}
}
