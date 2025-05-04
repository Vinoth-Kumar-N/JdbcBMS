package model;

public class Customer {
    private int cust_id;
    private String cust_name;
    private String ifsc_code;
    private String email;
    private String pass;

    Customer(int cust_id, String cust_name, String ifsc_code, String email, String pass){
        this.cust_id = cust_id;
        this.cust_name =cust_name;
        this.ifsc_code = ifsc_code;
        this.email = email;
        this.pass = pass;
    }

    public int getCust_id() {
        return cust_id;
    }
    public String getCust_name() {
        return cust_name;
    }
    public String getEmail() {
        return email;
    }
    public String getIfsc_code() {
        return ifsc_code;
    }
}
