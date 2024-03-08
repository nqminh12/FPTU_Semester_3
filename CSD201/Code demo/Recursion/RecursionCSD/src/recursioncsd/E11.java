/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;


public class E11 {
    public static int calculateStirlingNumber(int n, int k) {
        if (k == 0) {
            return (n == 0) ? 1 : 0; // Base cases: s(0,0) = 1, s(n,0) = 0 (n > 0)
        } else {
            return calculateStirlingNumber(n - 1, k - 1) - (n - 1) * calculateStirlingNumber(n - 1, k);
            // Recursive case: s(n+1,k) = s(n,k-1) - n*s(n,k)
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int stirlingNumber = calculateStirlingNumber(n, k);
        System.out.println("Stirling number S(" + n + ", " + k + ") = " + stirlingNumber);
    }
}

