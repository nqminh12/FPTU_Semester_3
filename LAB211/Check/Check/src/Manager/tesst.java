/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class tesst {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        de2Bai1();
    }
    
    
    public static void de1Bai1(){
        
        String str = sc.nextLine();
        String[] arr = str.split("\\|"); // 12 , 3 , 4 , 6 , 1
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(arr[i].trim());
        }
        System.out.println(sum);
        
    }
    
    public static void de1Bai2(){
        int[] str = {1,2,3,4,5,6,7,8,9,0};
        int[] arr = new int[1000];
        int count = 0;
        
        // duyet qua mang ban dau neu là phan tu chan thi se add phan tu chan vao mảng mới 
        for (int i = 0; i < str.length; i++) {
            if(str[i] % 2 == 0){
                arr[count] = str[i];  // arr[0] = 2; arr[1] = 4; arr[2] = 6; arr[3] = 8; arr[4] = 0
                count++;
            }
        }
        
        
        // duyet qua mang de in ra
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
        
    }
    
    public static void de2Bai1(){
        HashMap<Character, Integer> table = new HashMap<>();
        
        String str = "abc axy";
        
        for (int i = 0; i < str.length(); i++) {
            
            if(Character.isSpaceChar(str.charAt(i))){
                continue;
            }
            
            if(!table.containsKey(str.charAt(i))){
                table.put(str.charAt(i), 1);
            }else{
                table.put(str.charAt(i), ((int)table.get(str.charAt(i)) + 1));
            }
            
            
        }
        
        
        
        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            
            System.out.println(key + ":" + value);
            
        }
        
    }
    
    
    
    
    
}
