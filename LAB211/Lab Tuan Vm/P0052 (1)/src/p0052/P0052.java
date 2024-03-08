/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p0052;

import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public class P0052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option;
        ArrayList<EastAsiaCountries> listCountry = new ArrayList<>();
        ManageEastAsiaCountries manageEastAsiaCountries = new ManageEastAsiaCountries();
        //loop until user choose option 5 : exit
        do {
            //Display menu
            displayMenu();
            //users input an option
            option = DataGetter.getOption(1, 5);
            //handle function based on urser option
            switch (option) {
                //Add information for a country
                case 1:
                    manageEastAsiaCountries.addCountryInformation(listCountry);
                    break;
                // Display information of countries user just input
                case 2:
                    manageEastAsiaCountries.getRecentlyEnteredInformation(listCountry);
                    break;
                //Search information of countries by user-entered name 
                case 3:
                    manageEastAsiaCountries.searchInformationByName(listCountry);
                    break;
                //Displays countries by name ascending 
                case 4:
                    manageEastAsiaCountries.sortInformationByAscendingOrder(listCountry);
                    break;
                //Exit menu
                case 5:
                    System.out.println("Exit menu");
                    break;
            }
        }while(option!=5);
    }
    
    public static void displayMenu() {
        System.out.println("                            MENU                                 ");
        System.out.println("=================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia            ");
        System.out.println("2. Display the information of country you've just input          ");
        System.out.println("3. Search the information of country by user-entered name        ");
        System.out.println("4. Display the information of countries sorted name in ascending ");
        System.out.println("5. Exit                                                          ");
        System.out.println("=================================================================");
    }
    
}
