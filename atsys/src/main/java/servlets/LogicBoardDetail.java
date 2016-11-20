package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogicBoardDetail
 */
@WebServlet("/LogicBoardDetail")
public class LogicBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicBoardDetail() {
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
		
		request.setAttribute("userList", new dao.User().list());
		request.setAttribute("logicBoard", new dao.LogicBoard().get(id));
		request.setAttribute("appliancesList", new dao.Appliances().list());
		request.setAttribute("audioSystemList", new dao.AudioSystem().list());
		request.setAttribute("climateList", new dao.Climate().list());
		request.setAttribute("doorLockList", new dao.DoorLock().list());
		request.setAttribute("garageDoorList", new dao.GarageDoor().list());
		request.setAttribute("lightingList", new dao.Lighting().list());
		RequestDispatcher view = request.getRequestDispatcher("/LogicBoardDetail.jsp");
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