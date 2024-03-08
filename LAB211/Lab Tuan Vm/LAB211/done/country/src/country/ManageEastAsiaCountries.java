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
class ManageEastAsiaCountries {

    public static String RED = "\u001B[31m";
    public static String RESET = "\u001B[0m";

    static void displayMenu() {
        System.out.println("                        MENU                                              ");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia                     ");
        System.out.println("2. Display the information of country you've just input                   ");
        System.out.println("3. Search the information of country by user-entered name                 ");
        System.out.println("4. Display the information of countries sorted name in ascending order    ");
        System.out.println("5. Exit                                                                   ");
        System.out.println("==========================================================================");
    }

    public static void addCountryInformation(List<EastAsiaCountries> countryList) {
        String id;
        String name;
        float totalArea;
        String terrian;

        // check limit country
        if (countryList.size() == 3) {
            System.out.println(RED + "You entered max countries" + RESET);
            return;
        }

        do {
            id = InputData.inputString("Enter code of country: ");
            // check duplicate new ID in list
            if (checkDuplicateID(id, countryList)) {
                System.out.println(RED + "This ID is exist" + RESET);
            } else {
                break;
            }
        } while (true);

        name = InputData.inputString("Enter name of country: ");
        totalArea = InputData.inputFloat("Enter total Area: ");
        terrian = InputData.inputString("Enter terrian of country: ");

        countryList.add(new EastAsiaCountries(id, name, totalArea, terrian));
    }

    public static void getRecentlyEnteredInformation(List<EastAsiaCountries> countryList, int choice) {
        displayCountry(countryList, choice);
    }

    public static void searchInformationByName(List<EastAsiaCountries> countryList, int choice) {
        String nameSearch;
        // loop until the name search is exist in list
        do {
            nameSearch = InputData.inputString("Enter the name you want to search for: ");
            // check ID user input existed or not
            if (!checkDuplicateName(nameSearch, countryList)) {
                System.out.println(RED + "This name is not exist in the list" + RESET);
            } else {
                break;
            }
        } while (true);

        List<EastAsiaCountries> searchList = new ArrayList<>();
        //Access the first object to the last object in list
        for (EastAsiaCountries obj : countryList) {
            //Compare between name of each countries and name search
            if (obj.getCountryName().contains(nameSearch)) {
                searchList.add(new EastAsiaCountries(obj.getCountryCode(), obj.getCountryName(),
                        obj.getTotalArea(), obj.getCountryTerrain()));
            }
        }

        displayCountry(searchList, choice);
    }

    public static void sortInformationByAscendingOrder(List<EastAsiaCountries> countryList, int choice) {
        // access the first to the last element in array list
        for (int i = 0; i < countryList.size(); i++) {
            // Accessed first to the last element stand before sorted element
            for (int j = 0; j < countryList.size() - i - 1; j++) {
                //compares 2 consecutive country name of elements in an array list
                if (countryList.get(j).countryName.compareTo(countryList.get(j + 1).countryName) > 0) {
                    EastAsiaCountries temp = countryList.get(j);
                    countryList.set(j, countryList.get(j + 1));
                    countryList.set((j + 1), temp);
                }
            }
        }
        displayCountry(countryList, choice);
    }

    public static void displayCountry(List<EastAsiaCountries> list, int choice) {
        System.out.printf("%-15s%-15s%-15s%-15s", "ID", "Name", "Total Area", "Terrain");
        System.out.println();
        // check user choose number performent to display
        if (choice == 2) {
            EastAsiaCountries lastCountry = list.get(list.size() - 1);
            lastCountry.display();
            System.out.println();
        } else {
            //Access the first object to the last object
            for (EastAsiaCountries obj : list) {
                obj.display();
                System.out.println();
            }
        }

    }

    public static boolean checkDuplicateID(String id, List<EastAsiaCountries> countryList) {
        //Access the first object to the last object in list
        for (EastAsiaCountries obj : countryList) {
            //Compare between ID of each countries in list and new ID user input
            if (obj.getCountryCode().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDuplicateName(String nameSearch, List<EastAsiaCountries> countryList) {
        //Access the first object to the last object in list
        for (EastAsiaCountries obj : countryList) {
            //Compare between name of each countries and name search
            if (obj.getCountryName().contains(nameSearch)) {
                return true;
            }
        }
        return false;
    }
}
