/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixupdate;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class GetData {

    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        String input;
        int output;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input empty");
            } else {
                try {
                    output = Integer.parseInt(input);
                    //check input must be in range min to max
                    if (output <= max && output >= min) {
                        break;
                        //check input must greater than 0
                    } else if (output <= 0) {
                        throw new Error();
                    } else {
                        throw new Exception();
                    }
                } catch (NumberFormatException numex) {
                    System.err.println("Input must be integer");
                } catch (Exception error) {
                    System.err.println("Input must be in range " + min + " to " + max);
                } catch (Error NegaNumber) {
                    System.err.println("Input must greater than 0");
                }
            }
        } while (true);
        return output;
    }

    public static int getMatrix(String msg) {
        String input;
        int output;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input empty");
            } else {
                try {
                    output = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException numex) {
                    System.err.println("Value of matrix is digit");
                }
            }
        } while (true);
        return output;
    }

    public static int[][] getMatrix1 () {
        int row1 = getInt("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        int col1 = getInt("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        int[][] matrix1 = new int[row1][col1];
        //Access from first to the element of the row in the matrix
        for (int i = 0; i < row1; i++) {
            //Acess from first to last element of the column in the matrix
            for (int j = 0; j < col1; j++) {
                String mess = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix1[i][j] = getMatrix(mess);
            }
        }
        return matrix1;
    }

    public static int[][] getMatrix2(int choice, int[][] matrix1) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2, col2;
        if (choice == 1 || choice == 2) {
            do {
                row2 = getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check row of matrix2 equal or not row of matrix 1
                if (row2 != row1) {
                    System.out.println("Row matrix 2 must be equal row matrix 1");
                } else {
                    break;
                }
            } while (true);
            
            do{
                col2 = getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                //check column of matrix2 equal or not column of matrix 1
                if (col2 != col1) {
                    System.out.println("Column matrix 2 must be equal column matrix 1");
                } else {
                    break;
                }
            }while(true);
        } else {
            do {
                row2 = getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check row of matrix2 equal or not column of matrix 1
                if (row2 != col1) {
                    System.out.println("Row matrix 2 must be equal column matrix 1");
                    continue;
                }
                col2 = getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                break;
            } while (true);
        }
        int[][] matrix2 = new int[row2][col2];
        //Access from first to the element of the row in the matrix
        for (int i = 0; i < row2; i++) {
            //Acess from first to last element of the column in the matrix
            for (int j = 0; j < col2; j++) {
                String mess = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix2[i][j] = getMatrix(mess);
            }
        }
        return matrix2;
    }
}
