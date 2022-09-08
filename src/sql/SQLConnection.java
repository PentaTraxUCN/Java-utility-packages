package sql;
import java.sql.*;
import java.util.ArrayList;

public class SQLConnection{
    private String server_domain;
    private String port;
    private String username;
    private String password;
    private boolean encrypt = true;
    private boolean trustCertificate = true;
    private int timeout = 30;
    private String connectionUrl="";

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

    public boolean connect(String database){
        boolean success = false;
        String url = "jdbc:sqlserver://"+server_domain+":"+port+";database="+database+";user="+username+";password="+password+";encrypt="+encrypt+";trustServerCertificate="+trustCertificate+";loginTimeout="+timeout+";";
        try (Connection connection = DriverManager.getConnection(url)){
            this.connectionUrl = url;
            success = true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return success;
    }
    
    public Table sendQuery(String query){
        Table table = new Table();
        try (Connection connection = DriverManager.getConnection(connectionUrl)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metadata = resultSet.getMetaData();
            table = new Table();
            while (resultSet.next()){
                ArrayList<String> collumn = new ArrayList<>();
                for (int i=1;i<metadata.getColumnCount();i++){
                    collumn.add(resultSet.getString(i));
                }
                table.addRow(collumn);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return table;
    }

    public ArrayList<String> insertRow(String insertQuery){
        ArrayList<String> keys = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl)){
            PreparedStatement prepsInsertProduct = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            resultSet = prepsInsertProduct.getGeneratedKeys();
            while (resultSet.next()){
                keys.add(resultSet.getString(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return keys;
    }

}
