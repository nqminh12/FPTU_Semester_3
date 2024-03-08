
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
public class Validate {

    private static Scanner sc = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            if (sc.nextLine().isEmpty()) {
                System.out.println("Input empty");
            } else {
                try {
                    int input = Integer.parseInt(sc.nextLine().trim());
                    if (input < min || input > max) {
                        throw new Error();
                    }
                    return input;
                } catch (NumberFormatException e) {
                    System.out.println("Input must integer");
                } catch (Error e) {
                    System.err.println("Please input number in rage [" + min + ", " + max + "]");
                }
            }

        }
    }

    private static float checkValidNumber(String noti) {
        float number;

        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input empty");
            } else {
                try {
                    number = Float.parseFloat(input);
                    return number;
                } catch (NumberFormatException e) {
                    System.out.println("Please input number.");
                }
            }

        }       
    }
}
