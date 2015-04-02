package be.vdab.servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns="/index.htm",name="indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final Adres adres= new Adres();
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		adres.setStraat(context.getInitParameter("straat"));
		adres.setHuisNr(context.getInitParameter("huisNr"));
		Gemeente gemeente = new Gemeente();
		gemeente.setNaam(context.getInitParameter("gemeente"));
		gemeente.setPostcode(Integer.parseInt(context.getInitParameter("postcode")));
		adres.setGemeente(gemeente);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("adres", adres);
		int dag = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);		
		request.setAttribute("openGesloten", dag == Calendar.MONDAY || dag == Calendar.THURSDAY ? "gesloten" : "open");
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
