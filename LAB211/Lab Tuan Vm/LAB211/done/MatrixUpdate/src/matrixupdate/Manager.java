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
public class Manager {
    public static void displayMenu() {
        System.out.println("=====Calculator program====");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }
    
    public static void displayTitle(int choice) {
     switch (choice) {
            case 1:
                System.out.println("--------- Addition ------------");
                break;
            case 2:
                System.out.println("--------- Subtraction  ------------");
                break;
            case 3:
                System.out.println("--------- Multiplication  ------------");
                break;
        }  
    }
    
    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < col; j++) {
                System.out.format("[%d]", matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        System.out.println("------- Result ----------");
        displayMatrix(matrix1);
        switch (choice) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }
    
}
