package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.parser.JSONParser;

public class Naver extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri=req.getRequestURI().substring(req.getContextPath().length());
		
		System.out.println(uri);
		boolean flag= uri.equals("/naver");
		System.out.println(flag);
		if(flag) {
			System.out.println("tokengogo");
			String profile=naverGetToken(req);
			req.setAttribute("profile", profile);
			req.getRequestDispatcher("/api/naverProfile.jsp").forward(req, resp);
		}else if(uri.equals("/naver/login")){
			System.out.println("codegogo");
			req.setAttribute("apiURL",naverGetForm(req));
			req.getRequestDispatcher("/api/naverLogin.jsp").forward(req, resp);
		}
		
	}

	
	String naverGetForm(HttpServletRequest req) {
		
		String clientId = "eNb3znxejq9xlux_MBlK";
	    String redirectURI=null;
		try {
			redirectURI = URLEncoder.encode("http://125.143.189.154/QQQ/naver", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString();
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    req.getSession().setAttribute("state", state); 	
		return apiURL;
		

	
		
	}
	
	String naverGetToken(HttpServletRequest request) throws UnsupportedEncodingException {
			
			String clientId = "eNb3znxejq9xlux_MBlK";
		    String clientSecret = "XC2mb6FOZB";
		    String code = request.getParameter("code");
		    String state = request.getParameter("state");
		    String redirectURI = URLEncoder.encode("http://125.143.189.154/QQQ/naver", "UTF-8");
		    String apiURL;
		    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		    apiURL += "client_id=" + clientId;
		    apiURL += "&client_secret=" + clientSecret;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&code=" + code;
		    apiURL += "&state=" + state;
		    String access_token = "";
		    String refresh_token = "";
		    System.out.println("apiURL="+apiURL);
		    try {
		      URL url = new URL(apiURL);
		      HttpURLConnection con = (HttpURLConnection)url.openConnection();
		      con.setRequestMethod("GET");
		      int responseCode = con.getResponseCode();
		      BufferedReader br;
		      System.out.print("responseCode="+responseCode);
		      if(responseCode==200) { 
		        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		      } else {  
		        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		      }
		      String inputLine;
		      StringBuffer res = new StringBuffer();
		      while ((inputLine = br.readLine()) != null) {
		        res.append(inputLine);
		      }
		      br.close();
		      if(responseCode==200) {
		        System.out.println(res.toString());
		      }
		      
		      access_token=res.substring(res.indexOf("access_token\":\"")+"access_token\"\":".length(),res.indexOf("\","));
		    } catch (Exception e) {
		      System.out.println(e);
		    }
		    return  naverProfile(access_token);
		   
	}

	public String naverProfile(String token) {
		
        String header = "Bearer " + token;

        String apiURL = "https://openapi.naver.com/v1/nid/me";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);
        String responseBody = get(apiURL,requestHeaders)+"<br>token : "+token;
        System.out.println(responseBody);
        
        return responseBody;
	}
	
	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
        
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }
            
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
	
	

