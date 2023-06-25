import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils {

    private static String dbURL = "jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'classpath:init.sql'";
    private static String dbUsername = "sa";
    private static String dbPassword = "";


    public static Connection getConnection(){


        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);

        }catch (Exception e){
            System.out.println(e);
        }
        return  connection;
    }

    /*
    public static Connection getConnection(){

        String dbURL = null;
        String dbUsername = "sa";
        String dbPassword = "";

        Connection connection = null;
		
        FileInputStream fis;  
        Properties properties = new Properties(); 
        
        try {
            fis = new FileInputStream("src/main/resources/config.properties"); 
            properties.load(fis); 
            dbURL = properties.getProperty("db.host"); 
            
            connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
            
        }catch (Exception e){
            System.out.println(e);
        }
        return  connection;
    }
    */


}
