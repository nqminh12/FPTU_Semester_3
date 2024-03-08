/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Manager.Manager;
import Manager.Validation;

/**
 *
 * @author Fpt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manager ma = new Manager();
        while (true) {
            System.out.println("=======Calculator program======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = Validation.getValue("Your choice: ", 1, 4);
            switch (choice) {
                case 1:
                    System.out.println("-------- Addition --------");
                    ma.add(1);
                    break;
                case 2:
                    System.out.println("-------- Subtraction --------");
                    ma.add(0);
                    break;
                case 3:
                    System.out.println("-------- Multiplication --------");
                    ma.mul();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
