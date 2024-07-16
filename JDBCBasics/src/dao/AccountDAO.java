package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {
		try(
			// Conectando con la BD
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234567890");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT *  FROM account");
		) {
			System.out.println(connection);
			
			//CRUD
			// Actualizacion a la BD CUD
//			int result = statement.executeUpdate("INSERT INTO account values(1, 'carlos', 'castro', 10000)");			
//			int result = statement.executeUpdate("UPDATE account SET bal=500000 WHERE accno = 1");
//			int result = statement.executeUpdate("DELETE FROM account WHERE accno=1");
//			System.out.println(result + " rows got inserted");
			
			// R
			System.out.println(".".repeat(100));
			while (result.next()) {
				System.out.println(result.getString("firstname"));
				System.out.println(result.getString("lastname"));
				System.out.println(result.getInt("bal"));
				System.out.println(".".repeat(100));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
