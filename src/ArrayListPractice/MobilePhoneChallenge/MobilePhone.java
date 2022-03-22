package ArrayListPractice.MobilePhoneChallenge;

import java.util.ArrayList;
import java.util.Scanner;


public class MobilePhone {
    public static Scanner scanner = new Scanner(System.in);
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        //initialize array list for each instance.
        this.myContacts = new ArrayList<Contact>();
    }

    //methods

    //check if contact was added successfully
    //parameters are contact objects
    public  boolean addNewContact(Contact contact){
        //check for contact
        //using method to find if contact exists.
        if (findContact(contact) >= 0){
            System.out.println("Contact is already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public  boolean updateContact(Contact oldContact, Contact newContact){
        //start using more functions.
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.printf("%s was not found. ", oldContact.getName());
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.printf("%s was replaced with %s!", oldContact.getName(), newContact.getName());
        return true;
    }

    public void printContacts(){
        System.out.println("Contact List: ");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                            this.myContacts.get(i).getName() + " --> " +
                            this.myContacts.get(i).getPhoneNumber());
        }
    }

    public  boolean  removeContact(Contact contact){
        int foundPositon = findContact(contact);
        if(findContact(contact) < 0){
            System.out.println("Contact not found in list.");
            return false;
        }
        this.myContacts.remove(foundPositon);
        System.out.printf("%s was deleted", contact.getName());
        return true;
    }


    private int findContact(Contact contact){
        //return THIS instance of indexing.
        return this.myContacts.indexOf(contact);
    }

    //overload method to find strings.
    private int findContact(String name) {
        //loop through array list.
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(name)) {
                //if match is found return index position.
                return i;
            }
        }
        //return -1 if no match is found.
        return -1;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }
    public  String queryContact(Contact contact){
    if(findContact(contact) >= 0 ){
        return contact.getName();
    }
    return null;
    }
}
