package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.ConnectionStatus;
import models.User;

/**
 * Servlet implementation class LogicBoardEditProcess
 */
@WebServlet("/LogicBoardEditProcess")
public class LogicBoardEditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicBoardEditProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") == null) {
			
			response.sendRedirect("Login");
			return;
			
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		ConnectionStatus connectionStatus = ConnectionStatus.UNKNOWN;
		User user = new dao.User().get(Integer.parseInt(request.getParameter("userId")));
		
		new dao.LogicBoard().edit(new models.LogicBoard(id, name, address, connectionStatus, user));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Logic Board Successfully Updated\" }");
		//response.sendRedirect("LogicBoard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
