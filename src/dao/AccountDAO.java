package dao;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class AccountDAO {
    static Connection con = DBConnection.getConnection();

    public static boolean createAccount(int cust_id,String name, String ifsc_code, String accntType){
        int accntNo = AccountDAO.generateAccountNumber();

        String query = "INSERT into account values (?, ?, ?, ?, ?);";

        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, accntNo);
            ps.setString(2, ifsc_code);
            ps.setInt(3, cust_id);
            ps.setString(4, accntType);
            ps.setDouble(5, 0.00);
            System.out.println("Account No "+accntNo+" for Customer "+name);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isHavingAccount(int cust_id){

        String query = "select ? from account";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, cust_id);

            ResultSet rs = ps.executeQuery();
            int c=0;
            while(rs.next()){
                c++;
            }
            return c > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private static int generateAccountNumber() {
        Random rand = new Random();
        return (100000 + rand.nextInt(900000)); // Generates a 6-digit account number
    }

    public static boolean deposit(int accntNo, double amt){
        String query = "UPDATE account set bal = bal + ? where accntNo = ?";

        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setDouble(1, amt);
            ps.setInt(2, accntNo);
            if(ps.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean withdraw(int accntNo, double amt){
        String query = "UPDATE account set bal = bal - ? where accntNo = ?";
        double bal = AccountDAO.checkBal(accntNo);

            if(bal >= amt){
                try(PreparedStatement ps = con.prepareStatement(query)){
                    ps.setDouble(1, amt);
                    ps.setInt(2, accntNo);
                    if(ps.executeUpdate() > 0){
                        return true;
                    }else{
                        return false;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Insufficient Balance");
                return false;
            }
        return false;
    }

    public static double checkBal(int AccntNo){
        String query = "Select bal from account where accntNo = ?";
        double bal = 0;
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1, AccntNo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bal = rs.getDouble("bal");
            }
            return bal;
        }catch (SQLException e){
            System.out.println("Invalid Accoutn No");
            e.printStackTrace();
        }
        return 0;
    }
}
