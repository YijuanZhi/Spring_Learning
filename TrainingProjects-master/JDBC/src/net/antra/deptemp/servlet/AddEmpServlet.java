package net.antra.deptemp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.deptemp.businessLogic.DepartmentService;
import net.antra.deptemp.businessLogic.EmployeeService;
//not thread safe
public class AddEmpServlet extends HttpServlet {

	private static final long serialVersionUID = 2816246018987310520L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fn = req.getParameter("firstName");
		String ln = req.getParameter("lastName");
		String age = req.getParameter("age");
		String deptStr = req.getParameter("department");
		EmployeeService es = new EmployeeService();
		try {
			req.getSession().setAttribute("empList", es.addNewEmployee(fn, ln, age, Integer.parseInt(deptStr)));
			req.getSession().setAttribute("deptList", new DepartmentService().getDeptList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/addEmployee.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
