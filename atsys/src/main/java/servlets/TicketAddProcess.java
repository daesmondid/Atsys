package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enumerations.TicketStatus;
import models.User;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class TicketAddProcess
 */
@WebServlet("/TicketAddProcess")
public class TicketAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketAddProcess() {
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
		TicketStatus ticketStatus = AtsysDefaultUtil.getStringTicketStatusMap().get(request.getParameter("ticketStatus"));
		User user = new dao.User().get(Integer.parseInt(request.getParameter("userId")));
		String deviceId = request.getParameter("deviceId");
		
		new dao.Ticket().add(new models.Ticket(id, name, ticketStatus, user, deviceId));
		
		response.getWriter().append("{ \"alert\": \"success\", \"message\": \"Ticket Successfully Added\" }");
		//response.sendRedirect("Ticket");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
