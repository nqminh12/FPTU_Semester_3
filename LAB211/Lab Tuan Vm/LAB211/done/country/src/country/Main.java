/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package country;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        List<EastAsiaCountries> countryList = new ArrayList<>();
        do {
            // 1: Display menu
            ManageEastAsiaCountries.displayMenu();
            // 2: User enter input choice
            int user_choice = InputData.getUserSelect("Enter your choice: ", 1, 5);
            //3. Perform function based on the selected option.
            switch(user_choice) {
                //4. Enter the information for 11 countries in Southeast Asia.
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(countryList);
                    break;
                //5. Display already information.
                case 2:
                    ManageEastAsiaCountries.getRecentlyEnteredInformation(countryList, user_choice);
                    break;
                //6. Search the country according to the entered country's name.
                case 3:
                    ManageEastAsiaCountries.searchInformationByName(countryList, user_choice);
                    break;
                //7. Display the information increasing with the country name.
                case 4:
                    ManageEastAsiaCountries.sortInformationByAscendingOrder(countryList, user_choice);
                    break;
                //8. Exit program
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }  
}
