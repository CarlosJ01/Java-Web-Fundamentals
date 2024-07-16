package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addServlet
 */

// Init Param
@WebServlet(urlPatterns = "/addServlet", initParams = {
		@WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost:3306/mydb"),
		@WebInitParam(name = "dbUser", value = "root"), @WebInitParam(name = "dbPassword", value = "1234567890") })
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;

	/*
	 * Cuando inicia la conexion
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Para tomcat
			connection = DriverManager.getConnection(config.getInitParameter("dbUrl"),
					config.getInitParameter("dbUser"), config.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("INSERT INTO user VALUES('" + firstName + "', '" + lastName + "', '"
					+ email + "', '" + password + "')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>USER CREATED</h1>");
			} else {
				out.println("<h1>ERROR RESPONSE</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Terminar la conexion
	 */
	@Override
	public void destroy() {
		super.destroy();
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
