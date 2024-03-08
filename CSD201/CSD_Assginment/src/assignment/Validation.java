/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg, int min, int max){
        System.out.println(msg);
        int n;
        while(true){
            try {
                n = Integer.parseInt(sc.nextLine());
                if(n < min || n > max){
                    System.err.println("Please inpit[" + min + " -> " + max + "]");
                    continue;
                }else break;
            } catch (NumberFormatException e) {
                System.err.println("Must be number, please input again");
            }
        }
        return n;
    }
    
    public static double getDouble(String msg, double min, double max){
        System.out.println(msg);
        double n;
        while(true){
            try {
                n = Double.parseDouble(sc.nextLine());
                if(n < min || n > max){
                    System.err.println("Please inpit[" + min + " -> " + max + "]");
                    continue;
                }else break;
            } catch (NumberFormatException e) {
                System.err.println("Must be number, please input again");
            }
        }
        return n;
    }
}
