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
    public static double check(){
        Scanner sc = new Scanner(System.in);
        double n;
        while (true) {            
            try {
                n = Double.parseDouble(sc.nextLine());
                if(n < 0){
                    System.out.println("Re-input: ");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Re-input: ");
            }
        }
    }
}
