
import java.util.Scanner;

public class Input {

    static Scanner sc = new Scanner(System.in);
    
    static String inputString(String noti) {
        //loop until user input true value
        while (true) {
            System.out.print(noti);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    static int inputMark(String nameSubject) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    System.err.println(nameSubject + " is greater than equal zero");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                if (result > 10) {
                    System.err.println(nameSubject + " is less than equal ten");
                    System.out.print(nameSubject + ":");
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println(nameSubject + " is digit");
                System.out.print(nameSubject + ":");
            }
        }
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
