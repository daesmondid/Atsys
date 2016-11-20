package servletDevices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.LogicBoard;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class LightingAddProcess
 */
@WebServlet("/LightingAddProcess")
public class LightingAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LightingAddProcess() {
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
		int intensity = 0;
		
		new dao.Lighting().add(new models.Lighting(id, name, deviceId, pin, logicBoard, intensity));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Added\" }");
		//response.sendRedirect("Lighting");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
