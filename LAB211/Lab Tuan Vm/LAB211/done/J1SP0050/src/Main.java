/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            int choice = Manager.displayMenu();
            switch (choice) {
                case 1:
                    //Manager.calculateSuperlativeEquation();
                    break;
                case 2:
                    //calculateQuadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }
}
