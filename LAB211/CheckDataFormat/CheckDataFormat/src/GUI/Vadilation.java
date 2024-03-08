/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Vadilation {
    
    public static  Scanner sc = new Scanner(System.in);
    public static String inputYN() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N):");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("Y")){
                return choice;
            }else{
                System.out.println("Please input Y or N");
            }
        }
    }
    
    public static int getInt(String msg, int min, int max)
    {
        int n;
        while(true)
        {
            try{
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if(min <= n && n <= max) break;                                                 
                throw new NumberFormatException();
            }catch(NumberFormatException ex)
            {
                System.out.println("Please enter an integer number in range: " + min + "->" + max);
            }
        }
        return n;
    }
    
    public static double getDouble(double min, double max)
    {
        double n;
        while(true)
        {
            try{
            
                n = Double.parseDouble(sc.nextLine());
                if(min <= n && n <= max) break;
                throw new NumberFormatException();
            }catch(NumberFormatException ex)
            {
                System.out.println("Please enter an real number in range: " + min + "->" + max);
            }
        }
        return n;
    } 
    
}
