package sm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceServlet
 */
@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SourceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Cookies
		/*
		 * Una cookie es un pequeño fragmento de texto que los sitios web que visitas envían a tu navegador. 
		 * Las cookies permiten que los sitios recuerden información sobre tu visita, lo que puede hacer que sea más fácil volver 
		 * a visitar los sitios y que estos te resulten más útiles.
		 */
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {			
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				System.out.println("-".repeat(100));
			}
			response.addCookie(new Cookie("securityToken", "1234")); // Añadiendo cookie
		}
		
		String username = request.getParameter("userName");
		
		// Nuevos datos en la sesion actual
		HttpSession session = request.getSession(); // Obtiene o crea la sesion
		session.setAttribute("user", username);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "targetServlet?sessionId=123"; //URL Rewriting ??? cuando las cookes estan desactivadas usa esto parace
		out.println("<a href='"+url+"'> Click here to get the user name </a>");
	}

}
