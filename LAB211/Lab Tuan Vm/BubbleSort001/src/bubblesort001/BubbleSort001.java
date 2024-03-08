/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bubblesort001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BubbleSort001 {

    /**
     * @param args the command line arguments
     */
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Step1: Enter a positive decimal number
        int positiveDecNum = enterPositveDecNum();
        //Step2: Generate random integer in number range for each array element
        ArrayList<Integer> array = genArray(positiveDecNum);
        //array = inputArrayCheck();
        //Step3: Display array before sorting
        displayArray("Unsorted array: [", array);
        //Step4: Sort
        boolean check = false;
        //check = true;
        bubleSort(array, check);
        //Step5: Display array after sorting
        displayArray("Sorted array: [", array);

    }

    private static int enterPositveDecNum() {
        String num;
        int n;
        //loop until input follow the requirement
        while (true) {
            try {
                System.out.println("Enter number of array: ");
                num = sc.nextLine();
                //check input is empty
                if (num.isEmpty()) {
                    throw new Exception("Input cannot be empty");
                }
                n = Integer.parseInt(num);
                //check input equal or smaller than 0
                if (n <= 0) {
                    throw new Exception("Number of array must be a positive decimal number");
                }
                break;
                //check input is not number
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
                //Display massage if input is satisfied exception 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }

    private static ArrayList<Integer> genArray(int positiveDecNum) {
        ArrayList<Integer> array = new ArrayList<>();
        //loop for first element to last element
        for (int i = 0; i < positiveDecNum; i++) {
            array.add((int) ((Math.random()) * positiveDecNum));
        }
        return array;
    }

    private static ArrayList<Integer> inputArrayCheck() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(1);
        array.add(12);
        array.add(-5);
        array.add(16);
        return array;

    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private static void bubleSort(ArrayList<Integer> array, boolean check) {
        //loop for first element to last element
        for (int i = 0; i < array.size(); i++) {
            //Loop from first element to last element unsorted
            for (int j = 0; j < array.size() - i - 1; j++) {
                //Compare each pair of adjacent elements
                if (array.get(j) > array.get(j + 1)) {
                    // check algorithm
                    if(check){
                    displayArray("[", array);
                    System.out.println(" " + array.get(j) + " > " + array.get(j+1) + ", swap");
                    }
                    swap(array, j, j + 1);
                }
                else{
                    // check algorithm
                    if(check){
                    displayArray("[", array);
                    System.out.println(" " + array.get(j) + " < " + array.get(j+1) + ", ok");
                    }
                }
            }
        }

    }

    private static void displayArray(String s, ArrayList<Integer> array) {
        System.out.print(s);
        //loop for first element to last element
        for (int i = 0; i < array.size(); i++) {
            //check current element is not last element
            if (i != array.size() - 1) {
                System.out.print(array.get(i) + ", ");
                //current element is last element
            } else {
                System.out.print(array.get(array.size() - 1) + "]");
            }
        }
        if (s.equals("Unsorted array: [")) {
            System.out.println();
        }

    }

}
