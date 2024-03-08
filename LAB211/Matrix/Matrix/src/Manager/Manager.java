/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

/**
 *
 * @author Fpt
 */
public class Manager {

    public void display(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public static int[][] enter(int n, int row, int col) {

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Validation.getInt("Enter Matrix" + n + " [" + i + "][" + j + "]:");
            }
        }
        return matrix;
    }

    public void add(int check) {
        // nhap
        int row1 = Validation.getSize("Enter Row Matrix 1: ");
        int col1 = Validation.getSize("Enter Column Matrix 1:");
        int[][] matrix1 = enter(1, row1, col1);
        int row2;
        int col2;
        do {
            row2 = Validation.getSize("Enter Row Matrix 2: ");
            if (row1 != row2) {
                System.err.println("Row of matrix 2 must equal to row of matrix 1");
            } else {
                break;
            }
        } while (true);
        do {
            col2 = Validation.getSize("Enter Column Matrix 2: ");
            if (col1 != col2) {
                System.err.println("Column of matrix 2 must equal to column of matrix 1");
            } else {
                break;
            }
        } while (true);

        int[][] matrix2 = enter(2, row2, col2);

        // xu li
        int[][] matrix = new int[row1][col1];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                if (check == 1) {
                    matrix[i][j] = matrix1[i][j] + matrix2[i][j];
                } else {
                    matrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }

        // in ra
        System.out.println("-------- Result --------");
        display(matrix1);
        if (check == 1) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
        display(matrix2);
        System.out.println("=");
        display(matrix);
    }

    public void mul() {
        // nhap

        int row1 = Validation.getSize("Enter Row Matrix 1: ");
        int col1 = Validation.getSize("Enter Column Matrix 1:");
        int[][] matrix1 = enter(1, row1, col1);
        int row2;
        do {
            row2 = Validation.getSize("Enter Row Matrix 2: ");
            if (row2 != col1) {
                System.err.println("Row of matrix 2 must equal to row of matrix 1");
            } else {
                break;
            }
        } while (true);

        int col2 = Validation.getSize("Enter Column Matrix 2: ");
        int[][] matrix2 = enter(2, row2, col2);

        // tinh
        int[][] matrix = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                int sum = 0;
                for (int k = 0; k < col1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                matrix[i][j] = sum;
            }
        }

        //in ra
        System.out.println("-------- Result --------");
        display(matrix1);
        System.out.println("*");
        display(matrix2);
        System.out.println("=");
        display(matrix);
    }
}
