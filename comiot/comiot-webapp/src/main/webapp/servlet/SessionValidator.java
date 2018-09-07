package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionValidator {
       
	public static boolean isSessionValid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean valid = false;
		
		String validsession = (String)request.getSession().getAttribute("validsession");
		
		if((validsession != null) && (validsession.equals(request.getSession().getId()))) {
			valid = true;
		}
		else {
			String username = (String) request.getSession().getAttribute("username");
			String password = (String) request.getSession().getAttribute("password");
			
			if((username != null) && (password != null)) {
					
					if(1 > 0) {
						valid = true;
						request.getSession().setAttribute("userpk", 1);
						request.getSession().setAttribute("validsession", request.getSession().getId());
					}
			}
			else {
				request.getSession().removeAttribute("validsession");
				request.getSession().removeAttribute("username");
				request.getSession().removeAttribute("password");
			}
		}
		
		return valid;
	}
}
