/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;

            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

    public static int getValue(String msg, int min, int max) {
        System.out.println(msg);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println("Input must in range [" + min + " -> " + max + "]");
                    continue;
                } else return n;

            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }
    public static int getSize(String msg){
        System.out.println(msg);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.err.println("Must be greater than 0");
                    continue;
                } else return n;

            } catch (NumberFormatException e) {
                System.err.println("Re-input");
            }
        }
    }

}
