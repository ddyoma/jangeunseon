package test;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.*;
import org.json.*;

import com.test.sp1.test2.*;

public class XMLConvertor2 {

	public static void main(String[] args) {
		String xml = "<testXML>\r\n"
				+ "		   <tests>\r\n"
				+ "		      <rows>\r\n"
				+ "		         <row>\r\n"
				+ "		            <name>hahah</name>\r\n"
				+ "		            <age>22</age>\r\n"
				+ "		         </row>\r\n"
				+ "		         <row>\r\n"
				+ "		            <name>kim</name>\r\n"
				+ "		            <age>32</age>\r\n"
				+ "		         </row>\r\n"
				+ "		         <row>\r\n"
				+ "		            <name>lee</name>\r\n"
				+ "		            <age>42</age>\r\n"
				+ "		         </row>\r\n"
				+ "		      </rows>\r\n"
				+ "		   </tests>\r\n"
				+ "		   <testTitle>Title</testTitle>\r\n"
				+ "		   <testSubTitle>subTitle</testSubTitle>\r\n"
				+ "		</testXML>";
		JSONObject jo = XML.toJSONObject(xml);
		ObjectMapper om = new ObjectMapper();
		System.out.println(jo.toString());
		try {

			Menu menu = om.readValue(jo.toString(), Menu.class);
			Rows rows = menu.getTestXML().getTests().getRows();
			List<Row> row = rows.getRow();
			for (Row r : row) {
				System.out.println("이름:" + r.getName());
				System.out.println("나이:" + r.getAge());
			}

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
