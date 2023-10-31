package Assignments;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberSystemServlet
 */
public class NumberSystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberSystemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
        String operation = request.getParameter("operation");
        String toSystem = request.getParameter("toSystem");
        int sum = 0;
        String result;
        
        if("Add".equals(operation)) {
        	sum = number1 + number2;
        	
        } else if("Sub".equals(operation)) {
        	sum = number1 - number2;
        }
        
        switch (toSystem) {
        case "binary":
            result = Integer.toBinaryString(sum);
            break;
        case "decimal":
            result = Integer.toString(sum);
            break;
        case "hexadecimal":
            result = Integer.toHexString(sum).toUpperCase();
            break;
        case "octal":
            result = Integer.toOctalString(sum);
            break;
        default:
            result = "Invalid Selection";
            break;
    }
        
        request.setAttribute("result", result);
        request.setAttribute("decimalResult", sum);
        request.getRequestDispatcher("numberSystemResult.jsp").forward(request, response);

	}

}
