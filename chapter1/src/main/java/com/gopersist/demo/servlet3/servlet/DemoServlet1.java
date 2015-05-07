package com.gopersist.demo.servlet3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 按照loadOnStartup的设定，Tomcat在启动时，会先加载数字小的Servlet，
 * 如果loadOnStartup没有设定，会在访问Servlet时才加载这个Servlet，
 * 加载时，先实例化，再执行init()
 */
@WebServlet(
		name="demoServlet1", 
		urlPatterns={"/servlet3/servlet/demo1", "/servlet3/servlet/demo1/*"}, 
		loadOnStartup=1, 
		initParams={@WebInitParam(name="msg", value="Hello servlet 1!")}
		)
public class DemoServlet1 extends HttpServlet {
	private String msg;
	
	public DemoServlet1 () {
		System.out.println("[DemoServlet1] DemoServlet1()");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("[DemoServlet1] init()");
		msg = this.getInitParameter("msg");
	}
	
	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[DemoServlet1] doGet(): " + msg);
        resp.getWriter().append(msg).close();
    }
}
