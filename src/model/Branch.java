package model;

public class Branch {
    int ifsc_code;
    int bank_id;
    String branch_name;
    public Branch(int ifsc_code, String branch_name, int bank_id){
        this.ifsc_code = ifsc_code;
        this.branch_name = branch_name;
        this.bank_id = bank_id;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_id=" + ifsc_code +
                ", branch_name='" + branch_name + '\'' +
                ", bank_id=" + bank_id +
                '}';
    }

}
