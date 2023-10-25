package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {

	private DepartmentDAO dept = new DepartmentDAOImpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(true);
		int current = (Integer) sess.getAttribute("current");
		String submit = req.getParameter("submit");
		try {

			if ("First".equals(submit)) {
				current = dept.firstId();
			} else if ("Next".equals(submit)) {
				current = dept.nextId(current);
			} else if ("Previous".equals(submit)) {
				current = dept.previousId(current);
			}else if("Last".equals(submit)){
				current = dept.lastId();
			}
			sess.setAttribute("current", current); //here we set current to current
			sess.setAttribute("dept", dept.getDepartment(current));
			resp.sendRedirect("Department.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
