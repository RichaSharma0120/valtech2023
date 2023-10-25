package firstWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	private int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init of hello servlet");
		System.out.println("Driver Class = "+config.getInitParameter("driver-class"));
		System.out.println("Jdbc Url = " +config.getInitParameter("jdbc-url"));
		System.out.println("Username = " +config.getInitParameter("username"));
		System.out.println("Password = " +config.getInitParameter("password"));
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy of hello world" + count);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		//resp.getWriter().print("Hello World");
		String name = req.getParameter("name");
		PrintWriter out = resp.getWriter();	
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("</body>");
		out.print("</html>");
	}

}
