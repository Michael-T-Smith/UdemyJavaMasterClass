package ArrayPractice;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        referenceArray();
    }

    //notes
    public static void referenceArray(){
        //Arrays are Reference types.
        //References are created with the 'new' keyword.

        //myArray is a reference to the java array object.
        int[] myArray = new int[5];

        //another reference pointing to same java array object. they both hold the same address.
        int[] anotherArray = myArray;

        System.out.println("my array is: " + Arrays.toString(myArray));
        System.out.println("another array is: " + Arrays.toString(anotherArray));

        //changing the same refernce changes all instances of that reference.
        // only changing anotherArray will also change myArray because they have the same address.
        anotherArray[0] = 1;

        System.out.println("after change - my array is: " + Arrays.toString(myArray));
        System.out.println("after change - another array is: " + Arrays.toString(anotherArray));

        //both arrays are pointed to the same reference of java object therefore both arrays can change and view the original object.


        //in-depth explanation for why.
        /*
        * When a new array is initialized int[] myArray = new int[5] Java creates a new array in memory initialized with 0's.
        * myArray points to that saved object.
        * When int[] anotherArray = myArray, anotherArray points to the same object, it has the same abilities as myArray for
        * viewing and changing the saved object.
          */


        //How to change the size of an int[] array in java.
        //Initialize array
        int[] baseArray = new int[10];

        //copy array data
        int[] copy = baseArray;

        //change original reference to new reference with larger size.
         baseArray = new int[12];

         //add contents from old reference
        for (int i = 0; i < copy.length; i++) {
            baseArray[i] = copy[i];
        }
        //Everything in the heap that goes unused, will eventually be deleted by the garbage collector inside Java.
        //For example, copy has served its purpose, if the function is not ran again the copy object will be deleted automatically.
    }
}
