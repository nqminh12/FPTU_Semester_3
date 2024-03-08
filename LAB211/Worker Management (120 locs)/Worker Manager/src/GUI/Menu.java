/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;
import manager.Management;
import manager.Validation;

/**
 *
 * @author Fpt
 */
public class Menu {
    private static String[] ops = {
        "Add Worker",
        "Up salary",
        "Down salary",
        "Display information salary",
        "Display information",
        "Exit"
    };
    
    private static int getChoice(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < ops.length; i++)
        {
            System.out.println((i + 1) + ". " + ops[i]);
        }
        return Validation.getInt("Enter choice: ", 1, ops.length);
    }
    public static void display(){
        Management n = new Management();
        int choice;
        do{
            System.out.println("======= Worker Management =======");
            choice = getChoice();
            switch (choice) {
                case 1:
                    n.addWorker();
                    break;
                case 2:
                    n.updatesalary(1);
                    break;
                case 3:
                    n.updatesalary(2);
                    break;
                case 4:
                    n.getInformation();
                    break;
                case 5:
                    n.displayAll();
                    break;
                case 6:
                    break;
            }
            
        }while(choice != 6);
        
    }
    
    
    
}
