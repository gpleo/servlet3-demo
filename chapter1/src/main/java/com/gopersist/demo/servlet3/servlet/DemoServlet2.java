package com.gopersist.demo.servlet3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name="demoServlet2", 
		urlPatterns={"/servlet3/servlet/demo2", "/servlet3/servlet/demo2/*"}, 
		loadOnStartup=2, 
		initParams={@WebInitParam(name="msg", value="Hello servlet 2!")}
		)
public class DemoServlet2 extends HttpServlet {
	private String msg;
	
	public DemoServlet2 () {
		System.out.println("[DemoServlet2] DemoServlet2()");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("[DemoServlet2] init()");
		msg = this.getInitParameter("msg");
	}
	
	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[DemoServlet2] doGet(): " + msg);
        resp.getWriter().append(msg).close();
    }
}
