package finalproj.mvc.controller.admin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaraminController {
   // using api
   @RequestMapping(value="/saramin")
   public String home(HttpServletRequest req, HttpServletResponse resp) {
      System.out.println("main_ex");
      String query = req.getParameter("query");
      String count = req.getParameter("count");    
      String start = req.getParameter("start");    
      
      try {
      String text = URLEncoder.encode(query, "EUC-KR");
      String apiURL = "http://api.saramin.co.kr/job-search?keywords="+text+"&start="+start+"&count="+count;
      URL url = new URL(apiURL);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      
      int responseCode = con.getResponseCode();    
      BufferedReader br;
      if(responseCode == 200) {
         br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
      }else {
         br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"UTF-8"));
      }
      String inputLine;
      StringBuffer response = new StringBuffer();
      while((inputLine = br.readLine())!=null) {
         response.append(inputLine);
      }
      br.close();
      JSONObject json = XML.toJSONObject(response.toString());
      
      resp.setHeader("Content-type", "application/json");
      resp.setCharacterEncoding("EUC-KR");
      
      resp.getWriter().println(json);
      resp.getWriter().close();
      
      }catch (Exception e) {
         System.out.println(e);
      }
      
      
      
      return "saramin";
   }
}