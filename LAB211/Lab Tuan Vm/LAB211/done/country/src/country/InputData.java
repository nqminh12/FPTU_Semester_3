/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class InputData {
    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";
    static Scanner sc = new Scanner(System.in);

    static int getUserSelect(String noti, int min, int max) {
        String input;
        double output;

        do {
            System.out.println(noti);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(RED + "Input can not empty" + RESET);
                continue;
            }
            try {
                output = Double.parseDouble(input.trim());
                if (output < min || output > max) {
                    throw new Exception();
                }
                if ((int) output != output) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Input can not a string" + RESET);
            } catch (Exception e) {
                System.out.println(RED + "Please enter an integer in range " + min + " to " + max + RESET);
            } catch (Error e) {
                System.out.println(RED + "Input can not a real number" + RESET);
            }
        } while (true);
        return (int) output;
    }

    static String inputString(String noti) {
        String input;
        do {
            System.out.println(noti);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(RED + "Input can not empty" + RESET);
            } else {
                break;
            }
        } while (true);
        return input;
    }

    static float inputFloat(String noti) {
        String input;
        float output;
        do {
            System.out.println(noti);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println(RED + "Input can not empty" + RESET);
                continue;
            }
            try {
                output = Float.parseFloat(input);
                if (output <= 0) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Input can not a string! Enter a real number" + RESET);
            } catch (Error e) {
                System.out.println(RED + "Number must greater than 0" + RESET);
            }
        } while (true);
        return output;
    }
}
