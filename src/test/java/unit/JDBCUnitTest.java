package unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class JDBCUnitTest {

	/**
	 * JDBC = Java Data Base Connectivity
	 * To access different types of DB use different JDBC dependencies / Types
	 * 1. (Optional) Register driver = JDBC Type (Class.forName("jdbc.mysql..")) / DriverManager
	 * 2. Create Connection object = DriverManager.createConnection(url, user, pass)
	 * 3. Statement object = Connection.createStatement();
	 * 4. statement.execute("");
	 * 5. ResultSet object = Statement.getResultSet();
	 * close resource / connection;
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	@Test
	public void dbTest() throws ClassNotFoundException, SQLException {
		//Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employees_db", "postgres", "hr");
		
		System.out.println("DB Connected...");
		
		Statement statement = connection.createStatement();
		statement.execute("select * from employees");
		
		ResultSet resultSet = statement.getResultSet();
		ResultSetMetaData metaData = resultSet.getMetaData();
		
		System.out.println(metaData.getColumnCount());
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		while (resultSet.next()) {
//			System.out.print(resultSet.getString("first_name") + ",");
//			System.out.print(resultSet.getString("last_name") + ",");
//			System.out.print(resultSet.getString("birth_date") + ",");
//			System.out.print(resultSet.getString("gender") + ",");
//			System.out.print(resultSet.getString("email"));
//			System.out.println();
			
			Map<String, Object> map = new LinkedHashMap<>();
			
			for(int i = 1; i <= metaData.getColumnCount(); i++) {
				String key = metaData.getColumnName(i);
				Object value = resultSet.getObject(i);
				map.put(key, value);
			}
			list.add(map);
		}
		connection.close();
		
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}
