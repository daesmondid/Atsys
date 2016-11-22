package servletDevices;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AtsysDefaultUtil;

/**
 * Servlet implementation class AudioSystemDetail
 */
@WebServlet("/AudioSystemDetail")
public class AudioSystemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AudioSystemDetail() {
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
		
		String identity = request.getParameter("id");
		int id = Integer.parseInt(identity);
		
		new dao.LogicBoard().get(new dao.AudioSystem().get(id).getLogicBoard().getId()).checkConnection();
		
		request.setAttribute("connectionStatusList", AtsysDefaultUtil.getStringConnectionStatusMap().keySet());
		request.setAttribute("ticketStatusList", AtsysDefaultUtil.getStringTicketStatusMap().keySet());
		request.setAttribute("logicBoardList", new dao.LogicBoard().list());
		request.setAttribute("audioSystem", new dao.AudioSystem().get(id));
		request.setAttribute("ticketList", new dao.Ticket().list());
		RequestDispatcher view = request.getRequestDispatcher("/AudioSystemDetail.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
