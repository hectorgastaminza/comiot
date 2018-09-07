package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	
	//private UserValidationService userValidationService = new UserValidationService();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	    HttpSession session = request.getSession();
	    session.removeAttribute("username");
	    session.removeAttribute("password");
		
		int userID = 0;
		
		if (userID > 0) {
		    session.setAttribute("username", username);
		    session.setAttribute("password", password);
			response.sendRedirect("/app/home");
		}
		else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}
}