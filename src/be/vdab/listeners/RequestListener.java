package be.vdab.listeners;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener,
		ServletContextListener {
	private final static String STATISTIEK = "statistiek";
	private final static Set<String> UITGESLOTEN_EXTENSIES = new CopyOnWriteArraySet<>(
			Arrays.asList("png", "gif", "jpg", "css", "js", "ico"));

	/**
	 * Default constructor.
	 */
	public RequestListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent event) {
		if (event.getServletRequest() instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) event
					.getServletRequest();
			String url = request.getRequestURI();
			boolean verwerkRequest = true;
			int laatstePuntPositie = url.lastIndexOf('.');
			if (laatstePuntPositie != -1) {
				String extensie = url.substring(laatstePuntPositie + 1)
						.toLowerCase();
				if (UITGESLOTEN_EXTENSIES.contains(extensie)) {
					verwerkRequest = false;
				}
			}
			if (verwerkRequest) {
				int index = url.indexOf(";jsessionid=");
				if (index != -1) {
					url = url.substring(0, index);
				}
				@SuppressWarnings("unchecked")
				ConcurrentHashMap<String, AtomicInteger> statistiek = (ConcurrentHashMap<String, AtomicInteger>) request
						.getServletContext().getAttribute(STATISTIEK);
				AtomicInteger aantalReedsAanwezig = statistiek.putIfAbsent(url,
						new AtomicInteger(1));
				if (aantalReedsAanwezig != null) {
					aantalReedsAanwezig.incrementAndGet();
				}
			}
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute(STATISTIEK,
				new ConcurrentHashMap<String, AtomicInteger>());
	}

}
