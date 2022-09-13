package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class SQL {
	public static void logResultSet(ResultSet set) throws SQLException {
		System.out.println("---------------[Result Set]---------------");
		while (set.next()) {
			int colCount = set.getMetaData().getColumnCount();
			String output = "";
			for (int i=1;i<=colCount;i++) {
				output += set.getString(i)+"\t";
			}
			System.out.println(output);
		}
		System.out.println("-----------[End of Result Set]------------");
	}
}
