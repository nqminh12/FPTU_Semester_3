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
public class Calculator {
    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        //Access from first to the element of the row in the matrix
        for (int i = 0; i < row; i++) {
            //Access from first to the element of the column in the matrix
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        //Access from first to the element of the row in the matrix
        for (int i = 0; i < row; i++) {
            //Access from first to the element of the column in the matrix
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    
    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int rowM1 = matrix1.length;
        int rowM2 = matrix2.length;
        int colM2 = matrix2[0].length;
        int[][] result = new int[rowM1][colM2];
        //Access from first to the element of the row in the matrix 1
        for (int i = 0; i < rowM1; i++) {
            //Access from first to the element of the column in the matrix 2
            for (int j = 0; j < colM2; j++) {
                //Access from first to the element of the row in the matrix 1
                for (int k = 0; k < rowM2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j] ;
                }
            }
        }
        return result;
    }
}
