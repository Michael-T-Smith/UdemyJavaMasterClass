package ArrayListPractice.BankChallenge;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    //constructor
    public Bank(String name, ArrayList<Branch> branches) {
        this.name = name;
        this.branches = branches;
    }

//getters
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }


    //methods
    private  void addBranch(String name){

    }

    private void addCustomer(String branch, String customer, double amount){

    }

    private void addCustomerTransaction(String branchName, String customer, double transaction){

    }

    private void findBranch(String name){

    }

    private void listCusomters(String name, boolean printTransactions){

    }


}
