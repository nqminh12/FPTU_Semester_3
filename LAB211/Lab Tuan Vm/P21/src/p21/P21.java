/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p21;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class P21 {

    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        StudentScheduleManager manager = new StudentScheduleManager();
        ArrayList<StudentSchedule> studentList = new ArrayList<>();
        //loop until user choose 5 : exit menu
        int choice;
        do{
            //1. display the menu
            displayMenu();
            //2. ask users to select a choice
            choice = DataGetter.getOption("Enter your choice: ",1, 5);
            //3. Handle function based on user option
            switch (choice) {
                case 1:
                    manager.create(studentList);
                    break;
                case 2:
                    manager.findAndSort(studentList);
                    break;
                case 3:
                    manager.updateOrDelete(studentList);
                    break;
                case 4:
                    manager.report(studentList);
                    break;
                case 5:
                    System.out.println("Exit menu");
                    break;
                
            }
            
        }while(choice!=5);
                
    }

    private static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("    1. Create                ");
        System.out.println("    2. Find and Sort         ");
        System.out.println("    3. Update/Delete         ");
        System.out.println("    4. Report                ");
        System.out.println("    5. Exit                  ");
    }
    
}
