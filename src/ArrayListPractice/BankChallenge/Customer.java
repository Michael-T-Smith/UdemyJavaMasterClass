package ArrayListPractice.BankChallenge;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name, double initialTransaction) {
        this.name = name;
        //all fields get intiialized in constructor.
        this.transactions = new ArrayList<Double>();
        //use below method to initialize first transaction.
        addTransaction(initialTransaction);
    }


    //getters
    public String getName() {
        return this. name;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    //methods
    public  void addTransaction(double amount){
        System.out.println("Adding " + amount + " to balance");
        this.transactions.add(amount); //autoboxing, Java auto converts double to Double in this case.
    }

}
