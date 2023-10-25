package firstWeb;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet{
	
	private EmployeeDAO dao = new EmployeeDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess = req.getSession(true);
			sess.setAttribute("current", dao.firstId());
			sess.setAttribute("emp", dao.getEmployee((int) dao.firstId()));
			System.out.println(req.getAttribute("emp"));
			req.getRequestDispatcher("Employee.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(true);
		int current = (Integer)sess.getAttribute("current");
		String submit = req.getParameter("submit");
		try {
			
			if("First".equals(submit)) {
				current = dao.firstId();
			} else if("Last".equals(submit)){
				current = dao.lastId();
			} else if("Next".equals(submit)){
				current =  dao.nextId(current);
			} else if("Previous".equals(submit)){
				current = dao.previousId(current);
			}
			sess.setAttribute("current", current); //here we set current to current
			sess.setAttribute("emp", dao.getEmployee(current));

			resp.sendRedirect("Employee.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
