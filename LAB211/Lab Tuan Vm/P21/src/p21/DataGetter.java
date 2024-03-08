/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p21;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DataGetter {
   static Scanner sc = new Scanner(System.in);

    public static String getString(String s, String REGEX) {
        String str;
        //loop until input follow the requirement
        while (true) {
            try {
                System.out.print(s);
                str = sc.nextLine();
                //check input is empty
                if (str.isEmpty()) {
                    throw new Exception("Input cannot be empty");
                }
                //check input follow format or not
                if (!str.matches(REGEX)) {
                    throw new Exception("Input must be match fomat");
                }
                break;
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return str;
    }

    public static int getOption(String s, int min, int max) {
        String num;
        int n;
        //loop until input follow the requirement
        while (true) {
            try {
                System.out.print(s);
                num = sc.nextLine().trim();
                //check input is empty
                if (num.isEmpty()) {
                    throw new Exception("Input cannot be empty");
                }
                n = Integer.parseInt(num);
                //check input is out of range
                if (n < min || n > max) {
                    throw new Exception("Your choice must be between " + min + " and " + max);
                }
                break;
                //check input is not number
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }
    
    
    public static int getInteger(String s) {
        String num;
        int n;
        //loop until input follow the requirement
        while (true) {
            try {
                System.out.print(s);
                num = sc.nextLine().trim();
                //check input is empty
                if (num.isEmpty()) {
                    throw new Exception("Input cannot be empty");
                }
                n = Integer.parseInt(num);
                //check input is out of range
                if (n <= 0) {
                    throw new Exception("Semester must be greater than 0");
                }
                break;
                //check input is not number
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer number");
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }
    
}
