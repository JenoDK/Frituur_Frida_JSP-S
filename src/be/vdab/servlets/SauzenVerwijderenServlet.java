package be.vdab.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.dao.SausDAO;

/**
 * Servlet implementation class SauzenVerwijderenServlet
 */
@WebServlet("/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "%s/sauzen.htm";
	private final transient SausDAO sausDAO = new SausDAO();

	@Resource(name = SausDAO.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		sausDAO.setDataSource(dataSource);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("nummer") != null) {
			for (String nummerAlsString : request.getParameterValues("nummer")) {
				sausDAO.delete(Long.parseLong(nummerAlsString));
			}
		}
		response.sendRedirect(String.format(VIEW, request.getContextPath()));
	}
}
