/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0010;

/**
 *
 * @author Fpt
 */
import java.util.Scanner;
import java.util.Random;

public class P0010 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of the array: ");
        int len = Validation.getInt(0, Integer.MAX_VALUE);
        
        
        System.out.println("Enter search value: ");
        int search = Validation.getInt(0, Integer.MAX_VALUE);;
        
        int[] array = new int[len];
        for(int i = 0 ; i < len; i++){
            array[i] = new Random().nextInt(len);
        }
        
        P0010 pr = new P0010();
        pr.display(array);
        int found = pr.search(array, search);
        System.out.println("\nFound " + search + " at index: " + found);
        
        
    }
    
    public void display(int[] array){
        System.out.print("[");
        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
   
    public int search(int[] arr, int key){
        int size = arr.length;
        for(int i = 0; i < size; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
}
