
import java.util.Scanner;
import java.util.ArrayList;

public class AnalysisString {

    public static void main(String[] args) {
        //1. User input data
        String input = inputString();
        //2. Display list of numbers, list of even numbers, list of odd number, and list of square numbers
        displayTypeListNumber(input);
        //3. Display the all characters, uppercase characters, lowercase characters
        displayTypeListCharacter(input);
        //4. Display the special characters
        displayListSpecialCharacter(input);
    }

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        String input = sc.nextLine().trim();
        return input;
    }

    public static void displayTypeListNumber(String input) {
        System.out.println("\n-----Result Analysis------");

        // Get all the numbers from the input string
        ArrayList<Integer> numbers = getNumbers(input);

        // Create lists to store the perfect square, odd and even numbers
        ArrayList<Integer> perfectSquares = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        int countPerfectSquare = 0;
        int countOdd = 0;
        int countEven = 0;

        // Loop through each number in the list of numbers
        for (int num : numbers) {
            // Check if it is a perfect square and add it to the corresponding list
            if (isPerfectSquare(num)) {
                countPerfectSquare++;
                perfectSquares.add(num);
            }
            // Check if it is odd or even and add it to the corresponding list
            if (num % 2 == 0) {
                countEven++;
                evenNumbers.add(num);
            } else {
                countOdd++;
                oddNumbers.add(num);
            }
        }
        System.out.print("Perfect Square Numbers: ");
        if (countPerfectSquare == 0) {
            System.out.println("have no Perfect Square Numbers");
        } else {
            System.out.println(perfectSquares);
        }
        
        System.out.print("Odd Numbers: ");
        if (countOdd == 0) {
            System.out.println("have no Odd Numbers");
        } else {
            System.out.println(oddNumbers);
        }
        
        System.out.print("Even Numbers: ");
        if (countOdd == 0) {
            System.out.println("have no Even Numbers");
        } else {
            System.out.println(evenNumbers);
        }
        
        System.out.print("All Numbers: ");
        if (numbers.isEmpty()) {
            System.out.println("have no Numbers");
        } else {
            System.out.println(numbers);
        }
    }

    public static void displayTypeListCharacter(String input) {
        ArrayList<Character> characters = getCharacters(input);
        ArrayList<Character> uppercaseCharacters = new ArrayList<>();
        ArrayList<Character> lowercaseCharacters = new ArrayList<>();
        int countUp = 0;
        int countLow = 0;

        // Loop through each character in the list of characters
        for (char c : characters) {
            // Check if it is uppercase or lowercase and add it to the corresponding list
            if (Character.isUpperCase(c)) {
                countUp++;
                uppercaseCharacters.add(c);
            } else if (Character.isLowerCase(c)) {
                countLow++;
                lowercaseCharacters.add(c);
            }
        }

        System.out.print("Uppercase Characters: ");
        if (countUp == 0) {
            System.out.println("have no Uppercase Characters");
        } else {
            System.out.println(charListToString(uppercaseCharacters));
        }
        
        System.out.print("Lowercase Characters: ");
        if (countLow == 0) {
            System.out.println("have no Lowercase Characters");
        } else {
            System.out.println(charListToString(lowercaseCharacters));
        }
    }

    public static void displayListSpecialCharacter(String input) {
        ArrayList<Character> characters = getCharacters(input);
        ArrayList<Character> specialCharacters = new ArrayList<>();
        int countSpecial = 0;

        // Loop through each character in the input string 
        for (char c : input.toCharArray()) {
            // Check if it is neither a letter nor a digit and add it to the list of special characters 
            if (!Character.isLetterOrDigit(c)) {
                countSpecial++;
                specialCharacters.add(c);
            }
        }

        System.out.print("Special Characters: ");
        if (countSpecial == 0) {
            System.out.println("have no Special Characters");
        } else {
            System.out.println(charListToString(specialCharacters));
        }
        
        System.out.print("All Characters: ");
        if (characters.isEmpty()) {
            System.out.println("have no Characters");
        } else {
            System.out.println(charListToString(characters));
        }

    }

    // A method to check if a number is a perfect square
    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    // A method to get all the numbers from the input string
    public static ArrayList<Integer> getNumbers(String input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] tokens = input.split("[^0-9]+"); // split by non-digit characters
        for (String token : tokens) {
            // ignore empty strings
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                numbers.add(num);
            }
        }
        return numbers;
    }

    // A method to get all the characters from the input string
    public static ArrayList<Character> getCharacters(String input) {
        ArrayList<Character> characters = new ArrayList<>();
        // loop through each character in the input
        for (char c : input.toCharArray()) {
            // check if it is a letter
            if (!Character.isDigit(c)) {
                characters.add(c);
            }
        }
        return characters;
    }

    // A method to convert a list of characters to a string
    public static String charListToString(ArrayList<Character> charList) {
        StringBuilder sb = new StringBuilder(); // create a string builder object
        // loop through each character in the list
        for (char c : charList) {
            sb.append(c); // append it to the string builder
        }
        return sb.toString(); // return the string representation of the string builder
    }

}
