package sql;
import java.sql.*;

public class SQLConnection{
    private String server_domain;
    private String port;
    private String username;
    private String password;
    private boolean encrypt = true;
    private boolean trustCertificate = true;
    private int timeout = 30;
    private Connection connection;

    public SQLConnection (String server_domain, String port, String username, String password, boolean encrypt, boolean trustCertificate, int loginTimeout ){
        this.server_domain = server_domain;
        this.port = port;
        this.username = username;
        this.password = password;
    }
    public SQLConnection (String server_domain, String port, String username, String password){
        this.server_domain = server_domain;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public void connect(String database) throws SQLException {
        String url = "jdbc:sqlserver://"+server_domain+":"+port+";database="+database+";user="+username+";password="+password+";encrypt="+encrypt+";trustServerCertificate="+trustCertificate+";loginTimeout="+timeout+";";
        connection = DriverManager.getConnection(url);
    }
    
    public PreparedStatement prepareStatement (String statement) throws SQLException {
    	return this.connection.prepareStatement(statement);
    }
    public ResultSet query(String query) throws SQLException {
    	return this.connection.createStatement().executeQuery(query);
    }
}
