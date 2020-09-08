package net.antra.deptemp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.deptemp.utility.UserUtility;
//not thread safe
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7381248825996568609L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("userName");
		String pwd = req.getParameter("password");
		boolean isValidUser = UserUtility.validateUser(name, pwd, req);
		if(isValidUser){
			req.getSession().setAttribute("invalidUser", false);
			req.getSession().setAttribute("userName", name.toUpperCase());
			req.getRequestDispatcher("/success.jsp").forward(req, resp);
		}else{
			req.getSession().setAttribute("invalidUser", true);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
