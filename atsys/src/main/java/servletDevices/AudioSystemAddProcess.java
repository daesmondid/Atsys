package servletDevices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumerations.PowerStatus;
import models.LogicBoard;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class AudioSystemAddProcess
 */
@WebServlet("/AudioSystemAddProcess")
public class AudioSystemAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AudioSystemAddProcess() {
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
		int volumeLevel = 0;
		int musicId = 0;
		PowerStatus powerStatus = PowerStatus.UNKNOWN;
		
		new dao.AudioSystem().add(new models.AudioSystem(id, name, deviceId, pin, logicBoard, volumeLevel, musicId, powerStatus));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Added\" }");
		//response.sendRedirect("AudioSystem");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
