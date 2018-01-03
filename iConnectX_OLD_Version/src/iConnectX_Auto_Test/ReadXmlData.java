package iConnectX_Auto_Test;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class ReadXmlData {	
	static String NodeValue;
	static String xmlFileName;
	
	public static String FetchXmlValue(String SearchNodeString) {			
		try {
			
			File file = new File(xmlFileName); 
			DocumentBuilderFactory docBldFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBlder = docBldFactory.newDocumentBuilder();
			Document doc = docBlder.parse(file);
			doc.getDocumentElement().normalize();
			
			NodeList UserId = doc.getElementsByTagName(SearchNodeString);
			Element UserIdElement = (Element) UserId.item(0);			
			NodeList textUserIdList = UserIdElement.getChildNodes();			
			NodeValue = ((Node) textUserIdList.item(0)).getNodeValue().trim();
			
		}catch (Exception e){
			System.out.println("Exception occurred");
		}
		return NodeValue;
	}


}
