package yy.util;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * �ļ�����WebUtils.java
 * ��������װ�ͻ����ύ�����ݵ�formBean��
 * ���ߣ�sz06025
 * ���ڣ�2018��4��13������11:13:08
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
