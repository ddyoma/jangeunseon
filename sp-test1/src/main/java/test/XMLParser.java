package test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(
					"http://api.kcisa.kr/openapi/service/rest/convergence2017/conver3?serviceKey=3de1bd2f-0c83-43e1-b53e-c8d3727684a7");
			Element root = d.getDocumentElement();
			NodeList nl = root.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {//두번돌게되는 첫포문
				Node n = nl.item(i);
				if(n.getNodeName().equals("body")) { //만약 body면 또한번하기 네번도는 두번째포문
					NodeList bodynl = n.getChildNodes();
					for(int j=0; j<bodynl.getLength();j++) {
						Node n2 = bodynl.item(j);
						NodeList itemnl = n2.getChildNodes();
						System.out.println(n2.getNodeName());
						for(int k =0; k<itemnl.getLength();k++) {//10번도는 포문
							Node n3 = itemnl.item(k);
							System.out.println(n3.getNodeName());
							System.out.println(n3.getTextContent());
						}
					
						
					}
				}
				System.out.println(n);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
