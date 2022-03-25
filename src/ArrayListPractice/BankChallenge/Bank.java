package ArrayListPractice.BankChallenge;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    //constructor
    public Bank(String name) {
        this.name = name;
        //Intialize array list like others.
        this.branches = new ArrayList<Branch>();

    }

//getters
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getName() {
        return name;
    }


    //methods
    public  boolean addBranch(String name){
        if(findBranch(name) == null){
            this.branches.add(new Branch(name));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.newCustomer(customerName, amount);
        }
        return false;
    }

    private boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    private Branch findBranch(String name){
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(name)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCusomters(String branchName, boolean printTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customer details for branch" + branch.getName() );

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: [" + (i + 1) + "] " + branchCustomer.getName());
                if(printTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println(j + 1 + ". Amount: " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
