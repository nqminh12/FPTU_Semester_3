/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static int getBase(String msg, String err){
        while(true){
            try {
                System.out.println(msg);
                String s = sc.nextLine().trim();
                int base = Integer.parseInt(s);
                if(base == 2|| base == 10 || base == 16){
                    return base;
                } else{
                    System.out.println(err);
                }
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public static String getValue(String msg,String err, int base){
        while (true) {   
            try {
                System.out.println(msg);
                String value = sc.nextLine().trim();
                switch(base){
                    case 2:
                        if(value.matches("[0-1]+")){
                            return value;
                        } else {
                            System.out.println("Invalid value!");
                        }
                        break;
                    case 10:
                        if(value.matches("[0-9]+")){
                            return value;
                        }else {
                            System.out.println("Invalid value!");
                        }
                        break;
                    case 16:
                        if(value.matches("[0-9a-fA-F]+")){
                            return value;
                        }else {
                            System.out.println("Invalid value!");
                        }
                        break;
                    default:System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);
            }
            
        }
    }
}
