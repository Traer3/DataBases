import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbFunctions dbFunctions = new DbFunctions();

        Connection conn = dbFunctions.connection_to_db("tutdb","postgres","");
        //dbFunctions.createTable(conn,"deleted_table");
        //dbFunctions.insertRow(conn,"employee","Vitalik","Red Grave");
        //dbFunctions.updateData(conn,"employee","Red Grave",1);
        //dbFunctions.updateName(conn,"employee","Victor","Vitalik");
        //dbFunctions.searchByName(conn,"employee","Dimon");
        //dbFunctions.deleteByName(conn,"employee","Durinda");
        //dbFunctions.readData(conn,"employee");
        dbFunctions.deleteTable(conn,"deleted_table");
    }
}