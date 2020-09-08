package net.antra.deptemp.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("*")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
//		System.out.println("do filter work before pass to next filter util hit the servlet");
		HttpServletRequest req = (HttpServletRequest)arg0;
		Object obj = req.getSession().getAttribute("invalidUser");
		if(req.getRequestURI().startsWith("/login")){
			arg2.doFilter(arg0, arg1);
		}else{
			if(obj == null || (boolean)obj){
				req.getRequestDispatcher("/index.jsp").forward(arg0, arg1);
			}else{
				arg2.doFilter(arg0, arg1);
			}
		}
		System.out.println("filter:" + req.getRequestURI());
//		System.out.println("do filter work after the servlet is done");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
