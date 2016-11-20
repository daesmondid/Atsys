package servletDevices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumerations.DoorStatus;
import models.LogicBoard;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class GarageDoorEditProcess
 */
@WebServlet("/GarageDoorEditProcess")
public class GarageDoorEditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GarageDoorEditProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AtsysDefaultUtil.validateLogin(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String deviceId = "N/A";
		int pin = Integer.parseInt(request.getParameter("pin"));
		LogicBoard logicBoard = new dao.LogicBoard().get(Integer.parseInt(request.getParameter("logicBoardId")));
		DoorStatus doorStatus= DoorStatus.UNKNOWN;
		
		new dao.GarageDoor().edit(new models.GarageDoor(id, name, deviceId, pin, logicBoard, doorStatus));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Updated\" }");
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