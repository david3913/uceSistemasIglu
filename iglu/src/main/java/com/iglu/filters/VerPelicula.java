package com.iglu.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.iglu.security.SessionSpring;
import com.iglu.spring.model.Cuenta;
import com.iglu.spring.service.CuentaService;
import com.iglu.util.ApplicationContextProvider;

/**
 * Servlet Filter implementation class Secure
 */
@WebFilter("/data/movies/*")
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		CuentaService cuentaSuscripcionService = ApplicationContextProvider.getContext().getBean(CuentaService.class);
		boolean resp;
		try {
			 resp = cuentaSuscripcionService.suscripcionActiva();
			// System.out.println(resp);
		} catch (Exception ex) {
			resp=false;
		}
			String url = ((HttpServletRequest) request).getRequestURL().toString();

			if (url.contains("jpg")){
				chain.doFilter(request, response);
			//System.out.println("Recurso jpg");
			}
			else {
				if (url.contains("mp4") && resp){
					chain.doFilter(request, response);
				//	System.out.println("Recurso mp4");	
				}
				else
					res.sendRedirect(req.getContextPath() + "/data/mensajes/sinSuscripcion.mp4");
			}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
