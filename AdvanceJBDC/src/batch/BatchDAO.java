package batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {

	public static void main(String[] args) {
		// Batch de operaciones
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
				"1234567890"); Statement statement = connection.createStatement();) {
			statement.addBatch("INSERT INTO account VALUES(10, 'Castro', 'Carlos', 10000)");
			statement.addBatch("INSERT INTO account VALUES(11, 'Clinton', 'Steve', 20000)");

			int[] results = statement.executeBatch();
			for (int i = 0; i < results.length; i++) {
				System.out.println(results[i]);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
