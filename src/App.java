import java.util.ArrayList;

import sql.SQLConnection;
import sql.Table;
import utilities.*;

public class App {
    public static void main(String[] args) throws Exception { //TODO: Remember to have the jdbc driver in your reference library
        SQLConnection sql = new SQLConnection("127.0.0.1", "1433", "username", "password");
        sql.connect("company");
        Table queryData = sql.sendQuery("SELECT * FROM Employee");
        System.out.println("Table dimensions: "+queryData.height()+" x "+queryData.width());
        for (ArrayList<String> collumn : queryData.getTableAsArray()) {
            String line = "|";
            for (String data : collumn) {
                line += data+"|";
            }
            System.out.println(line);
        }
        // ArrayList<String> keys = sql.insertRow("INSERT INTO [dbo].[Employee] ( [fname], [minit], [lname], [ssn], [bdate], [address], [sex], [salary], [super_ssn], [dno] ) VALUES ( 'Philip', 'N', 'Nielsen', '098765432', null, 'Lyngvejen 31, Løgstør', 'M', 130000.00, null, 1 )");
        // for (String key : keys) {
        //     System.out.println(key);
        // }
    }
}