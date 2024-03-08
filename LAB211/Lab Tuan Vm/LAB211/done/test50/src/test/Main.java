package test;

public class Main {
    public static void main(String[] args) {
        //loop until user choose 3
        while (true) {
            //1. users to select an option
            int choice = Number.displayMenu();
            switch (choice) {
                //2. Calculate Superlative Equation
                case 1:
                    Number.calculateEquation();
                    break;
                //3. Calculate Quadratic Equation
                case 2:
                    Number.calculateQuadraticEquation();
                    break;
                //4. Exit the program
                case 3:
                    return;
            }
        }
    }
}
