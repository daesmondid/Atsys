package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumerations.ConnectionStatus;
import models.User;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class LogicBoardAddProcess
 */
@WebServlet("/LogicBoardAddProcess")
public class LogicBoardAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicBoardAddProcess() {
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
		String address = request.getParameter("address");
		ConnectionStatus connectionStatus = ConnectionStatus.UNKNOWN;
		User user = new dao.User().get(Integer.parseInt(request.getParameter("userId")));
		
		new dao.LogicBoard().add(new models.LogicBoard(id, name, address, connectionStatus, user));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Logic Board Successfully Added\" }");
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
