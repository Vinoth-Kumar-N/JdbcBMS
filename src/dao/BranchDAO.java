package dao;

import dao.AccountDAO;
import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.AccountDAO;

public class BranchDAO {
    public static boolean authenticateCustomer(String email, String pass){
        Connection con = DBConnection.getConnection();

        String authQuery = "SELECT * FROM customer where email = ? and pass = ?";
        //String getIfsc = "SELECT ifsc_code from employee where email = ? and pass = ?";

        try(PreparedStatement ps = con.prepareStatement(authQuery)){
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            int r=0;
            int cust_id=0;
            while(rs.next()){
                cust_id = rs.getInt("cust_id");
                r++;
            }

            if(cust_id != 0 && !AccountDAO.isHavingAccount(cust_id)){
                System.out.println("You Didn't have Account");
                return false;
            }
            return ((r > 0) && AccountDAO.isHavingAccount(cust_id));
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
