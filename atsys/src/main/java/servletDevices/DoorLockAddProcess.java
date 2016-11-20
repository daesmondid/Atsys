package servletDevices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumerations.LockStatus;
import models.LogicBoard;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class DoorLockAddProcess
 */
@WebServlet("/DoorLockAddProcess")
public class DoorLockAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoorLockAddProcess() {
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
		String deviceId = AtsysDefaultUtil.getSaltString();
		int pin = Integer.parseInt(request.getParameter("pin"));
		LogicBoard logicBoard = new dao.LogicBoard().get(Integer.parseInt(request.getParameter("logicBoardId")));
		LockStatus lockStatus = LockStatus.UNKNOWN;
		
		new dao.DoorLock().add(new models.DoorLock(id, name, deviceId, pin, logicBoard, lockStatus));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Added\" }");
		//response.sendRedirect("DoorLock");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
