package ArrayListPractice.BankChallenge;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Jefferson Bank");

        bank.addBranch("Adelaide");

        bank.addCustomer("Adelaide", "Michael", 30.00);

        bank.addCustomer("Adelaide", "Henry", 450.00);



        bank.listCusomters("Adelaide", true);
    }
}
