/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixupdate;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {

        do {            
            //1. Display menu
            Manager.displayMenu();
            //2. Get user input data
            int choice = GetData.getInt("Your choice:", 1, 4);
            //3. Users select an option
            switch(choice) {
                case 1:
                    Manager.displayTitle(choice);
                    int[][] matrix1 = GetData.getMatrix1();
                    int[][] matrix2 = GetData.getMatrix2(choice, matrix1);
                    int[][] result = Calculator.additionMatrix(matrix1, matrix2);
                    Manager.displayResult(matrix1, matrix2, result, choice);
                case 2:
                    Manager.displayTitle(choice);
                    matrix1 = GetData.getMatrix1();
                    matrix2 = GetData.getMatrix2(choice, matrix1);
                    result = Calculator.subtractionMatrix(matrix1, matrix2);
                    Manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                case 3:
                    Manager.displayTitle(choice);
                    matrix1 = GetData.getMatrix1();
                    matrix2 = GetData.getMatrix2(choice, matrix1);
                    result = Calculator.multiplicationMatrix(matrix1, matrix2);
                    Manager.displayResult(matrix1, matrix2, result, choice);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
    
}
