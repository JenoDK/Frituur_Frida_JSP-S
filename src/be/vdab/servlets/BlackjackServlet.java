package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.Blackjack;

/**
 * Servlet implementation class BlackjackServlet
 */
@WebServlet("/blackjack.htm")
public class BlackjackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/blackjack.jsp";
	private static final String SPEL = "blackjack";	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("score") == null){
			session.setAttribute("score", 0);
		}
		if (session.getAttribute("game") == null){
			session.setAttribute("game", 1);
		}
		if (session.getAttribute(SPEL) == null) {
			session.removeAttribute("gameMsg");	
			session.setAttribute(SPEL, new Blackjack());
		}
		Blackjack spel = (Blackjack) session.getAttribute(SPEL);
		session.setAttribute("cards",spel.getCardsInHand());
		session.setAttribute("value",spel.getValue());
		if (spel.getValue()>21){
			session.setAttribute("gameMsg", "You're broke, try again.");
		}
		if (spel.getValue()==21){
			session.setAttribute("gameMsg", "Perfect score! Gratz");
			int a = (Integer)session.getAttribute("score");
			session.setAttribute("score", a+3);
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("newGame") != null) {
			int a = (Integer)session.getAttribute("game");
			session.setAttribute("game", a+1);
			session.removeAttribute(SPEL);
			session.removeAttribute("gameMsg");	
		} else if (request.getParameter("newCard") != null) {
			Blackjack spel = (Blackjack) session.getAttribute(SPEL);
			if (spel != null && spel.getValue()<21) {
				spel.newCard();
				session.setAttribute(SPEL, spel);
			}
		} else if (request.getParameter("changeValue") != null) {
			Blackjack spel = (Blackjack) session.getAttribute(SPEL);
			if (spel.getValueOfHand() == spel.getValue()){
				spel.setValue(10);
				session.setAttribute(SPEL, spel);
			} else {
				spel.setValue(-10);
				session.setAttribute(SPEL, spel);
			}
			if (spel.getValue() <= 21){
				session.removeAttribute("gameMsg");
			}
		} else if (request.getParameter("stop") != null){
			Blackjack spel = (Blackjack) session.getAttribute(SPEL);
			if (spel.getValue()>21){
				session.setAttribute("gameMsg", "You're broke, try again.");
			}else {
				session.setAttribute("gameMsg", "Your value: "+spel.getValue());
				if (spel.getValue()==19){
					int a = (Integer)session.getAttribute("score");
					session.setAttribute("score", a+1);
				}else if (spel.getValue()==20){
					int a = (Integer)session.getAttribute("score");
					session.setAttribute("score", a+2);
				}
			}
		}else  {
			session.setAttribute("score", 0);
			session.setAttribute("game", 1);
		}
		response.sendRedirect(response.encodeRedirectURL(request
				.getRequestURI()));
	}

}
