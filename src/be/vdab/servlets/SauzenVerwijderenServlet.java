package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SausDAO;

/**
 * Servlet implementation class SauzenVerwijderenServlet
 */
@WebServlet("/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "%s/sauzen.htm";
	private final SausDAO sausDAO = new SausDAO();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("nummer") != null) {
			for (String nummerAlsString : request.getParameterValues("nummer")) {
				sausDAO.remove(Long.parseLong(nummerAlsString));
			}
		}
		response.sendRedirect(String.format(VIEW, request.getContextPath()));
	}
}
