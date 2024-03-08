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
            display();
            int select = Validation.getInt("Please choose option: ", 1, 4);
            switch (select) {
                case 1:
                    ma.createFruit();
                    break;
                case 3:
                    ma.buy();
                    break;
                case 2:
                    ma.view();
                    break;
                case 4:
                    return;
            }
        }
    }
    
    public static void display(){
        System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Creat Fruit");
            System.out.println("2. View Order");
            System.out.println("3. Shopping");
            System.out.println("4. Exit");
    }
    
}
