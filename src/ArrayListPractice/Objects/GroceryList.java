package ArrayListPractice.Objects;

import java.util.ArrayList;


//Array list is an object inherited from the java.lang.object > java.util.AbstractCollection<E> > java.util.abstractList<E> class.
public class GroceryList {
    //intialize list ArrayList<E>, the <E> stands for Element type. Elements are Java wrapper classes.
    //Java wrappers include: String, Byte, Short, Integer, Long, Float, Double, Boolean, Character
    //because everything in Java is an object it requires being constructed.
    private ArrayList<String> groceryList = new ArrayList<String>(); //<-- constructor for ArrayList, meaning ArrayList has methods.

    //Methods
    public void addGroceryItem(String item) {
        //add method for ArrayList.
        groceryList.add(item);
    }


    //iterate through ArrayList
    public void printGroceryList() {
        System.out.printf("You have %s %s in your grocery list. \n", groceryList.size(), checkPlural(groceryList));
        for (int i = 0; i < groceryList.size(); i++) {
            //use get method to retrieve info from array list.
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    //change item in list.
    public void modifyGroceryList(int position, String newItem) {
        //set method takes a position and a value to replace item.
        groceryList.set(position, newItem);
        System.out.printf("Grocery Item %s has been modified \n", position+1);
    }

    //remove items in list.
    public void removeGroceryItem(int position){
        String theItem = groceryList.get(position - 1);
        //remove based on position. ArrayList will remove and shift items.
        groceryList.remove(position - 1);
        System.out.printf("%s has been removed \n", theItem);
    }

    //find item in list.
    //its best to let the library class do the hard coding. A.K.A. USE CLASS FUNCTIONS FOR EASE, quit trying to rewrite code already made.
    public String findItem(String searchItem){
        //contains is a method to search through the list for you. Development is about creating the product not doing it all yourself.
        boolean exists = groceryList.contains(searchItem);

        //another way to search.
        //indexOf will find index of item if it exists.
        int position = groceryList.indexOf(searchItem);
        if(position >= 0){
            return groceryList.get(position);
        }
        return null;
    }


    // incredible way of checking for proper grammar in list cart.
    public static String checkPlural(ArrayList<String> list){
        if(list.size() > 1){
            return "items";
        } else {
            return "item";
        }
    }

}
