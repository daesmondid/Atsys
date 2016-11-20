package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.UserType;
import utils.AtsysDefaultUtil;


/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		password = AtsysDefaultUtil.passwordProtect(password);
		
		if (new dao.User().countUserMatch(username, password) == 1) {
			
			HttpSession session = request.getSession();
			models.User user = new dao.User().get(username, password);
		    session.setAttribute("user", user);
		    if (user.getUserType() == UserType.NORMAL) {
		    	response.sendRedirect("Dashboard");
		    }
		    else if (user.getUserType() == UserType.ADMIN) {
		    	response.sendRedirect("User");
		    }
			
		}
		else {
			
			response.getWriter().append("Username Not Found");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
