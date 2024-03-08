/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Input {

    private static Scanner sc = new Scanner(System.in);

    static int inputIntLimit(String noti, int min, int max) {
        int output;
        do {
            System.out.print(noti);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not empty");
            } else {
                try {
                    output = Integer.parseInt(input.trim());
                    if (output < min || output > max) {
                        throw new Error();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Input must integer");
                } catch (Error e) {
                    System.err.println("Please input number in rage [" + min + ", " + max + "]");
                }
            }

        } while (true);
        return output;
    }

    static float inputFloat(String noti) {
        float output;
        do {
            System.out.print(noti);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not empty");
            } else {
                try {
                    output = Float.parseFloat(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please input number.");
                }
            }
        } while (true);
        return output;
    }

}
