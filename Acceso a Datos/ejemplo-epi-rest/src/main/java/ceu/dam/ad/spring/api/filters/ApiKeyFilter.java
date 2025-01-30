package ceu.dam.ad.spring.api.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class ApiKeyFilter extends OncePerRequestFilter {
	
	@Value("${quistian.key}")
	private String quistianKey;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String apiKey = request.getHeader("API-KEY");
		
		if(quistianKey.equals(apiKey)) {
			filterChain.doFilter(request, response);
		}else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getWriter().write("Quistian payaso de mierda");
		}
	}
	
}
