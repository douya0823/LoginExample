package yy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;




/**
 * 文件名：XmlUtils.java
 * 描述：
 * 作者：sz06025
 * 日期：2018年4月13日上午9:52:30
 */
public class XmlUtils {
	private static File file = new File("D:/apache-tomcat-7.0.52/webapps/LoginExample/WEB-INF/classes/yy/DB.xml");  
    //  通过定义工厂API，使应用程序从XML中获得生成DOM对象树的解析器  
    //  通过定义API，使其从XML文档中获得DOM文档实例。  
    //  通过上述获得的DOM文档实例，解析各种输入源。  
    public static Document getDocument() throws Exception{  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder = factory.newDocumentBuilder();  
        return  builder.parse((new FileInputStream(file)));  
        
          
    }  
    public static void write2Xml(Document document) throws Exception{  
        TransformerFactory factory = TransformerFactory.newInstance();  
        Transformer transformer = factory.newTransformer();  
        transformer.transform(new DOMSource((Node) document), new StreamResult(new FileOutputStream(file)));  
    } 

}
