/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Object.Fruit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validation {
    private static final Scanner sc = new Scanner(System.in);
    
    //tạo ra 3 cái method nhập string, nhập int, nhap double
    
    public static String getString(String msg){
        System.out.println(msg);
        while (true) {            
            String s = sc.nextLine().trim();
            if(s.isEmpty()){
                System.err.println("Not allow input empty string! Please input again!");
                continue;
            }
            return s;
            
        }
    }
    
    public static int getInt(String msg, int min, int max){
        System.out.println(msg);
        while (true) {            
            try {
                String s = sc.nextLine().trim();
                int n = Integer.parseInt(s);
                if(n < min || n > max){
                    System.err.println("Must be from " + min + " to " + max + "! Please input again");
                    continue;   
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Must be number! Please input again");
            }
        }
    }
    
    public static double getDouble(String msg, double min, double max){
        System.out.println(msg);
        while (true) {            
            try {
                String s = sc.nextLine().trim();
                double n = Double.parseDouble(s);
                if(n < min || n > max){
                    System.err.println("Must be from " + min + " to " + max + "! Please input again");
                    continue;   
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Must be number! Please input again");
            }
        }
    }
    
    public static String getYN(String msg){
        System.out.println(msg);
        while (true) {            
            String s = sc.nextLine().trim();
            if(s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N")){
                return s;
            } else {
                System.err.println("Input Y or N please!");
                continue;
            }
        }
    }
    
    public static String getID(String msg, ArrayList<Fruit> listFruit){
        System.out.println(msg);
        while (true) {            
            String s = sc.nextLine().trim();
            if(check(s, listFruit) == null){
                return s;
            } else {
                System.err.println("Please input id again!");
                continue;
            }
        }
    }
        
    public static Fruit check(String id, ArrayList<Fruit> listFruit){
        for (Fruit o : listFruit) {
            if(id.equals(o.getId())){
                return o;
            }
        }
        return null;
    }
}
