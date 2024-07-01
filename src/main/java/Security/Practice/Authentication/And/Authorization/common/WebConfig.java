package Security.Practice.Authentication.And.Authorization.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Security.Practice.Authentication.And.Authorization.dto.RequestMeta;
import Security.Practice.Authentication.And.Authorization.interceptor.JWTinterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private JWTinterceptor jwTinterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwTinterceptor);
	}
	
	@Bean
	@RequestScope
	public RequestMeta getRequestMeta() {
		return new RequestMeta();
	}
	
	@Bean
	public JWTinterceptor getJwTinterceptor() {
		return new JWTinterceptor( getRequestMeta());
	}

}
