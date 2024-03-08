
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    private static boolean test = true;

    public static void main(String[] args) {
//        1. Check user input
        int size_array = inputPositiveDecimalNumber();
//        2. Create Random array from user input
        int[] array = generateRandomArray(size_array);
//        int[] array = {5, 1, 12, -5, 16};
//        3. Display Array (Unsorted)
        displayArray(array, "Unsorted array: ");
//        4. Sort the array using Bubble Sort
        bubbleSort(array, test);
//        5. Display Array (Sorted)
        displayArray(array, "Sorted array: ");
    }

    private static int inputPositiveDecimalNumber() {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.println("Enter number of array: ");
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input empty! Please enter a positive decimal number!");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                // check if input is negative number
                if (size_array <= 0) {
                    throw new InputMismatchException();
                }
                // check if input is a real number
                if ((int) size_array != size_array) {
                    throw new Exception();
                }
                // check input value is too large
                if (size_array > 100) {
                    throw new Error();
                }
                // check if number is a posituve integer number, break loop
                if (size_array > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Iput can not a string! Please enter a positive decimal number!");
            } catch (InputMismatchException NegaNumber) {
                System.out.println("Input could not be less than zero! Please enter a positive integer number");
            } catch (Exception RealNumber) {
                System.out.println("Input could not be real number! Please enter a positive integer number");
            } catch (Error RealNumber) {
                System.out.println("Input value could not greater 100! Please enter a positive integer number less 500");
            }
        } while (true);
        return (int) size_array;
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

    private static void displayArray(int[] array, String msg) {
        int count = 0;
        System.out.print(msg);
        System.out.print("[");
//        loop to access each element in the array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            count++;
            if (count == array.length) {
                break;
            }
            System.out.print(", ");
        }

        if (msg.equals("Unsorted array: ")) {
            System.out.println("]");
        } else {
            System.out.print("]");
        }
    }

    private static void bubbleSort(int[] array, boolean test) {
        /*Loop use to accessed from the first to last element of array, 
        after each loop, one element is sorted*/
        for (int i = 0; i < array.length; i++) {
            /*Loop use to accessed first unsorted element to the element 
            stand before the last unsorted element*/
            for (int j = 0; j < array.length - i - 1; j++) {
                //compare each pair adjacent elements
                if (array[j] > array[j + 1]) {
                    if (test == true) {
                        displayArray(array, "");
                        System.out.println("    " + array[j] + " > " + array[j + 1] + ", " + "swap");
                    }
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else if (test == true) {
                    displayArray(array, "");
                    System.out.println("    " + array[j] + " < " + array[j + 1] + ", " + "swap");
                }
            }
        }
    }
}
