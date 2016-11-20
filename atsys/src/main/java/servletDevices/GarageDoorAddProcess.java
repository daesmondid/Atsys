package servletDevices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.DoorStatus;
import models.LogicBoard;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class GarageDoorAddProcess
 */
@WebServlet("/GarageDoorAddProcess")
public class GarageDoorAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GarageDoorAddProcess() {
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
		
		int id = AtsysDefaultUtil.getSaltInt();
		String name = request.getParameter("name");
		String deviceId = AtsysDefaultUtil.getSaltString();
		int pin = Integer.parseInt(request.getParameter("pin"));
		LogicBoard logicBoard = new dao.LogicBoard().get(Integer.parseInt(request.getParameter("logicBoardId")));
		DoorStatus doorStatus= DoorStatus.UNKNOWN;
		
		new dao.GarageDoor().add(new models.GarageDoor(id, name, deviceId, pin, logicBoard, doorStatus));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Added\" }");
		//response.sendRedirect("GarageDoor");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
