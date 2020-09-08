package net.antra.deptemp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.deptemp.businessLogic.DepartmentService;
//not thread safe
public class AddDeptServlet extends HttpServlet {

	private static final long serialVersionUID = 2816246018987310520L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("deptName");
		String email = req.getParameter("deptEmail");
		String[] employee = req.getParameterValues("employee");
		DepartmentService ds = new DepartmentService();
		req.getSession().setAttribute("deptList", ds.addNewDepartment(name, email, employee,req.getSession().getAttribute("deptList"),req.getSession().getAttribute("empList")));
		resp.sendRedirect("/addDepartment.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
