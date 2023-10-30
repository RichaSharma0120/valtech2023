package firstWebNEW;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class EmployeeListServlet
 */
public class EmployeeListServlet extends HttpServlet {

	private EmployeeDAO dao = new EmployeeDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess = req.getSession(true);
			req.setAttribute("emp", dao.getAllEmployees());
			
			System.out.println(req.getAttribute("emp"));
//			resp.sendRedirect("employeeList.jsp");
			req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(true);
//		int current = (Integer)sess.getAttribute("currentId");

		String submit = req.getParameter("submit");

		int empId = Integer.parseInt(req.getParameter("empId"));
		sess.setAttribute("currentId", empId);
		System.out.println(empId);
//		Employee curEmp = null;
		try {

			if ("View".equals(submit)) {
				req.setAttribute("emp", dao.getEmployee(empId));
				req.getRequestDispatcher("viewEmployee.jsp").forward(req, resp);
				
		} 
				else if ("Edit".equals(submit)) {
//				req.setAttribute("emp", dao.getEmployee(empId));
//				req.getRequestDispatcher("editOrCreateEmployee.jsp").forward(req, resp);
//				
			} 
				else if ("Delete".equals(submit)) {
				dao.deleteEmployee(empId);
				req.setAttribute("emp", dao.getAllEmployees());
				req.getRequestDispatcher("employeeList.jsp").forward(req, resp);
				
			}
//				else if("CreateNewEmployee".equals(submit)) {
//					req.getRequestDispatcher("editOrCreateEmployee.jsp").forward(req, resp);
//					System.out.println("back in servlet");
//				}
//			sess.setAttribute("current", currentId); //here we set current to current

			resp.sendRedirect("employeeList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
