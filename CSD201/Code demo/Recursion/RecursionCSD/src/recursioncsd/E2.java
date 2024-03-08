/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

public class E2 {
    public static int findMin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        int min = findMin(arr, n - 1);
        return Math.min(min, arr[n - 1]);
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 3, 9, 1, 7};
        int n = arr.length;
        int minElement = findMin(arr, n);
        System.out.println("Minimum element in the array is: " + minElement);
    }
}

