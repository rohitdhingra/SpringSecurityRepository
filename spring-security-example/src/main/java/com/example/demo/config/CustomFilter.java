package com.example.demo.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CustomFilter implements Filter{

	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init::called");
		Filter.super.init(filterConfig);
	}

	@Override
	public void destroy() {
		System.out.println("Destroy::called");
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter::called");
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		Principal userPrincipal = request.getUserPrincipal();
		System.out.println("User Principal"+userPrincipal);
		chain.doFilter(servletRequest, response);
		
	}

}
