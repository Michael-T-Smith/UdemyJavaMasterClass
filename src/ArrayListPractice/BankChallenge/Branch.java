package ArrayListPractice.BankChallenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        //initialize arraylist.
        this.customers = new ArrayList<Customer>();

    }

    //getters
    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //methods
   public  boolean newCustomer(String name, double amount){
        if(findCustomer(name) == null){
            this.customers.add(new Customer(name, amount));
            return true;
        } else {
            System.out.println("Error, customer already exists.");
            return false;
        }
   }

   public boolean addCustomerTransaction(String name, double transaction){
        //if customer exists through findCustomer method, save customer.
        Customer exisitingCustomer = findCustomer(name);

        //if customer does not equal null proceed with transaction.
        if(findCustomer(name) != null){
                exisitingCustomer.addTransaction(transaction);
                return true;
        }
        return false;
    }

    //consider the scope of each method, private for class only methods.
   private Customer findCustomer(String name) {
        //cycle through list of customers.
       for (int i = 0; i < this.customers.size(); i++) {
           Customer checkedCustomer = this.customers.get(i);
           //check customers with get(i) find the name and check if it equals the provided name.
           if (checkedCustomer.getName().equals(name)) {
               //return the customer object at index.
               return checkedCustomer;
           }
       }
       //can not provide customer if none exist. return null.
        return null;
    }
}

