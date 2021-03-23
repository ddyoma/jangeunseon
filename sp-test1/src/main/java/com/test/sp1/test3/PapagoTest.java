package com.test.sp1.test3;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import lombok.Data;

@Data
class Result{
	private String srcLangType;
	private String tarLangType;
	private String translatedText;
	private String engineType;
	private String pivot;

}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)  //나한테 없는거는 패스하겠다는것
class Message{
	private Result result;
}

@Data
class PapagoResult{
	private Message message;
}

//gson의 fromjson이랑 똑같은 objectmapper
public class PapagoTest {
public static void main(String[] args) {
	String json = "{\r\n"
			+ "\"message\": {\r\n"
			+ "\"@type\": \"response\",\r\n"
			+ "\"@service\": \"naverservice.nmt.proxy\",\r\n"
			+ "\"@version\": \"1.0.0\",\r\n"
			+ "\"result\": {\r\n"
			+ "\"srcLangType\": \"ko\",\r\n"
			+ "\"tarLangType\": \"id\",\r\n"
			+ "\"translatedText\": \"Hai\",\r\n"
			+ "\"engineType\": \"PRETRANS\",\r\n"
			+ "\"pivot\": null\r\n"
			+ "}\r\n"
			+ "}\r\n"
			+ "}";
	
	//골뱅이없애는  1번째 방법, json=json.replace("\"@type\":","\"type\":");
	ObjectMapper om =new ObjectMapper();
	try {
		PapagoResult ppr = om.readValue(json, PapagoResult.class);
	} catch (JsonParseException e) {
		e.printStackTrace();
	} catch (JsonMappingException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	System.out.println(json);
}
}
