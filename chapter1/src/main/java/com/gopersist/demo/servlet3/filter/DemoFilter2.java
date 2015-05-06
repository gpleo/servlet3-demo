package com.gopersist.demo.servlet3.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(
		filterName="demoFilter2", 
		urlPatterns={"/servlet3/servlet/demo1", "/servlet3/servlet/demo1/*"}, 
		dispatcherTypes={DispatcherType.REQUEST})
public class DemoFilter2 implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("[DemoFilter2] init()");
	}

	@Override
	public void destroy() {
		System.out.println("[DemoFilter2] destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("[DemoFilter2] doFilter()");
		chain.doFilter(request, response);
	}
}
