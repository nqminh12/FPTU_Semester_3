/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p0052;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DataGetter {
    
    private final static Scanner sc = new Scanner(System.in);

    //check user input choice in range
    public static int getOption(int min, int max) {
        String num;
        int n;
        //loop until input follow the requirement
        while (true) {
            try {
                System.out.print("Enter your choice: ");
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
                //check input is not follow format
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }

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
                    throw new Exception("Value must be match format");
                }
                break;
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return str;
    }

    // check input folloew fomat number float
    public static float getFloat(String s, String s1) {
        String num;
        float n;
        //loop until user input follow the requirement
        while (true) {
            try {
                System.out.print(s);
                num = sc.nextLine().trim();
                //check input is empty
                if (num.isEmpty()) {
                    throw new Exception("Input cannot be empty");
                }
                n = Float.parseFloat(num);
                //check input is not positivenumber
                if (n <= 0 ) {
                    throw new Exception(s1);
                }
                return n;
                //check input is not follow format
            } catch (NumberFormatException e) {
                System.out.println("Input must be float number");
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
