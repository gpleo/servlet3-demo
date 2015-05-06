package com.gopersist.demo.servlet3.initializer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServletForInitializer extends HttpServlet {
	private String msg;
	
	public DemoServletForInitializer () {
		System.out.println("[DemoServletForInitializer] DemoServletForInitializer()");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("[DemoServletForInitializer] init()");
		msg = this.getInitParameter("msg");
	}
	
	@Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[DemoServletForInitializer] doGet(): " + msg);
        resp.getWriter().append(msg).close();
    }
}
