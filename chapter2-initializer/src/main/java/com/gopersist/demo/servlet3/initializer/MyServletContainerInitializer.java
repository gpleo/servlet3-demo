package com.gopersist.demo.servlet3.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * ServletContainerInitializer用于在启动时为Web应用动态添加功能，如动态添加Servlet。
 * 
 * 要使MyServletContainerInitializer正常工作，必须在META-INF/services下添加文件 javax.servlet.ServletContainerInitializer
 * 并设值com.gopersist.demo.servlet3.initializer.MyServletContainerInitializer
 * 
 * 在Tomcat启动时，ServletContainerInitializer将比ServletContextListener更早执行，onStartup()最早被调用。
 */
public class MyServletContainerInitializer implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> classSet, ServletContext ctx) throws ServletException {
		System.out.println("[MyServletContainerInitializer] onStartup()");
		
		ServletRegistration reg = ctx.addServlet("demoServletForInitializer", "com.gopersist.demo.servlet3.initializer.DemoServletForInitializer");
		reg.setInitParameter("msg", "Hello my servlet in ServletContainerInitializer !");
		reg.addMapping("/servlet3/initializer/servlet", "/servlet3/initializer/servlet/*");
	}
}
