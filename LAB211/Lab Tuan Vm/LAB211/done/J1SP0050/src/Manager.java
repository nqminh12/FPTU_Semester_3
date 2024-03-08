/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    
    private static Scanner sc = new Scanner(System.in);
    
    static int displayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
        int choice = Validate.checkInputIntLimit(1, 3);
        return choice;
    }

    private static void calculateSuperlativeEquation() {
        System.out.println("----- Calculate Superlative Equation -----");

        float a = getValidNumber(scanner, "Enter A: ");
        float b = getValidNumber(scanner, "Enter B: ");

        List<Float> solutions = calculateEquation(a, b);

        if (solutions == null) {
            System.out.println("No solution exists.");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinite solutions exist.");
        } else {
            System.out.println("Solution: x = " + solutions.get(0));
            displayNumberProperties(a, b);
        }

        System.out.println();
    }

    private static void calculateQuadraticEquation(Scanner scanner) {
        System.out.println("----- Calculate Quadratic Equation -----");

        float a = getValidNumber(scanner, "Enter A: ");
        float b = getValidNumber(scanner, "Enter B: ");
        float c = getValidNumber(scanner, "Enter C: ");

        List<Float> solutions = calculateQuadraticEquation(a, b, c);

        if (solutions == null) {
            System.out.println("No solution exists.");
        } else if (solutions.isEmpty()) {
            System.out.println("Infinite solutions exist.");
        } else {
            System.out.println("Solution: x1 = " + solutions.get(0) + " and x2 = " + solutions.get(1));
            displayNumberProperties(a, b, c);
        }

        System.out.println();
    }

    

    public static List<Float> calculateEquation(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                // Infinite solutions
                return new ArrayList<>();
            } else {
                // No solution
                return null;
            }
        } else {
            float x = -b / a;
            List<Float> solutions = new ArrayList<>();
            solutions.add(x);
            return solutions;
        }
    }

    public static List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> solutions = new ArrayList<>();

        if (a == 0) {
            solutions = calculateEquation(b, c);
        } else {
            float discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                float x1 = (-b + (float) Math.sqrt(discriminant)) / (2 * a);
                float x2 = (-b - (float) Math.sqrt(discriminant)) / (2 * a);
                solutions.add(x1);
                solutions.add(x2);
            } else if (discriminant == 0) {
                float x = -b / (2 * a);
                solutions.add(x);
            }
        }

        return solutions;
    }

    private static void displayNumberProperties(float... numbers) {
        List<Float> oddNumbers = new ArrayList<>();
        List<Float> evenNumbers = new ArrayList<>();
        List<Float> squareNumbers = new ArrayList<>();

        for (float number : numbers) {
            if (isOdd(number)) {
                oddNumbers.add(number);
            } else {
                evenNumbers.add(number);
            }

            if (isPerfectSquare(number)) {
                squareNumbers.add(number);
            }
        }

        System.out.println("Odd Number(s): " + oddNumbers);
        System.out.println("Number(s) is Even: " + evenNumbers);
        System.out.println("Number(s) is Perfect Square: " + squareNumbers);
    }

    public static boolean isOdd(float number) {
        return number % 2 != 0;
    }

    public static boolean isPerfectSquare(float number) {
        float squareRoot = (float) Math.sqrt(number);
        return squareRoot == (int) squareRoot;
    }
}
