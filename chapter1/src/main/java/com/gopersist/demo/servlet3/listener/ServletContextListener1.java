package com.gopersist.demo.servlet3.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
  * ServletContextListener通常用于为ServletContext容器初始化一些全局属性，并在应用关闭时做一些清理。
  *
  * 在Tomcat启动时，加载ServletContextListener的contextInitialized()会早于Filter和Servlet执行。
  * 而在关闭Tomcat时，contextDestroyed()会晚于Filter和Servlet执行。
 */
@WebListener
public class ServletContextListener1 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("[ServletContextListener1] contextInitialized()");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[ServletContextListener1] contextDestroyed()");
	}
}
