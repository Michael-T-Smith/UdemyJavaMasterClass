package ArrayListPractice.MobilePhoneChallenge;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone myPhone = new MobilePhone("2563433517");
    public static void main(String[] args) {
       boolean quit = false;
       startPhone();
       printActions();
       while(!quit){
           System.out.println("\n Enter action: (6 to show available actions");
           int action = scanner.nextInt();
           scanner.nextLine();
           switch(action){
               case 0:
                   System.out.println("\n Shutting down...");
                   quit = true;
                   break;
               case 1:
                   myPhone.printContacts();
                   break;
               case 2:
                   addNewContact();
                   break;
               case 3:
                   updateContact();
                   break;
               case 4:
                   removeContact();
                   break;
               case 5:
                   queryContact();
                   break;
               case 6:
                   printActions();
                   break;
           }
       }

    }

    public static void removeContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = myPhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        if (myPhone.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    public static void queryContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contact existingContactRecord = myPhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.printf("\nName: %s \nPhone Number: ", existingContactRecord.getName(), existingContactRecord.getPhoneNumber());
    }

    public static void updateContact() {
        System.out.printf("Enter existing contact name: ");
        String name = scanner.nextLine();
        myPhone.queryContact(name);
        Contact existingContactRecord = myPhone.queryContact(name);
        if(existingContactRecord == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (myPhone.updateContact(existingContactRecord, newContact)){
            System.out.println("Successfully updated contact");
        } else {
            System.out.println("Error updating contact.");
        }
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        String phone = scanner.nextLine();
        //create new contact with given name and phone.
        Contact newContact = Contact.createContact(name, phone);
        if(myPhone.addNewContact(newContact)){
            System.out.printf("New contact added: Name: %s, phone: %s", name, phone);
        } else {
            System.out.printf("Cannot add %s, already on file", name);
        }
    }

    private static void startPhone(){
        System.out.println("Staring phone....");
    }

    private static void printActions(){
        System.out.println("\n Available actions: \npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if contact exists\n" +
                "6 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }


}
