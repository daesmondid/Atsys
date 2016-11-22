package servletClient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ClientClimateEditTemperatureProcess
 */
@WebServlet("/ClientClimateEditTemperatureProcess")
public class ClientClimateEditTemperatureProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientClimateEditTemperatureProcess() {
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
		int temperature = new dao.Climate().get(id).getTemperature() + Integer.parseInt(request.getParameter("temperature"));
		
		if (temperature <= 0) {
			
			temperature = 0;
			
		}
		
		new dao.Climate().clientEditTemperature(id, temperature);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
