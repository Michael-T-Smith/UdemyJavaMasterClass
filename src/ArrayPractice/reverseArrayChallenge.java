package ArrayPractice;

import java.util.Arrays;
import java.util.Scanner;

public class reverseArrayChallenge {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many array elements?");
        int count = scanner.nextInt();
        System.out.println(Arrays.toString(reverseArray(makeArray(count))));
    }

    public static int[] makeArray(int num){
        int[] array = new int[num];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] reverseArray(int[] array){
        int[] temp = new int[array.length];
        int counter = 0;
        for (int i = array.length - 1; i >= 0; i--){
            //count up in temp while counting down in array;
            temp[counter++] = array[i];
        }
        return temp;
    }
}
