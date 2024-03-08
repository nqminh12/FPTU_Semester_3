/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class BinarySearchTree {

    public static boolean test = false;

    public static void main(String[] args) {
        //1. Users input a positive decimal number
        int size_array = inputNumber("Enter number of array: ");
        //2. Enter a search number
        int search_number = inputNumber("Enter sreach value: ");
        //3. Generate random integer in number range for each array element
        int[] array = generateArray(size_array);
        //int[] array = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114}; // test algorithm
        //4. Sort array and display array sorted
        Arrays.sort(array);
        displayArray(array);
        //5. Display the index of search number in array
        displayIndex(array, search_number, test);
    }

    private static int inputNumber(String noti) {
        Scanner sc = new Scanner(System.in);
        double number;
        String input;
        do {
            System.out.println(noti);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input empty! Please enter a number");
                continue;
            }
            try {
                number = Double.parseDouble(input);
                // check if number  is negative number
                if (number <= 0) {
                    throw new OutOfMemoryError();
                }
                // check if number is a real number
                if ((int) number != number) {
                    throw new Exception();
                }
                // check if number is a posituve integer number, break loop
                if (number > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Iput can not a string! Please enter a number");
            } catch (OutOfMemoryError NegaNumber) {
                System.err.println("Input could not be less than zero! Please enter a number");
            } catch (Exception RealNumber) {
                System.err.println("Input could not be real number! Please enter a number");
            }
        } while (true);
        return (int) number;
    }

    private static int[] generateArray(int size_array) {
        int[] array = new int[size_array];
        Random rd = new Random();
        //Loop use to random each element of array
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }

    private static void displayArray(int[] array) {
        int count = 0;
        System.out.print("Sorted array: ");
        System.out.print("[");
        //loop to access each element in the array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            count++;
            // void "," in last array
            if (count == array.length) {
                break;
            }
            System.out.print(", ");
        }
        System.out.println("]");
    }
    
    private static void displayStep(int[] array, int search_number, int step, int middle, String compare) {
        System.out.print("Step " + step + " ( middle element is " + array[middle] + compare + search_number + " ): ");
        //access each element in array from first to last
        for (int i = 0; i < array.length; i++) {
            //add "[" befor element is choosen middle
            if (i == middle) {
                System.out.print("[" + array[i] + "] ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("");
    }
    
    private static void displayIndex(int[] array, int search_number, boolean test) {
        int right = 0, left = array.length - 1;
        for (int step = 1; right <= left; step++) {
            int middle = (right + left) / 2;
            // check if the middle element equals to the searched value, the algorithm stops
            if (array[middle] == search_number) {
                // test algorithm, display searching step
                if (test) displayStep(array, search_number, step, middle, " == ");
                System.out.println("Found " + search_number + " at index: " + middle);
                break;
            }
            // check if searched value is less than the middle element
            else if (array[middle] > search_number) {
                left = middle - 1;
                // test algorithm, display searching step
                if (test) displayStep(array, search_number, step, middle, " > ");
            }
            // check if searched value is less than the middle element
            else {
                right = middle + 1;
                // test algorithm, display searching step
                if (test) displayStep(array, search_number, step, middle, " < ");
            }
            // if subarray has no elements
            if (right > left) {
                if(!test){
                    System.out.println("Not found!");
                } else {
                    System.out.print("Step " + ++step + " (searched value is absent): ");
                    // loops from first to last index of element
                    for (int i = 0; i < array.length; ++i)
                        System.out.print(array[i] + " ");
                    System.out.println();
                }
            }
        }
        
    }
}
