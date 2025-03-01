package dao;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public static void createEmployee(int emp_id, String emp_name, String ifsc_code, String email, String pass, double sal){
        Connection con = DBConnection.getConnection();

        String query = "insert into employee values (?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, emp_id);
            ps.setString(2, emp_name);
            ps.setString(3, ifsc_code);
            ps.setString(4, email);
            ps.setString(5, pass);
            ps.setDouble(6, sal);
            ps.executeUpdate();
            System.out.println("Employee created Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static boolean authenticateEmployee(String email, String pass){
        Connection con = DBConnection.getConnection();

        String authQuery = "SELECT * FROM employee where email = ? and pass = ?";
        //String getIfsc = "SELECT ifsc_code from employee where email = ? and pass = ?";

        try(PreparedStatement ps = con.prepareStatement(authQuery)){
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            int r=0;
            while(rs.next()){
                r++;
            }
            return r > 0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
