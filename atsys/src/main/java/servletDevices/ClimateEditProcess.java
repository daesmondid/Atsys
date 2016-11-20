package servletDevices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.PowerStatus;
import models.LogicBoard;

/**
 * Servlet implementation class ClimateEditProcess
 */
@WebServlet("/ClimateEditProcess")
public class ClimateEditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClimateEditProcess() {
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
		String deviceId = "N/A";
		int pin = Integer.parseInt(request.getParameter("pin"));
		LogicBoard logicBoard = new dao.LogicBoard().get(Integer.parseInt(request.getParameter("logicBoardId")));
		int temperature = 0;
		PowerStatus powerStatus = PowerStatus.UNKNOWN;
		
		new dao.Climate().edit(new models.Climate(id, name, deviceId, pin, logicBoard, temperature, powerStatus));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Updated\" }");
		//response.sendRedirect("Climate");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
