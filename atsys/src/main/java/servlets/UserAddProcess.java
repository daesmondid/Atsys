package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumerations.UserType;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class UserAddProcess
 */
@WebServlet("/UserAddProcess")
public class UserAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AtsysDefaultUtil.validateLogin(request, response);
		
		int id = AtsysDefaultUtil.getSaltInt();
		String name = request.getParameter("name");
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordver = request.getParameter("passwordver");
		UserType userType = AtsysDefaultUtil.getStringUserTypeMap().get(request.getParameter("userType"));
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String mobilePhone = request.getParameter("mobilePhone");
		String homePhone = request.getParameter("homePhone");
		
		if (password.equals(passwordver)) {
			
			if (new dao.User().countUserMatch(username, password) == 1) {
				
				response.getWriter().append("{ \"alert\": \"error\", \"message\": \"Email address exist\" }");
				//response.sendRedirect("User");
				
			}
			else {
				
				new dao.User().add(new models.User(id, name, username, password, userType, address, email, mobilePhone, homePhone));
				
				response.getWriter().append("{ \"alert\": \"success\", \"message\": \"User Successfully Added\" }");
				//response.sendRedirect("User");
				
			}
			
		}
		else {
			
			response.getWriter().append("{ \"alert\": \"error\", \"message\": \"Password Re-Type does not match the Password\" }");
			//response.sendRedirect("User");
			
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
