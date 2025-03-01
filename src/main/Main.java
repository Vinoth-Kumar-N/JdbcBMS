package main;

import dao.*;
import database.DBConnection;
import model.Branch;

import java.sql.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("============Welcome to Banking Management System===============");
            System.out.println("1. ADMIN Login");
            System.out.println("2. EMPLOYEE Login");
            System.out.println("3. CUSTOMER login");
            System.out.println("4. EXIT");
            System.out.println("Enter Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            boolean isAdminLoggedIn = false;

            switch (ch){
                case 1:{
                    while(true){
                        if(!isAdminLoggedIn){
                            System.out.println("Enter email : ");
                            String email = sc.nextLine();
                            System.out.println("Enter Password: ");
                            String pass = sc.nextLine();

                            if(AdminDAO.authenticateEmployee(email,pass)){
                                System.out.println("Logged in Successfully");
                                isAdminLoggedIn = true;
                            }else{
                                System.out.println("Login Failed");
                            }
                        }
                        if(isAdminLoggedIn){
                            System.out.println("============Welcome to Banking Management System===============");
                            System.out.println("1. create Branch");
                            System.out.println("2. create Employee");
                            System.out.println("3. EXIT");
                            System.out.println("Enter Choice: ");
                            int cho = sc.nextInt();
                            sc.nextLine();
                            switch (cho){
                                case 1:{
                                    System.out.print("Enter Branch IFSC code: ");
                                    String Bifsc = sc.nextLine();
                                    System.out.print("Enter Branch Name: ");
                                    String branch_name = sc.nextLine();
                                    bankDAO.createBranch(Bifsc, branch_name);
                                }
                                case 2:{
                                    System.out.print("Enter Employee ID: ");
                                    int emp_id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Name: ");
                                    String emp = sc.nextLine();
                                    System.out.print("Enter Branch IFSC code: ");
                                    String Bifsc = sc.nextLine();
                                    System.out.print("Enter Emp email: ");
                                    String email = sc.nextLine();
                                    System.out.print("Enter Emp Password: ");
                                    String pass = sc.nextLine();
                                    System.out.print("Enter Salary: ");
                                    double sal = sc.nextDouble();
                                    AdminDAO.createEmployee(emp_id, emp, Bifsc, email, pass, sal);
                                    break;
                                }
                                case 3:{
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
                case 2:{
                    boolean isEmployeeLoggedIn = false;
                    while(true) {
                        if (!isEmployeeLoggedIn) {
                            System.out.println("Enter email : ");
                            String email = sc.nextLine();
                            System.out.println("Enter Password: ");
                            String pass = sc.nextLine();
                            if(AdminDAO.authenticateEmployee(email, pass)) {
                                System.out.println("Logged in Successfully");
                                isEmployeeLoggedIn = true;
                            }
                        }
                        else if(isEmployeeLoggedIn){
                            System.out.println("1. create customer Account");
                            System.out.println("3. EXIT");
                            System.out.println("Enter Choice: ");
                            int choi = sc.nextInt();
                            sc.nextLine();

                            switch (choi) {
                                case 1: {
                                    System.out.println("Enter cust_id: ");
                                    int cust_id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Customer Name: ");
                                    String cust_name = sc.nextLine();
                                    System.out.print("Enter Branch Ifsc: ");
                                    String ifsc = sc.nextLine();
                                    System.out.print("Enter Customer email: ");
                                    String email = sc.nextLine();
                                    System.out.print("Enter Customer Pass: ");
                                    String pass = sc.nextLine();
                                    System.out.print("Enter Account type: ");
                                    String accntType = sc.nextLine();
                                    EmployeeDAO.createCustomer(cust_id, cust_name, ifsc, email, pass, accntType);
                                    break;
                                }
                                case 3:{
                                    break;
                                }
                                default:{
                                    System.out.println("Invalid Choice");
                                    break;
                                }
                            }
                        }else{
                            System.out.println("Employee Login failed");
                        }
                    }
                }
                case 3:{
                    boolean isCustomerLoggedIn = false;
                    while(true) {
                        if (!isCustomerLoggedIn) {
                            System.out.print("Enter email : ");
                            String email = sc.nextLine();
                            System.out.print("Enter Password: ");
                            String pass = sc.nextLine();
                            if (BranchDAO.authenticateCustomer(email, pass)) {
                                System.out.println("Logged in Successfully");
                                isCustomerLoggedIn = true;
                            }else{
                                System.out.println("Customer Not found");
                            }
                        } else if (isCustomerLoggedIn) {
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. EXIT");
                            System.out.println("Enter Choice: ");
                            int choi = sc.nextInt();
                            sc.nextLine();

                            switch (choi) {
                                case 1: {
                                    System.out.print("Enter Acount No: ");
                                    int AccntNo = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Amount No: ");
                                    double amt = sc.nextDouble();
                                    boolean success = AccountDAO.deposit(AccntNo, amt);
                                    if(success){
                                        System.out.println(amt+" Deposited successfully");
                                    }else{
                                        System.out.println("Not deposited, Error");
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.print("Enter Acount No: ");
                                    int AccntNo = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Enter Amount No: ");
                                    double amt = sc.nextDouble();
                                    boolean success = AccountDAO.withdraw(AccntNo, amt);
                                    if(success){
                                        System.out.println(amt+" Withdraw successfully");
                                    }else{
                                        System.out.println("Not Available, Error");
                                    }
                                }
                                case 3: {
                                    System.out.print("Enter Acount No: ");
                                    int AccntNo = sc.nextInt();
                                    sc.nextLine();
                                    double bal = AccountDAO.checkBal(AccntNo);
                                    System.out.println("Balance for Account No : "+AccntNo+" --> "+bal);
                                    break;
                                }
                                case 4: {
                                    break;
                                }
                            }
                        }else {
                            System.out.println("Customer Login failed");
                            break;
                        }
                    }
                    break;
                }
                case 4:{
                    System.exit(0);
                }
            }
        }

    }
}
