package customtags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport{
	
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstm;
	
	public ResultHandler() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234567890");
			pstm = con.prepareStatement("SELECT * FROM user WHERE email=?");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int doStartTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		String email = request.getParameter("Email");
		try {
			pstm.setString(1, email);
			ResultSet rows = pstm.executeQuery();
			JspWriter out = pageContext.getOut();
			if (rows.next()) {
				out.println("User Details");
				out.println(rows.getString(0)); //FN
				out.println(rows.getString(1)); //LN
			} else {
				out.println("Invalid Email");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return Tag.SKIP_BODY;
	}
	
	@Override
	public void release() {
		try {
			pstm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
