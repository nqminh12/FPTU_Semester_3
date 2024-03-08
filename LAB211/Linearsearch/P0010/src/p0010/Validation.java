/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0010;

import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    public static int getInt(int min, int max)
    {
        int n;
        while(true)
        {
            try{
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
}
