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

/**
 * Filter在Tomcat启动时加载顺序优于Servlet，也就是在加载Servlet前，所有Filter的init()都被执行了。
 * 但多个Filter之间的加载顺序不确定。
 * 
 * 在页面访问时，对符合urlPatterns的地址会执行相应Filter的doFilter()，但是哪个Filter会先执行不确定。
 */
@WebFilter(
		filterName="demoFilter1", 
		urlPatterns="/*", 
		dispatcherTypes={DispatcherType.REQUEST})
public class DemoFilter1 implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("[DemoFilter1] init()");
	}

	@Override
	public void destroy() {
		System.out.println("[DemoFilter1] destroy()");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("[DemoFilter1] doFilter()");
		chain.doFilter(request, response);
	}
}
