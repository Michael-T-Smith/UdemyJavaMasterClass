package LinkedList.Practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        visit(initializeLinkedList());
    }


    public static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();
        boolean goingForward = true;
        //check if  list is empty with the list method isEmpty();
        if(cities.isEmpty()){
            System.out.println("No cities in the itinerary");
            return;
        }else {
            System.out.printf("Now visiting %s", listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Holiday is over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.printf("Now visiting %s %n", listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                        if(listIterator.hasPrevious()){
                        //There is a linkedList bug here, the previous displays the same value twice.
                        //next() and previous() do not hold values only hover between elements.
                        //so going next() and then previous() means you never left the in-between spot.
                            //boolean goingForward was added to track direction flow in linkedList.
                        System.out.printf("Now visiting %s", listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: \n press ");
        System.out.println(
                        "0 - to quit\n " +
                        "1 - to go to next city\n " +
                        "2 - to go to previous city\n " +
                        "3 - print menu options\n "
                     );
    }

    private static LinkedList<String> initializeLinkedList(){
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        return placesToVisit;
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                System.out.printf("%s is already included as a destination %n" , newCity);
                return false;
            } else if(comparison > 0){
                //.next() was used for the comparison so Java has internally moved to the next list entry. we must go back to current entry.
            //List iterator can go backwards using .previous();
            stringListIterator.previous();
            stringListIterator.add(newCity);
            return true;
            } else if (comparison < 0) {
                //move on to next city. which was done at the .next();
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    public static void linkedListExample(){
        LinkedList<String> placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);
        //Linked list do not have to reorganize list to add another entry unlike arrayList that has to shift all data by one every time.
        placesToVisit.add(1, "Alice Springs");
        printList(placesToVisit);
        //Use linked list when large data is involved.
        placesToVisit.remove(4);
        printList(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList){
        //iterator is another way of traversing lists, equivalent of a for loop.
        Iterator<String>  i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("==========END========");
    }

    public void arrayListExample(){
        Customer customer = new Customer("Michael", 54.96);
        Customer anotherCustomer = customer;

        //this will edit both customer and anotherCustomer.  Did not create new instance for anotherCustomer only used same pointer.
        anotherCustomer.setBalance(12.18);
//        System.out.printf("Balance for customer %s is %s", customer.getName(), customer.getBalance());

        //ArrayList moves data down to make room for inserted data, or up to fill gap of removed data.
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);
        for (int i = 0; i < intList.size(); i++) {
            System.out.printf("%s: %s %n", i, intList.get(i));
        }
        intList.add(1,2);
        for (int i = 0; i < intList.size(); i++) {
            System.out.printf("%s: %s %n", i, intList.get(i));
        }
    }
}
