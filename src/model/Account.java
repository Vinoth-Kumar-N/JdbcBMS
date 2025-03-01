package model;

public abstract class Account {
    int accntNo;
    int cust_id;
    String ifsc_code;
    String accntType;
    double bal;

    Account(int accntNo, int cust_id,String ifsc_code, String accntType, double bal){
        this.accntNo = accntNo;
        this.cust_id = cust_id;
        this.ifsc_code = ifsc_code;
        this.accntType = accntType;
        this.bal = bal;
    }

    abstract public void deposit(double amt);
    abstract public double withDraw(double amt);
}
