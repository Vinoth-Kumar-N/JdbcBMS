package dao;
import database.DBConnection;

import java.sql.*;
import java.util.Random;


public class EmployeeDAO {
    static Connection con = DBConnection.getConnection();
    public static void createCustomer(int cust_id, String name,String ifsc_code, String email, String pass, String accntType) {
        String query = "insert into customer values (?, ?, ?, ?, ?);";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, cust_id);
            ps.setString(2, name);
            ps.setString(3, ifsc_code);
            ps.setString(4, email);
            ps.setString(5, pass);

            ps.executeUpdate();
            System.out.println("Customer Created successfully");
            if(AccountDAO.createAccount(cust_id,name, ifsc_code, accntType)){
                System.out.println("Customer "+accntType+" account Created");
            }else{
                System.out.println("Account Not Created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
