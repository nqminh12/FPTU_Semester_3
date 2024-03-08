
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class QuickSort {

    public static boolean test = true;

    public static void main(String[] args) {
        //1. Users input the number of array
        int size_array = getNumber();
        //2. Generate random integer in number range input
        int[] array = generateArray(size_array);
        //int[] array = {1, 12, 5, 26, 7, 14, 3, 7, 2}; //test algorithm
        //3. Display unsorted array
        displayArray(array, "Unsorted array: ");
        //4. Sorted array using quick sort
        quickSort(array, 0, array.length - 1);
        //6. Display sorted array
        displayArray(array, "Sorted array: ");
    }

    private static int getNumber() {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.println("Enter number of array: ");
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input empty! Please enter a number");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                // check if number of array is negative number
                if (size_array <= 0) {
                    throw new OutOfMemoryError();
                }
                // check if number of array is a real number
                if ((int) size_array != size_array) {
                    throw new Exception();
                }
                // check if number of array is a posituve integer number, break loop
                if (size_array > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Iput can not a string! Please enter a number");
            } catch (OutOfMemoryError NegaNumber) {
                System.out.println("Input could not be less than zero! Please enter a number");
            } catch (Exception RealNumber) {
                System.out.println("Input could not be real number! Please enter a number");
            }
        } while (true);
        return (int) size_array;
    }

    private static int[] generateArray(int size_array) {
        Random rd = new Random();
        int[] array = new int[size_array];
        //Create random values in array from 0 to 99
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }

    private static void displayArray(int[] array, String noti) {
        System.out.print(noti);
        System.out.print("[");
        // access each element of aray and display them
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //Void "," at the end aray
            if (i == array.length - 1) {
                break;
            }
            System.out.print(", ");
        }
        if (noti.equals("Unsorted array: ")) {
            System.out.println("]");
        } else {
            System.out.print("]");
        }
    }

    private static void quickSort(int[] array, int low, int high) {
        // do if element in array greater than one
        if (low < high) {
            int pivotIndex = partitionArray(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex, high);
        }
    }

    private static int partitionArray(int[] array, int low, int high) {
        int pivot = array[(low + high) / 2];
        // test algorithm, display pivot value
        if (test == false) {
            displayArray(array, "");
            System.out.println("    " + "pivot value = " + pivot);
        }
        int i = low;
        int j = high;
        
        // check if 
        while (i <= j) {
            // find value greater than pivot
            while (array[i] < pivot) {
                i++;
            }
            // find value less than pivot
            while (array[j] > pivot) {
                j--;
            }
            //             
            if (i <= j) {
                // test algorithm, display sorting step
                if (test == false) {
                    displayArray(array, "");
                    System.out.println("    " + array[i] + " >= " + pivot + " >= " + array[j] + ", swap " + array[i] + " and " + array[j]);
                }
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
}
