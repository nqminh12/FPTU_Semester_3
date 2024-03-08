/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0102;

/**
 *
 * @author ADMIN
 */

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class J1SP0102 {
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy") ;

    public static void main(String[] args) {
        String[] userInput = new String[1];
        //1. User enter date with [dd/mm/yyyy] format
        Date date = enterDateWithFormat(userInput, dateFormat, "Please enter date with format [dd/mm/yyyy]: ");
        //2. Check user input date exists
        boolean check_date = checkDateExists(date, userInput);
        //3. Determine day of week with input date
        DayOfWeek dayOfWeek = determineDayOfWeek(check_date, date);
        //4. Display day
        displayResult(dayOfWeek);
    }

    private static Date enterDateWithFormat(String[] userInput, SimpleDateFormat format, String message) {
        Scanner sc = new Scanner(System.in);
        format.setLenient(true);
        Date date;
        String input;
        // loop until input date with correct format
        while (true) {
            try {
                System.out.print(message);
                input = sc.nextLine();
                // check empty input
                if (input.isEmpty()) {
                    throw new Exception("Input empty!");

                }
                /*
                "\\d{2}": Represents two consecutive digits.
                "/": The slash character separates the day, month and year.
                "\\d{4}": Represents four consecutive digits.
                 */
                String dateinput = "\\d{2}/\\d{2}/\\d{4}";
                // check format of input date
                if (!input.matches(dateinput)) {
                    throw new Exception("Invalid date format!");
                }
                userInput[0] = input;
                date = format.parse(input);
                return date;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean checkDateExists(Date date, String[] userInput) {
        String string = "";
        // check if date is one digit
        if (date.getDate() < 10) {
            string += "0" + date.getDate() + "/";
        } else {
            string += date.getDate() + "/";
        }
        // check if month is one digit
        if (date.getMonth() + 1 < 10) {
            string += "0" + (date.getMonth() + 1) + "/";
        } else {
            string += (date.getMonth() + 1) + "/";
        }
        string += (date.getYear() + 1900);
        return string.equals(userInput[0]);
    }

    private static DayOfWeek determineDayOfWeek(boolean dateExist, Date date) {
        // check date exists
        if (dateExist) {
            LocalDate parseDate = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
            return parseDate.getDayOfWeek();
        } else {
            return null;
        }
    }

    private static void displayResult(DayOfWeek dayOfWeek) {
        // check dayOfWeek isn't null
        if (dayOfWeek != null) {
            String day = dayOfWeek.toString().substring(0, 1) + dayOfWeek.toString().substring(1).toLowerCase();
            System.out.println("Your day is " + day);
        } else {
            System.out.println("This day isn't existed");
            String[] userInput = new String[1];
            Date date = enterDateWithFormat(userInput, dateFormat, "Please enter date with format [dd/mm/yyyy]: ");
            boolean check_date = checkDateExists(date, userInput);
            dayOfWeek = determineDayOfWeek(check_date, date);
            displayResult(dayOfWeek);
        }
    }

}
