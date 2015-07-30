package com.iglu.security;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.web.util.ELRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.google.gson.Gson;
   
/** 
 * Utilities related to server requests and responses
 * 
 * @author bchild
 *
 */
@SuppressWarnings("deprecation")
public class Util {
 
  private static final Logger LOGGER = Logger.getLogger(Util.class.getName());
	
	private static final RequestMatcher REQUEST_MATCHER = new ELRequestMatcher("hasHeader('X-Requested-With','XMLHttpRequest')");
	
	public static final String JSON_VALUE = "{\"%s\": %s}";
	
	
	public static Boolean isAjaxRequest(HttpServletRequest request) {
		
		return REQUEST_MATCHER.matches(request);
	}
	
	public static void sendJsonResponse(HttpServletResponse response, String key, String message) {
		System.out.println("SenResponse");
		response.setContentType("application/json;charset=UTF-8");           
        response.setHeader("Cache-Control", "no-cache");
        try {
        	Map<String, Object> data = new HashMap<String, Object>();
        
			//response.getWriter().write(String.format(JSON_VALUE, key, message));
			data.put(key, message);
			data.put("url", "/");
			response.getWriter().write(new Gson().toJson(data));
			//response.getWriter().write(String.format(JSON_VALUE, "url", "/pruebaUrl"));
		} catch (IOException e) {
			LOGGER.error("error writing json to response", e);
		}
	}
 
} 



