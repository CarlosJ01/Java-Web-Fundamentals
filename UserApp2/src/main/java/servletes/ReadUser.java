package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadUser
 */
@WebServlet("/ReadUser")
public class ReadUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext context = config.getServletContext();
			
			// Extraer todos los parametros
			Enumeration<String> initParameters = context.getInitParameterNames();
			while (initParameters.hasMoreElements()) {
				String nameParam = (String) initParameters.nextElement();
				System.out.println("Contex param name: " + nameParam);
				System.out.println("Context param value: " + context.getInitParameter(nameParam));
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // Para tomcat
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
			PrintWriter out = response.getWriter();
			
			out.print("USERS<hr>");
			while (resultSet.next()) {	
				out.print(resultSet.getString(1) +" "+ resultSet.getString(2) +" "+ resultSet.getString(3) + "<hr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
