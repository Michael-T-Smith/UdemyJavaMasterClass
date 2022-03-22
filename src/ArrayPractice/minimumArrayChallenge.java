package ArrayPractice;


//find minimum in array of integers with standard array.

import java.util.Scanner;
public class minimumArrayChallenge {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter number of elements in array: \r");
        int count = scanner.nextInt();
        System.out.println(findMin(readIntegers(count)));
    }

    public static int[] readIntegers(int num){
        System.out.println("Enter values for array: ");
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int findMin(int[] array){
        //unlike javascript if we do not know the initial value set it to Integer.MAX_VALUE instead of blank;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;
    }

}
