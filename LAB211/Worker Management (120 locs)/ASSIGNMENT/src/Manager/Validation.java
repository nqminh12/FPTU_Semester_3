/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Object.Student;
import java.util.List;
import java.util.Scanner;
import javafx.beans.binding.Bindings;

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
    
    public static String getSex(String msg, String err){
        String s;
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(s.equals("Nam") || s.equals("Nu"))
            {
               break;
            }
            System.err.println(err);
        }
        return s;
    }
    
    public static String getCode(String msg, String err, List<Student> slist, int mode)
    {
        String s;
        while(true){
            System.out.println(msg);
            s = sc.nextLine();
            if(!s.isEmpty()){
                if((mode == 1 && getStudent(slist, s) == null) || (mode == 2 && getStudent(slist, s) != null))
                {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }
    
    public static Student getStudent(List<Student> slist, String id)
    {
        for(Student o: slist)
        {
            if(o.getId().equals(id))
            {
                return o;
            }
        }
        return null;
    }

}
