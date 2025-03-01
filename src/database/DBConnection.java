package database;
import java.net.URI;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/pract_bms";
    private static final String USER = "root";
    private static final String PASS = "Vinoth#122";
    static Connection con;
    public static Connection getConnection(){
        if(con == null){
            try{
                con = DriverManager.getConnection(URL, USER, PASS );
                System.out.println("DB connected");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return con;
    }
}
