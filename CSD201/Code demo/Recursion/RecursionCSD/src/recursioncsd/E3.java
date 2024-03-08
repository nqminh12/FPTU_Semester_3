/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

public class E3 {
    public static int findSum(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        return arr[n - 1] + findSum(arr, n - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7};
        int n = arr.length;
        int sum = findSum(arr, n);
        System.out.println("Sum of elements in the array is: " + sum);
    }
}

