import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connection_to_db(String dbname,String user,String pass){
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (conn!=null){
                System.out.println("Connection Established");
            }else {
                System.out.println("Connection Failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn,String table_name){
        Statement statement;
        try {
            String query = "create table "+table_name+"(empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insertRow(Connection conn ,String table_name,String name , String address){
        Statement statement;
        try {
            String query = String.format("insert into %s(name,address) values('%s','%s');",table_name,name,address);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void readData(Connection conn,String table_name){

        try {
            String query = String.format("select * from %s;",table_name);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                System.out.println(result.getInt("empid") + " "
                + result.getString("address") + " "
                + result.getString("name"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void updateData(Connection conn, String table_name,String address,Integer epmid){
        try {
            String query = String.format("update %s set address = '%s' where empid = '%s';",table_name,address,epmid);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void updateName(Connection conn, String table_name,String oldName,String newName){
        try {
            String query = String.format("update %s set name = '%s' where name = '%s';",table_name,newName,oldName);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void searchByName(Connection conn,String table_name,String name){
        try {
            String query = String.format("select * from %s where name = '%s';",table_name,name);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                System.out.println(result.getInt("empid") + " "
                        + result.getString("address") + " "
                        + result.getString("name"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteByName(Connection conn, String table_name, String name){
        try {
            String query = String.format("delete from %s where name = %s;",table_name,name);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Person deleted!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteTable(Connection conn, String table_name){
        try {
            String query = String.format("drop table %s;",table_name);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}






















