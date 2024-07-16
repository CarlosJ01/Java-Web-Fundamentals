package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServelt extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		if (request.getParameter("num1") != null && request.getParameter("num2") != null) {
			// Obtener parametros
			Long num1 = Long.parseLong(request.getParameter("num1"));
			Long num2 = Long.parseLong(request.getParameter("num2"));

			PrintWriter out = response.getWriter();
			out.println("Result : " + (num1 + num2));
		}

	}

}
