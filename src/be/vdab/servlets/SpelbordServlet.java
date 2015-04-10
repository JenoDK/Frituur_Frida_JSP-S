package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import be.vdab.entities.Spelbord;


@WebServlet("/spelbord.htm")
public class SpelbordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/spelbord.jsp";
	private static final String SPEL = "spelbord";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute(SPEL) == null) {
			session.setAttribute(SPEL, new Spelbord());
		}
		Spelbord spel = (Spelbord) session.getAttribute(SPEL);
		if (spel.checkIfFinished()) {
			request.setAttribute("bericht", "U bent gewonnen!");
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Spelbord spel = (Spelbord) session.getAttribute(SPEL);
		if (request.getParameter("nieuwSpel") != null) {
			session.removeAttribute(SPEL);			
		}else if (request.getParameter("left") != null){
			spel.setCoordX(-2);
		}else if (request.getParameter("right") != null){
			spel.setCoordX(2);
		}else if (request.getParameter("up") != null){
			spel.setCoordY(-2);
		}else if (request.getParameter("down") != null){
			spel.setCoordY(2);
		}
		response.sendRedirect(response.encodeRedirectURL(request
				.getRequestURI()));
	}

}
