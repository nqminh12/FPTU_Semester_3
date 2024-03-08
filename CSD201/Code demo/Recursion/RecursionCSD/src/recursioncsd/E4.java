/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

public class E4 {
    public static int isPalindrome(char[] arr, int n) {
        if (n <= 1) {
            return 1;
        }
        if (arr[0] != arr[n - 1]) {
            return 0;
        }
        return isPalindrome(arr, n - 2);
    }
    
    public static void main(String[] args) {
        char[] arr = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        int n = arr.length;
        int result = isPalindrome(arr, n);
        if (result == 1) {
            System.out.println("The array is a palindrome.");
        } else {
            System.out.println("The array is not a palindrome.");
        }
    }
}

