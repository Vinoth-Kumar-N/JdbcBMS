package model;

public class Customer {
    int cust_id;
    String cust_name;
    String ifsc_code;
    String email;
    String pass;

    Customer(int cust_id, String cust_name, String ifsc_code, String email, String pass){
        this.cust_id = cust_id;
        this.cust_name =cust_name;
        this.ifsc_code = ifsc_code;
        this.email = email;
        this.pass = pass;
    }
}
//while(true){
//        System.out.println("============Welcome to Banking Management System===============");
//            System.out.println("1. ADMIN Login");
//            System.out.println("2. EMPLOYEE Login");
//            System.out.println("3. EXIT");
//            System.out.println("Enter Choice: ");
//int ch = sc.nextInt();
//
//boolean isAdminLoggedIn = false;
//boolean isEmployeeLoggedIn = false;
//            switch (ch){
//
//        }
//        }
