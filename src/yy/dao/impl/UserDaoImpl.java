package yy.dao.impl;

import java.text.AttributedString;
import java.text.SimpleDateFormat;

import javax.xml.crypto.dsig.XMLObject;





import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import yy.dao.UserDao;
import yy.domain.User;
import yy.util.XmlUtils;

/**
 * 文件名：UserDaoImpl.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月12日下午5:17:02
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User findUser(String userName, String userPwd) {
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element)selectSingleNode("/User/user[userName='" + userName + "' and userPwd='"+ userPwd + "']",document);
			if (e == null) {
				return null;
			}
			User user = new User();
			user.setId(e.getElementsByTagName("id").item(0).getTextContent());
			user.setUserName(e.getElementsByTagName("userName").item(0).getTextContent());
			user.setUserPwd(e.getElementsByTagName("userPwd").item(0).getTextContent());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(e.getElementsByTagName("birthday").item(0).getTextContent()));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void addUser(User user) {
		Element param=null;
		try {
			Document document = XmlUtils.getDocument();
			Element root = (Element) document.getElementsByTagName("User").item(0);
			Element rootuser = document.createElement("user");
			
			param=document.createElement("id");
			param.setTextContent(user.getId());
			rootuser.appendChild(param);
			
			param=document.createElement("userName");
			param.setTextContent(user.getUserName());
			rootuser.appendChild(param);
			
			param=document.createElement("userPwd");
			param.setTextContent(user.getUserPwd());
			rootuser.appendChild(param);
			
			param=document.createElement("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			param.setTextContent(sdf.format(user.getBirthday()));
			rootuser.appendChild(param);
			
			
			root.appendChild(rootuser);
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User findByName(String userName) {
		Document document;
		try {
			document = XmlUtils.getDocument();
			Element e = (Element)selectSingleNode("/User/user[userName='" + userName + "']",document.getDocumentElement());
			if (e == null) {
				return null;
			}
			User user = new User();
			user.setId(e.getElementsByTagName("id").item(0).getTextContent());
			user.setUserName(e.getElementsByTagName("userName").item(0).getTextContent());
			user.setUserPwd(e.getElementsByTagName("userPwd").item(0).getTextContent());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(e.getElementsByTagName("birthday").item(0).getTextContent()));
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public static Node selectSingleNode(String express, Object source) {//查找节点，并返回第一个符合条件节点
        Node result=null;
        XPathFactory xpathFactory=XPathFactory.newInstance();
        XPath xpath=xpathFactory.newXPath();
        try {
            result=(Node) xpath.evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
		return result;
	}
}
