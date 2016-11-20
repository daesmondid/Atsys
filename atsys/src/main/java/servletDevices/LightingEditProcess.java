package servletDevices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.LogicBoard;

/**
 * Servlet implementation class LightingEditProcess
 */
@WebServlet("/LightingEditProcess")
public class LightingEditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LightingEditProcess() {
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
		int intensity = 0;
		
		new dao.Lighting().edit(new models.Lighting(id, name, deviceId, pin, logicBoard, intensity));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Device Successfully Updated\" }");
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
