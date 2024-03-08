/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duy
 */
public class Main {
    public static void main(String[] args) {       
        while (true) {     
            displayMenu();
            int choice = Validation.getChoice("Enter your choice: ", "Invalid. Please enter your choice (1-3):",
                1, 3);
            switch (choice){
                case 1:
                    Manager.superlativeEquation();
                    break;
                case 2:
                    Manager.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }
    
    public static void displayMenu(){
        System.out.println("==========Equation Program==========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }
}
