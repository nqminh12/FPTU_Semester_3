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
        int[] arrayNeedSort = new int[0];
        do {            
            //1. Display a menu 
            Manage.displayMenu();
            //2. User to select an option
            int user_choice = Input.getUserChoice("Please choice one option: ", 1, 4);
            switch(user_choice) {
                //3. Input Element(s)
                case 1:
                    arrayNeedSort = Manage.inputElement();
                    break;
                //4. Sort in ascending order
                case 2:
                    Manage.sortAscending(arrayNeedSort);
                    break;
                //4. Sort in Descending order
                case 3:
                    Manage.sortDescending(arrayNeedSort);
                    break;
                //5. Exit the program
                case 4:
                    return;
            }
        } while (true);
    }
}
