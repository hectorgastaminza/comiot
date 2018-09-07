package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comiot.core.application.server.User;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/signup.do")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");

		if(password.equals(confirm)) {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			User user = new User(username, password, email);
			
				
				if(1 > 0) {
					request.setAttribute("successMessage", "User created. Please login");
				} 
				else {
					request.setAttribute("errorMessage", "This user is already been registered");
				}
		}
		else {
			request.setAttribute("errorMessage", "Passwords are not equals");
		}
		
		request.getRequestDispatcher("/signup").forward(request, response);
	}
}
