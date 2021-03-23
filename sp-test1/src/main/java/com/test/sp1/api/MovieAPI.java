package com.test.sp1.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.sp1.HomeController;
import com.test.sp1.entity.Result;
import com.test.sp1.entity.Result;
@Component
public class MovieAPI {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	private final static String API_URI = "http://api.kcisa.kr/openapi/service/rest/convergence2017/conver3";
	private final static String KEY_NAME = "serviceKey";
	private final static String SERVICE_KEY = "3de1bd2f-0c83-43e1-b53e-c8d3727684a7";

	@Autowired
	private ObjectMapper om;
	
	public Result getResult() {
		String json = getSourceString();
		Result result =null;
		try {
			 result = om.readValue(json, Result.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	public HttpURLConnection getHttpURLConnection() {
		String uri = API_URI + "?" + KEY_NAME + "=" + SERVICE_KEY;

		HttpURLConnection conn = null;
		try {
			URL url = new URL(uri);
			conn = (HttpURLConnection) url.openConnection();
			return conn;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSourceString() {

		HttpURLConnection conn = null;
		try {
			conn = getHttpURLConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "application/json;charset=UTF-8");
			conn.setDoOutput(true);
			
		//	int status = conn.getResponseCode();
			
			StringBuilder sb = new StringBuilder(); //스트링을만드는애.  바디빌더처럼. 바디를 만드는거임.  속도가빠르다는 장점이있다.
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);
				
			String str;
			while((str=br.readLine())!=null) { //얼마나 들어올지도 모르는데 들어오는 스트링을 다 합쳐야할때 일반 스트링보다 스트링빌더를 쓰는게 훨낫다 이런식으로.
				sb.append(str); 
			}return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.disconnect();
		}
		return "";

	}

	public static void main(String[] args) {
		MovieAPI mAPI = new MovieAPI();
		mAPI.om = new ObjectMapper();
		mAPI.getSourceString();
		
	String str = mAPI.getSourceString();
	System.out.println(str);
	
	Result result = mAPI.getResult();
	System.out.println(result);
	//servlet-context.xml을 읽어야 오토와이어드를 실행하쥬 ㅇ_ ㅇ
	//당근 이제 이건 안되지 ㅇㅅㅇ...
	//여기서 동작하게 할라면 저렇게 강제로 의존성을 코드로 주입해줘야지 ㅇ_ ㅇ
	}
}
