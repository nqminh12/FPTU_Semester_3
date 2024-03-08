/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.List;
import java.util.Scanner;
import object.Worker;

/**
 *
 * @author Fpt
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
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
    
    public static double getDouble(String msg, double min, double max)
    {
        double n;
        while(true)
        {
            try{
                System.out.print(msg);
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
    
    public static  String getCode(String msg, String err, List<Worker> wlist, int mode ){
        String s;
        while(true){
            System.out.print(msg);
            s = sc.nextLine();
//            MODE:
//            1: input - id not exist
//            2: update - id must exist
            if(!s.isEmpty()){
                if((mode == 1 && getWorker(s, wlist) == null) || (mode == 2 && getWorker(s, wlist) != null))
                {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }
    
    public static Worker getWorker(String id, List<Worker> wlist){
        for(Worker o : wlist)
        {
            if(o.getId().equals(id))
            {
                return o;
            }
        }
        return null;
    }
    
    
}
