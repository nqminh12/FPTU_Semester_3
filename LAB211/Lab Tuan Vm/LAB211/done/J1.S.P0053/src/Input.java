
import java.util.Scanner;

public class Input {
    
    static Scanner sc = new Scanner(System.in);

    static int getUserChoice(String noti, int min, int max) {
        String input;
        double output;
        do {            
            System.out.print(noti);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not empty");
                continue;
            }try {
                output = Double.parseDouble(input);
                if (output < min || output > max) {
                    throw new Error();
                }
                // check if input is a real number
                if ((int) output != output) {
                    throw new Exception();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input can not string");
            } catch (Error e) {
                System.out.println("Input must in arange from " + min + " to " + max);
            } catch (Exception ex) {
                System.out.println("Input can not real number");
            }
        } while (true);
        return (int) output;
    }
    
    static int checkIn(String inputVal) {
        double size_array;
        String input;
        do {
            System.out.print(inputVal);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input can not empty");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                // check if input is negative number
                if (size_array <= 0) {
                    throw new Error();
                }
                // check if input is a real number
                if ((int) size_array != size_array) {
                    throw new Exception();
                }
                // check if number is a posituve integer number, break loop
                if (size_array > 0) {
                    break;
                }
            } catch (NumberFormatException | Error e) {
                System.out.println("Please input numberand number is greater than zero");
            } catch (Exception RealNumber) {
                System.out.println("Input could not be real number");
            }
        } while (true);
        return (int) size_array;
    }
}
