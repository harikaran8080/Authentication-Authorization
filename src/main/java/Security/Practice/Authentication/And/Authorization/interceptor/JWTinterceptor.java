package Security.Practice.Authentication.And.Authorization.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import Security.Practice.Authentication.And.Authorization.common.JWToken;
import Security.Practice.Authentication.And.Authorization.dto.RequestMeta;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTinterceptor implements HandlerInterceptor{
	
	@Autowired
	private JWToken jwToken;
	
	private RequestMeta meta;
	
	public JWTinterceptor(RequestMeta meta) {
		this.meta = meta;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String auth = request.getHeader("authorization");
		
		if (!(request.getRequestURI().contains("login")|| request.getRequestURI().contains("signup"))) {
			jwToken.verify(auth);
//			Claims claims = jwToken.verify(auth);
			
//			meta.setWorkerName(claims.get("Name").toString());
//			meta.setWorkerAge(claims.get("Age").toString());
//			meta.setGender(claims.get("gender").toString());
//			
			
		
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
