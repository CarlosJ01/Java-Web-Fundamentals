package tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {
	
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234567890"); 
			Statement statement = connection.createStatement();
			
			connection.setAutoCommit(false);
			
			statement.executeUpdate("UPDATE account SET bal = bal - 500 WHERE accno=10");
			statement.executeUpdate("UPDATE account SET bal = bal + 500 WHERE accno=11");
			
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.close();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
}
