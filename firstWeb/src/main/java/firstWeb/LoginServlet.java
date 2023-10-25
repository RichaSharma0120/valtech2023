package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Username = "+request.getParameter("name") + "  Password = "+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * TODO if name and passsword are wrong, then show login pain ahain with the error message
	 * if name is less than 4 chars then add msg in the login page
	 * if pass is less than 8 chars then add msg and login page
	 * 
	 * show main login at the top, error messages should be on Red color
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		if(name.length()<4 || pass.length()<8) {
			
			if(name.length() < 4 ) {
				request.setAttribute("nameMessage", "Username must be atleast 4 characters long");
				
			}
			else{
				request.setAttribute("nameMessage", "");
			}
			if(pass.length() < 8){
				request.setAttribute("passMessage", "Password must be atleast 8 characters long");
			
			}
			else {
				request.setAttribute("passMessage", "");
			}
			request.getRequestDispatcher("loginError.jsp").forward(request, response);
		}
		
		else {
			if("scott".equals(name) && "root".equals(pass)) {
				request.setAttribute("message", "Hi Scott, How are you?");
			} else {
				request.setAttribute("message", "Only Scott is a valid user");
			}
			request.getRequestDispatcher("loginResults.jsp").forward(request, response);
		}
				
//		
//		if("scott".equals(name) && "root".equals(pass)) {
//			request.setAttribute("message", "Hi Scott, How are you?");
//		} else {
//			request.setAttribute("message", "Only Scott is a valid user");
//		}
//		request.getRequestDispatcher("loginResults.jsp").forward(request, response);
		
	}
}
