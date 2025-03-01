package model;
import model.Account;

public class SavingAccount extends Account{
    static double intrestRate = 7.5;
    SavingAccount(int accntNo, int cust_id, String ifsc_code, String accntType, double bal){
        super(accntNo, cust_id,ifsc_code, accntType, bal);
    }

    public void deposit(double amt){
        this.bal = this.bal + amt;
    }

    public double withDraw(double amt){
        if(this.bal >= amt){
            this.bal = this.bal - amt;
        }else{
            System.out.println("Insufficient Balance");
        }
        return bal;
    }
}
