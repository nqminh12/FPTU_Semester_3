
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    static String inputString(String noti) {
        do {
            System.out.print(noti);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Can not empty");
                continue;
            }
            return input;
        } while (true);
    }

    static float inputFloat(String noti, int min, int max) {
        float output;
        do {
            System.out.print(noti);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not empty");
            } else {
                try {
                    output = Float.parseFloat(input);
                    if (output < min || output > max) {
                        throw new Error();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please input number.");
                } catch (Error e) {
                    System.out.println("Please input in arange from " + min + " to " + max);
                }
            }
        } while (true);
        return output;
    }

    static boolean checkYN() {
        while (true) {
            String result = inputString("Do you want to enter more student information?(Y/N): ");
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'N') {
                    return false;
                }
            }
        }
    }
}

