import java.sql.PreparedStatement;
import java.sql.SQLException;

import sql.*;

public class App {

	public static void main(String[] args) throws Exception {
		SQLConnection sql = new SQLConnection("<domain>", "<port>", "<username>", "<password>");
		sql.connect("<database>");
		PreparedStatement ps = sql.prepareStatement("SELECT * FROM ?");
		ps.setString(1, "<table_name>");
		ps.execute();
		SQL.logResultSet(ps.getResultSet());
		
	}

}
