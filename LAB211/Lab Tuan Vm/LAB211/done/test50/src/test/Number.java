package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Number {

    private static Scanner sc = new Scanner(System.in);

    static int displayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        int choice = Input.inputIntLimit("Please choose an option: ", 1, 3);
        return choice;
    }

    public static boolean isOdd(double n) {
        return n % 2 != 0;
    }

    public static boolean isPerfectSquare(double n) {
        return (int) Math.sqrt(n) * (int) Math.sqrt(n) == n;
    }

    static void calculateEquation() {
        System.out.println("----- Calculate Superlative Equation -----");
        float a = Input.inputFloat("Enter A: ");
        float b = Input.inputFloat("Enter B: ");
        
        List<Float> solutions = new ArrayList<>();
        solutions.add(a);
        solutions.add(b);
        
        if (a == 0) {
            if (b == 0) {
                System.out.println("No solution exists.");
                displayNumberProperties(solutions);
            } else {
                System.out.println("Infinite solutions exist.");
                displayNumberProperties(solutions);
            }
        } else {
            float x = -b / a;
            solutions.add(x);
            System.out.printf("Solution: x = " + "%.3f", solutions.get(solutions.size() - 1));
            System.out.println("");
            displayNumberProperties(solutions);
        }
        System.out.println();
    }

    static void calculateQuadraticEquation() {
        System.out.println("----- Calculate Quadratic Equation -----");
        float a = Input.inputFloat("Enter A: ");
        float b = Input.inputFloat("Enter B: ");
        float c = Input.inputFloat("Enter C: ");
        
        List<Float> solutions = new ArrayList<>();
        float x1;
        float x2;
        solutions.add(a);
        solutions.add(b);
        solutions.add(c);
        
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions exist.");
                    displayNumberProperties(solutions);
                } else {
                    System.out.println("No solution exists.");
                    displayNumberProperties(solutions);
                }
            } else {
                x1 = -c / b;
                x2 = -c / b;
                solutions.add(x1);
                solutions.add(x2);
                System.out.printf("Solution: x1 = " + "%.3f", solutions.get(solutions.size() - 2));
                System.out.printf(" and x2 = " + "%.3f", solutions.get(solutions.size() - 1));
                System.out.println("");
                displayNumberProperties(solutions);
            }
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("No solution exists.");
                displayNumberProperties(solutions);
            } else {
                x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
                x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
                solutions.add(x1);
                solutions.add(x2);
                System.out.printf("Solution: x1 = " + "%.3f", solutions.get(solutions.size() - 2));
                System.out.printf(" and x2 = " + "%.3f", solutions.get(solutions.size() - 1));
                System.out.println("");
                displayNumberProperties(solutions);
            }
        }
        System.out.println();
    }

    public static void displayNumberProperties(List<Float> numbers) {
        int countOdd = 0;
        int countEven = 0;
        int countPerfectSquare = 0;

        System.out.print("Number is Odd: ");
        for (int i = 0; i < numbers.size(); i++) {
            if (isOdd(numbers.get(i))) {
                countOdd++;
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1 && isOdd(numbers.get(i + 1))) {
                    System.out.print(", ");
                }
            }
        }
        if (countOdd == 0) {
            System.out.print("have no odd number");
        }
        System.out.println();

        System.out.print("Number is Even: ");
        for (int i = 0; i < numbers.size(); i++) {
            if (!isOdd(numbers.get(i))) {
                countEven++;
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1 && !isOdd(numbers.get(i + 1))) {
                    System.out.print(", ");
                }
            }
        }
        if (countEven == 0) {
            System.out.print("have no even number");
        }
        System.out.println();

        System.out.print("Number is Perfect Square: ");
        for (int i = 0; i < numbers.size(); i++) {
            if (isPerfectSquare(numbers.get(i))) {
                countPerfectSquare++;
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1 && isPerfectSquare(numbers.get(i + 1))) {
                    System.out.print(", ");
                }
            }
        }
        if (countPerfectSquare == 0) {
            System.out.print("have no perfect square number");
        }
        System.out.println();
    }
    
    
    
    
//        private static List<Float> calculateEquation(float a, float b) {
//        List<Float> solutions = new ArrayList<>();
//        solutions.add(a);
//        solutions.add(b);
//
//        if (a == 0) {
//            if (b == 0) {
//                System.out.println("No solution exists.");
//                displayNumberProperties(solutions);
//            } else {
//                System.out.println("Infinite solutions exist.");
//                displayNumberProperties(solutions);
//            }
//        } else {
//            float x = -b / a;
//            solutions.add(x);
//            System.out.printf("Solution: x = " + "%.3f", solutions.get(solutions.size() - 1));
//            System.out.println("");
//            displayNumberProperties(solutions);
//        }
//        return solutions;
//    }
//
//    private static List<Float> calculateQuadraticEquation(float a, float b, float c) {
//        List<Float> solutions = new ArrayList<>();
//        float x1;
//        float x2;
//        solutions.add(a);
//        solutions.add(b);
//        solutions.add(c);
//        if (a == 0) {
//            if (b == 0) {
//                if (c == 0) {
//                    System.out.println("Infinite solutions exist.");
//                    displayNumberProperties(solutions);
//                } else {
//                    System.out.println("No solution exists.");
//                    displayNumberProperties(solutions);
//                }
//            } else {
//                x1 = -c / b;
//                x2 = -c / b;
//                solutions.add(x1);
//                solutions.add(x2);
//                System.out.printf("Solution: x1 = " + "%.3f", solutions.get(solutions.size() - 2));
//                System.out.printf(" and x2 = " + "%.3f", solutions.get(solutions.size() - 1));
//                System.out.println("");
//                displayNumberProperties(solutions);
//            }
//        } else {
//            float delta = b * b - 4 * a * c;
//            if (delta < 0) {
//                System.out.println("No real solutions");
//            } else {
//                x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
//                x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
//                solutions.add(x1);
//                solutions.add(x2);
//                System.out.printf("Solution: x1 = " + "%.3f", solutions.get(solutions.size() - 2));
//                System.out.printf(" and x2 = " + "%.3f", solutions.get(solutions.size() - 1));
//                System.out.println("");
//                displayNumberProperties(solutions);
//            }
//        }
//        return solutions;
//    }

}
