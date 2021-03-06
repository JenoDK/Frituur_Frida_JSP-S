
package be.vdab.servlets;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import be.vdab.dao.SausDAO;
import be.vdab.entities.SausRadenSpel;


@WebServlet("/sausraden.htm")
public class SausRadenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sausraden.jsp";
	private static final String SPEL = "sausRadenSpel";	
	private final transient SausDAO sausDAO = new SausDAO();
	
	@Resource(name = SausDAO.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
		sausDAO.setDataSource(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute(SPEL) == null) {
			session.setAttribute(SPEL, new SausRadenSpel(sausDAO.findAll()));
		}
		SausRadenSpel spel = (SausRadenSpel) session.getAttribute(SPEL);
		spel.checkIfWordHasBeenFound();
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("nieuwSpel") != null) {
			session.removeAttribute(SPEL);			
		} else {
			char letter = request.getParameter("letter").charAt(0);
			SausRadenSpel spel = (SausRadenSpel) session.getAttribute(SPEL);
			if (spel != null && spel.getFouten()<10 && !spel.checkIfWordHasBeenFound()) {
				spel.checkIfCharExists(letter);
				session.setAttribute(SPEL, spel);
			} 
		}
		response.sendRedirect(response.encodeRedirectURL(request
				.getRequestURI()));
	}

}

