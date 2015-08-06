package com.iglu.filters;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.iglu.managedController.InfoManagedBean;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.service.CuentaSuscripcionService;
import com.iglu.util.ApplicationContextProvider;



/**
 * Servlet Filter implementation class Secure
 */
@WebFilter("*.mp4")
public class VerPelicula implements Filter {


	
	
	
	/**
	 * Default constructor.
	 */
	public VerPelicula() {
		
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	System.out.println("filter destory");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// System.out.println("FILTRO");
	

//		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP// 1.1.
//		res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//		res.setDateHeader("Expires", 0); // Proxies.
	
		//SessionService s =  ApplicationContextProvider.getContext().getBean(SessionService.class);
		//s.ingo();
		 HttpServletRequest req = (HttpServletRequest) request;
	        
		Cookie[] cookies = req.getCookies();
        if (cookies != null){
          for (Cookie ck : cookies) {
           System.out.println(ck.getName());
           System.out.println(ck.getValue());
        }
		
        }
        
       

//		if (beanLogin == null || !beanLogin.isLoggedIn()) {
			// String contextPath =
			// ((HttpServletRequest)request).getContextPath();

		//	res.sendRedirect(req.getContextPath() + "/403.html");
			//System.out.println("No login");
		//	System.out.println(req.getRequestURL());
			// ((HttpServletResponse)response).sendRedirect(contextPath +
			// "/login.xhtml");
//		} else {
			chain.doFilter(request, response);
//			//System.out.println("Si login");
//		//	System.out.println(req.getRequestURL());
//		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	WebApplicationContext springContext ;
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	 springContext = 
		        WebApplicationContextUtils.getWebApplicationContext(fConfig.getServletContext());
		
	
	}

	

}
