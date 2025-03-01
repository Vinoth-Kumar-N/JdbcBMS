package model;

public class Employee {
    int emp_id;
    String emp_name;
    int ifsc_code;
    String email;
    String pass;
    double empSalary;
    Employee(int emp_id, String emp_name, String email, String pass, int ifsc_code, double empSalary){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.email = email;
        this.pass = pass;
        this.ifsc_code = ifsc_code;
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +emp_name+" , "+emp_name+" , "+ifsc_code+" , "+empSalary+" }";
    }
}
