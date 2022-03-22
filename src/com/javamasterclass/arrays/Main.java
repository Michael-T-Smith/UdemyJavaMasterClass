package com.javamasterclass.arrays;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeArray();
    }


    //descending array driver.
    public static void initializeArray(){
        System.out.println("How many numbers do you want in your list? (press enter after each entry) \r");
        int num = scanner.nextInt();
        //using function results as parameters for other functions.
        printArray(sortIntegers(getIntegers(num)));
    }

    //get a list of integers for array.
    public static int[] getIntegers(int num){
        int [] myArray = new int[num];
        System.out.printf("Enter %s numbers \n", num);
        for(int i = 0; i < num; i++ ) {
            if(scanner.hasNextInt()){
                myArray[i] = scanner.nextInt();
            }
        }
        System.out.println("Array before sorting: ");
        System.out.print("[");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.print("] \n");
        return myArray;
    }

    public static void printArray(int[] array){
        System.out.println("Array after sorting:   ");
        System.out.print("[ ");
        //common for loop
//        for(int i = 0; i < array.length; i++){
//            System.out.print(array[i] + " ");
//        }
        //enhanced for loop
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.print("]");
    }

public static int[] sortIntegers(int[] array){
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i ++){
            sortedArray[i] = array[i];
        }

        //sort array with while loop.
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            //sortedArray.length -1 to prevent IndexOutOfBounds. loop stops on last value.
            for(int i = 0; i < sortedArray.length - 1; i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    //if number is smaller, store first number, replace index with next value, replace next value with first number.
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
}
}
