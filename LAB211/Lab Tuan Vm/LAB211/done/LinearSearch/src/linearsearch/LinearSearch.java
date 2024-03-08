/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class LinearSearch {

    public static void main(String[] args) {
        //1. Users input the number of array
        int size_array = inputNumber("Enter number of array: ");
        //2. Users input search number
        int search_number = inputNumber("Enter sreach value: ");
        //3. Generate random integer in number range input
        int[] array = generateRandomArray(size_array);
        //4. Display the array 
        displayArray(array);
        //5. Display index
        displayIndex(array, search_number);
    }

    private static int inputNumber(String noti) {
        Scanner sc = new Scanner(System.in);
        double number;
        String input;
        do {
            System.out.println(noti);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input empty! Please enter a number");
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
                System.out.println("Iput can not a string! Please enter a number");
            } catch (OutOfMemoryError NegaNumber) {
                System.out.println("Input could not be less than zero! Please enter a number");
            } catch (Exception RealNumber) {
                System.out.println("Input could not be real number! Please enter a number");
            }
        } while (true);
        return (int) number;
    }

    private static int[] generateRandomArray(int size_array) {
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
        System.out.print("The array: ");
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

    private static void displayIndex(int[] array, int search_number) {
        boolean check = false;
        // access element in loop form first to last
        for (int i = 0; i < array.length; i++) {
            // check first element value in aray equal search value
            if (array[i] == search_number) {
                System.out.println("Found " + search_number + " at index: " + i);
                check = true;
                break;
            }
        }
        // do if no element in aray equal search value
        if (check == false) {
            System.out.println("Not found " + search_number + " in array");
        }
    }
}
