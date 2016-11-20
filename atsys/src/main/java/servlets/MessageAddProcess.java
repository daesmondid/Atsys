package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enumerations.TicketStatus;
import models.Ticket;
import models.User;
import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class MessageAddProcess
 */
@WebServlet("/MessageAddProcess")
public class MessageAddProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageAddProcess() {
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
		TicketStatus ticketStatus = AtsysDefaultUtil.getStringTicketStatusMap().get(request.getParameter("ticketStatus"));
		User user = null;
		String deviceId = request.getParameter("deviceId");
		
		new dao.Ticket().edit(new models.Ticket(id, name, ticketStatus, user, deviceId));
		
		int messageId = AtsysDefaultUtil.getSaltInt();
		String content = request.getParameter("content").replaceAll("\n", "<br />");
		String timestamp = "N/A";
		Ticket ticket = new models.Ticket(id, name, ticketStatus, user, deviceId);
		User messageUser = (User) request.getSession().getAttribute("user");
		
		new dao.Message().add(new models.Message(messageId, content, timestamp, ticket, messageUser));
		
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
