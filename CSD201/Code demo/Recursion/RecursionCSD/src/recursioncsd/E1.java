/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

import java.util.Scanner;



public class E1 {
    public static Scanner sc = new Scanner(System.in);
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }
    
    public static void main(String[] args) {
        int n =sc.nextInt();
        int result = sum(n);
        System.out.println("Sum of numbers from 1 to " + n + " is: " + result);
    }
}

