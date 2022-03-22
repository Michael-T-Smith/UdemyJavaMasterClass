package ArrayListPractice.MobilePhoneChallenge;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String number) {
        this.name = name;
        this.phoneNumber = number;
    }


    //methods
    //making this constructor static gives the ability to create a "factory" method where we
    //create a new object without actually creating a new object.
    public static Contact createContact(String name, String number){
        return new Contact(name, number);
    }



    //getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
