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
 * �ļ�����XmlUtils.java
 * ������
 * ���ߣ�sz06025
 * ���ڣ�2018��4��13������9:52:30
 */
public class XmlUtils {
	private static File file = new File("D:/apache-tomcat-7.0.52/webapps/LoginExample/WEB-INF/classes/yy/DB.xml");  
    //  ͨ�����幤��API��ʹӦ�ó����XML�л������DOM�������Ľ�����  
    //  ͨ������API��ʹ���XML�ĵ��л��DOM�ĵ�ʵ����  
    //  ͨ��������õ�DOM�ĵ�ʵ����������������Դ��  
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
