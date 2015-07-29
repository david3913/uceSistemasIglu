package user2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class Handler extends SimpleUrlAuthenticationSuccessHandler {

	public Handler(String defaultUrl) {
		System.out.println("constructor");
		setDefaultTargetUrl(defaultUrl);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.AuthenticationSuccessHandler
	 * #onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		System.out.println(authentication.getCredentials());
		System.out.println(authentication.getDetails());
		System.out.println(authentication.getName());
		System.out.println(authentication.getPrincipal());
		System.out.println(authentication.getAuthorities());
		
		if (Util.isAjaxRequest(request)) {
			System.out.println("si es peticin ajax");
			System.out.println(authentication.isAuthenticated());
			if (authentication.isAuthenticated()) {
				System.out.println("success");
				Util.sendJsonResponse(response, "login_status", "success");
			} else {
				System.out.println("invalid");
				Util.sendJsonResponse(response, "login_status", "invalid");
			}

		} else {
			System.out.println("else");
			super.onAuthenticationSuccess(request, response, authentication);			
		}

	}
}