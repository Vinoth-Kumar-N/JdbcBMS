package dao;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class bankDAO {
    public static void createBranch(String ifsc_code, String branch_name){
        Connection con = DBConnection.getConnection();
        String query = "insert into branch values (?, ?, ?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, ifsc_code);
            ps.setInt(2, 1);
            ps.setString(3, branch_name);
            ps.executeUpdate();
            System.out.println("Branch created Successfully");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
