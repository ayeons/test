package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Kakao extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI().substring(req.getContextPath().length());
		
		System.out.println(uri);
		boolean flag= uri.equals("/kakao");
		System.out.println(flag);
		String token=null;
		if(flag) {
			System.out.println("tokengogo");
			token=getToken(req);
			String userInfo=profile(token);
			req.setAttribute("userInfo", userInfo);
			req.getRequestDispatcher("/api/kakaoProfile.jsp").forward(req, resp);
		}else if(uri.equals("/kakao/login")) {
			
			req.setAttribute("formURI", kakaoGetFormURI());
			req.getRequestDispatcher("/api/kakaoLogin.jsp").forward(req, resp);
		}
		
	}
	
	String getToken(HttpServletRequest req) throws IOException {
	 	final String AUTH_HOST = "https://kauth.kakao.com";
	    final String tokenRequestUrl = AUTH_HOST + "/oauth/token";

	    String CLIENT_ID = "f2538254544258956b3b002814d6172e"; 
	    String REDIRECT_URI = "http://125.143.189.154/QQQ/kakao"; 
	    String code = req.getParameter("code");

	    
	    HttpsURLConnection conn = null;
	    OutputStreamWriter writer = null;
	    BufferedReader reader = null;
	    InputStreamReader isr= null;
	    StringBuffer buffer = null;
	    try {
			  final String params = String.format("grant_type=authorization_code&client_id=%s&redirect_uri=%s&code=%s",
			                CLIENT_ID, REDIRECT_URI, code);
			  
			  final URL url = new URL(tokenRequestUrl);
			  conn = (HttpsURLConnection) url.openConnection();
			  conn.setRequestMethod("POST");
			  conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
			  conn.setDoOutput(true);
			      
			     
			  writer = new OutputStreamWriter(conn.getOutputStream());
		      writer.write(params);
		      writer.flush();
			   
		      final int responseCode = conn.getResponseCode();
		      System.out.println("\nSending 'POST' request to URL : " + tokenRequestUrl);
			  System.out.println("Post parameters : " + params);
		      System.out.println("Response Code : " + responseCode);
		     

		      isr = new InputStreamReader(conn.getInputStream());
		      reader = new BufferedReader(isr);
		      buffer = new StringBuffer();
		      String line;
		      while ((line = reader.readLine()) != null) {
		    	  buffer.append(line);
		    }
		     
		      System.out.println(buffer.toString());
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    } finally {
		        // clear resources
		        if (writer != null) {
		          try {
		              writer.close();
		           } catch(Exception ignore) {
		           }
		        }
		        if (reader != null) {
		          try {
		              reader.close();
		          } catch(Exception ignore) {
		          }
		        }
		        if (isr != null) {
		            try {
		                isr.close();
		            } catch(Exception ignore) {
		            }
		         }
		    }
	    return buffer.toString();


	}
	
	String profile(String token) throws IOException {
		final String HOST="https://kapi.kakao.com/v2/user/me";
		final String AUTHName="Bearer";
		
		//String params="property_keys=[\"kakao_account.email\"]";
		String tokenS=token.substring(17,token.length());
		String tokenResult=tokenS.substring(0,tokenS.indexOf("\""));
		
		URL url=new URL(HOST);
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		con.setRequestProperty("Authorization",AUTHName+" "+tokenResult);
		
	    System.out.println("request to URL : " +url);
	    //System.out.println("Post parameters : " + params);
	    System.out.println("Response Code : " + con.getResponseCode());
	    BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String line=null;
	    JSONParser Jparser=new JSONParser();
	    String Jtoken=null;
	    try {
	    	JSONObject JObject=(JSONObject) Jparser.parse(token);
	    	Jtoken=(String) JObject.get("access_token");
	    } catch (ParseException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    StringBuilder builder=new StringBuilder("token : "+Jtoken+"<br>");
	    
		while((line=br.readLine())!=null) {
			builder.append(line);
		}
		
		
		System.out.println(builder);
		return builder.toString();
	}
	
	String kakaoGetFormURI() {
		final String APP_KEY="f2538254544258956b3b002814d6172e";
		final String REDIRECT_URI="http://125.143.189.154/QQQ/kakao";
		final String URI="/oauth/authorize";
		final String loginFormByIDAndPassWord=String.format(
				"https://kauth.kakao.com%s?client_id=%s&redirect_uri=%s&response_type=code"
				,URI,APP_KEY,REDIRECT_URI);
		return loginFormByIDAndPassWord;
		
		
	}
}


