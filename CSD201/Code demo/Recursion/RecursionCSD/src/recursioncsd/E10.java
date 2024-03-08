/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

public class E10 {
    public static double addReciprocals(int n) {
        if (n == 1) {
            return 1.0;
        } else {
            return 1.0 / n + addReciprocals(n - 1); 
        }
    }

    public static void main(String[] args) {
        int number = 5;
        double result = addReciprocals(number);
        System.out.println("Sum of reciprocals up to " + number + " is " + result);
    }
}

