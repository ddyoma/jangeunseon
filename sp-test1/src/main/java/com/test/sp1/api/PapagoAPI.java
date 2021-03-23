package com.test.sp1.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
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

import com.test.sp1.entity.papago.PapagoParam;
import com.test.sp1.entity.papago.PapagoResult;


@Component
public class PapagoAPI {
	private static final Logger log = LoggerFactory.getLogger(PapagoAPI.class);
	private final static String API_URI = "https://openapi.naver.com/v1/papago/n2mt";
	private final static String ID_HEADER = "X-Naver-Client-Id"; //헤더네임
	private final static String CLIENT_ID = "dpW_ZvahlemnBMxEymod"; //값
	private final static String SECRET_HEADER = "X-Naver-Client-Secret"; //헤더네임
	private final static String CLIENT_SECRET = "y8gB3VvNvx"; //값

	@Autowired
	private ObjectMapper om;

	public PapagoResult getResult(PapagoParam pp) {
		String json = getSourceString(pp);
		PapagoResult result = null;
		try {
			result = om.readValue(json, PapagoResult.class);
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
	

		HttpURLConnection conn = null;
		try {
			URL url = new URL(API_URI);
			conn = (HttpURLConnection) url.openConnection();
			return conn;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSourceString(PapagoParam pp) {

		HttpURLConnection conn = null;
		try {
			conn = getHttpURLConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty(ID_HEADER, CLIENT_ID);
			conn.setRequestProperty(SECRET_HEADER, CLIENT_SECRET);
			conn.setDoOutput(true);

			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			String param="source=" + pp.getSource()
					+ "&target=" + pp.getTarget()
					+ "&text=" + pp.getText()
					+ "&honorific=" + pp.isHonorific();
			dos.write(param.getBytes("UTF-8"));
			dos.flush();
			dos.close();

			//int status = conn.getResponseCode();
			
			StringBuilder sb = new StringBuilder(); // 스트링을만드는애. 바디빌더처럼. 바디를 만드는거임. 속도가빠르다는 장점이있다.
			InputStreamReader isr = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String str;
			while ((str = br.readLine()) != null) { // 얼마나 들어올지도 모르는데 들어오는 스트링을 다 합쳐야할때 일반 스트링보다 스트링빌더를 쓰는게 훨낫다 이런식으로.
				sb.append(str);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return "";

	}
 public static void main(String[] args) {
	PapagoAPI ppa = new PapagoAPI();
	PapagoParam p = new PapagoParam();
	String s = ppa.getSourceString(p);
	log.debug("json=>{}",s);
}


}
