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
 * Servlet implementation class SausIngrediëntServlet
 */
@WebServlet("/sauzen/ingrediënten.htm")
public class SausIngrediëntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/ingrdiënten.jsp";
	private final SausDAO sausDAO = new SausDAO();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null) {
			String ingrediënt = request.getParameter("ingrediënt");
			List<Saus> sauzen = sausDAO.findByIngrediënt(ingrediënt);
			if (ingrediënt.isEmpty()) {
				request.setAttribute("fout", "Vul het veld in");
			} else {
				if (sauzen.size() == 0) {
					request.setAttribute("fout", "Ingredi&#235;nt niet gevonden");
				} else {
					request.setAttribute("sausIngrediënten", sauzen);
				}
			}
		} else {
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
