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
    public static double check(){
        double n;
        while (true) {            
            try {
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Re-input");
            }
        }
    }
}
