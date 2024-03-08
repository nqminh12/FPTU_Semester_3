/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

public class E5 {
    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Target not found
        }
        
        int mid = (low + high) / 2;
        
        if (arr[mid] == target) {
            return mid; // Target found at index mid
        } else if (arr[mid] < target) {
            // Target is in the right half of the array
            return binarySearch(arr, target, mid + 1, high);
        } else {
            // Target is in the left half of the array
            return binarySearch(arr, target, low, mid - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int low = 0;
        int high = arr.length - 1;
        
        int index = binarySearch(arr, target, low, high);
        if (index != -1) {
            System.out.println("Target " + target + " found at index " + index);
        } else {
            System.out.println("Target " + target + " not found in the array");
        }
    }
}

