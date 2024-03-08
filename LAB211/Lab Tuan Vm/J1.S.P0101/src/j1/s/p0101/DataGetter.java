/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0101;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DataGetter {

    public static final Scanner sc = new Scanner(System.in);

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
                    throw new Exception("Value must be match fomat input");
                }
                break;
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return str;
    }

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

    public static Date getDate(String s) {
        String str;
        Date date;
        //loop until input follow the requirement
        while (true) {
            try {
                System.out.print(s);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                str = sc.nextLine();
                //check input is empty
                if (str.isEmpty()) {
                    throw new Exception("Input is empty");
                //check input follow format or not
                } else if (!str.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")) {
                    throw new Exception("Input must satisfy format dd/MM/yyyy");
                // check input day is exist or not
                } else if (!str.matches("^(3[01]|[12][0-9]|0[1-9])/(1[02]|0[13578])/[0-9]{4}$")
                        && !str.matches("^(30|[12][0-9]|0[1-9])/(11|0[469])/[0-9]{4}$")
                        && !str.matches("^([12][0-9]|0[1-9])/02/[0-9]{4}$")) {
                    throw new Exception("Input must existed");
                }
                date = dateFormat.parse(str);
                Date now = new Date();
                //compare present day
                if (!date.before(now)) {
                    throw new Exception("Birthday must before today!");
                }
                break;
            //display message if input is satisfied exception
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return date;
    }

    
    // check input folloew fomat number double
    public static double getDouble(String s) {
        String num;
        double n;
        //loop until user input follow the requirement
        while (true) {
            try {
                System.out.print(s);
                num = sc.nextLine().trim();
                //check input is empty
                if (num.isEmpty()) {
                    throw new Exception("Input cannot be empty");
                }
                n = Double.parseDouble(num);
                //check input is not positivenumber
                if (n <= 0 ) {
                    throw new Exception("Salary must be positive number");
                }
                return n;
                //check input is not follow format
            } catch (NumberFormatException e) {
                System.out.println("Input must be double number");
                //display message if input is satisfied exception
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
