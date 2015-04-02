package be.vdab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SausDAO;
import be.vdab.entities.Saus;

/**
 * Servlet implementation class SausIngredi�ntServlet
 */
@WebServlet("/sauzen/ingredi�nten.htm")
public class SausIngredi�ntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/ingrdi�nten.jsp";
	private final SausDAO sausDAO = new SausDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null) {
			String ingredi�nt = request.getParameter("ingredi�nt");
			List<Saus> sauzen = sausDAO.findByIngredi�nt(ingredi�nt);
			if (ingredi�nt.isEmpty()) {
				request.setAttribute("fout", "Vul het veld in");
			} else {
				if (sauzen.size() == 0) {
					request.setAttribute("fout", "Ingredi&#235;nt niet gevonden");
				} else {
					request.setAttribute("sausIngredi�nten", sauzen);
				}
			}
		} else {
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
