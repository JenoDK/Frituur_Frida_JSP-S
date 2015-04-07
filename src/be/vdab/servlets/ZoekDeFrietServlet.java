package be.vdab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ZoekDeFrietServlet
 */
@WebServlet("/zoekdefriet.htm")
public class ZoekDeFrietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/zoekdefriet.jsp";
	private Map<Long, String> friet = new HashMap<>();
	

	public ZoekDeFrietServlet() {
		friet.put(1L, "deurtoe");
		friet.put(2L, "deurtoe");
		friet.put(3L, "deurtoe");
		friet.put(4L, "deurtoe");
		friet.put(5L, "deurtoe");
		friet.put(6L, "deurtoe");
		friet.put(7L, "deurtoe");
	}
	public long getRandom(){
		long LOWER_RANGE = 1; //assign lower range value
		long UPPER_RANGE = 7; //assign upper range value
		Random random = new Random();
		long randomValue = LOWER_RANGE + 
                (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));
		return randomValue;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("unchecked")
			Map<Long, String> mandje = (Map<Long, String>) session
					.getAttribute("mandje");
			if (mandje != null) {
				request.setAttribute("alleFrieten", mandje);
			}
		}else {
			HttpSession session1 = request.getSession();			
			session1.setAttribute("random", getRandom());			
			request.setAttribute("alleFrieten", friet);
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getCookies() == null) {
			request.setAttribute("fout", "Dit werkt enkel als cookies aanstaan");
			request.getRequestDispatcher(VIEW).forward(request, response);
			return;
		}
		if (request.getParameter("volgnummer").equals("Nieuw spel")) {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			Map<Long, String> venstersInMandje = (Map<Long, String>) session
					.getAttribute("mandje");
			for (Long key : venstersInMandje.keySet()) {
				venstersInMandje.put(key, "deurtoe");
			}
			session.setAttribute("random", getRandom());
			session.setAttribute("mandje", venstersInMandje);
		} else {
			if (request.getParameter("volgnummer") != null) {
				HttpSession session = request.getSession();
				@SuppressWarnings("unchecked")
				Map<Long, String> venstersInMandje = (Map<Long, String>) session
						.getAttribute("mandje");
				if (venstersInMandje == null) {
					venstersInMandje = friet;
				}
				if (((Long)Long.valueOf(request.getParameter("volgnummer")).longValue()).equals((Long)session.getAttribute("random"))){
					venstersInMandje.put(
							Long.valueOf(request.getParameter("volgnummer"))
									.longValue(), "gevonden");
				}else {
					venstersInMandje.put(
							Long.valueOf(request.getParameter("volgnummer"))
									.longValue(), "deuropen");
				}
				
				session.setAttribute("mandje", venstersInMandje);
			}
		}
		response.sendRedirect(response.encodeRedirectURL(request
				.getRequestURI()));
	}

}
