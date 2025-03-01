package model;

public class Bank {
    int bank_id;
    String bank_name;
    int no_of_branches;
    String address;

    Bank(int bank_id, String bank_name, int no_of_branches, String address){
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.no_of_branches = no_of_branches;
        this.address = address;
    }
}
