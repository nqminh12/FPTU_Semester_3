/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

public class E9 {
    public static int fib(int n) {
        if (n <= 1) {
            return n; // Base case: Fibonacci of 0 is 0, Fibonacci of 1 is 1
        } else {
            return fib(n - 1) + fib(n - 2); // Recursive case: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
        }
    }

    public static void main(String[] args) {
        int number = 7;
        int result = fib(number);
        System.out.println("Fibonacci of " + number + " is " + result);
    }
}

