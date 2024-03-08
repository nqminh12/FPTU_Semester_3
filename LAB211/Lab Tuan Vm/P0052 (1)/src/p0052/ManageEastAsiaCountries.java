/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p0052;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {

    //Add information for a country
    public void addCountryInformation(ArrayList<EastAsiaCountries> listCountry) {
        String countryCode;
        boolean check;
        if (listCountry.size() < 11) {
            do {
                countryCode = DataGetter.getString("Enter code of country: \n", "^[a-z0-9A-Z]+$");
                //check code contry exist or not
                if (!checkCountryExist(countryCode, listCountry)) {
                    System.out.println("Country exist.");
                    check = true;
                } else {
                    check = false;
                }
            } while (check == true);
            String countryName = DataGetter.getString("Enter name of country: \n", "^[a-zA-Z ]+$");
            float countryArea = DataGetter.getFloat("Enter total area: \n", "Total area must be positive number");
            String countryTerrain = DataGetter.getString("Enter terrain of country: \n", "^[a-zA-Z]+$");
            listCountry.add(new EastAsiaCountries(countryCode, countryName, countryArea, countryTerrain));
            System.out.println("Add country successfully");
        } else {
            System.out.println("The list already has 11 countries. Can't add more");
        }
    }

    //display infomation of country
    public void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> listCountry) {
        //Check list is emty
        if (listCountry.isEmpty()) {
            System.out.println("List Country is empty");
        } else {
            System.out.printf("%-15s%-20s%-20s%-10s\n", "ID", "Name", "Total Area",
                    "Terrain");
            listCountry.get(listCountry.size() - 1).display();

        }
    }

    //Swap two country in list
    public void swap(ArrayList<EastAsiaCountries> list, int i, int j) {
        EastAsiaCountries tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    //Displays the names of countries by name ascending 
    public void sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> listCountry) {
        //Check list is emty
        if (listCountry.isEmpty()) {
            System.out.println("List Country is empty");
        } else {
            // loop for first country to last country in list
            for (int i = 0; i < listCountry.size(); i++) {
                // loop for first country to last country in list is not sorted
                for (int j = 0; j < listCountry.size() - i - 1; j++) {
                    //Compare each pair of adjacent country
                    if (listCountry.get(j).countryName.compareTo(listCountry.get(j + 1).countryName) > 0) {
                        swap(listCountry, j, j + 1);
                    }
                }
            }
            System.out.printf("%-15s%-20s%-20s%-10s\n", "ID", "Name", "Total Area",
                    "Terrain");
            // loop for fisrt country to near last contry in list
            for (int i = 0; i < listCountry.size()-1; i++) {
                listCountry.get(i).display();
                System.out.println();
            }
            listCountry.get(listCountry.size()-1).display();
        }
    }

    //Search information of countries by user-entered name
    public void searchInformationByName(ArrayList<EastAsiaCountries> listCountry) {
        //Check list is emty
        if (listCountry.isEmpty()) {
            System.out.println("List Country is empty");
        } else {
            String countryName = DataGetter.getString("Enter the name you want to search for: \n", "^[a-zA-Z ]+$");
            boolean check = true;
            //loop for first contry to last country in list
            for (int i = 0; i < listCountry.size(); i++) {
                if (listCountry.get(i).getCountryName().toUpperCase().contains(countryName.toUpperCase())) {
                    check = false;
                }
            }
            //case: found country
            if (check == false) {
                System.out.printf("%-15s%-20s%-20s%-10s\n", "ID", "Name", "Total Area",
                        "Terrain");
                for (int i = 0; i < listCountry.size(); i++) {
                    if (listCountry.get(i).getCountryName().toUpperCase().contains(countryName.toUpperCase())) {
                        listCountry.get(i).display();
                    }
                }
            //Case: Can't found country
            } else {
                System.out.println("     - Can't find the country in list -    ");
            }
        }
    }

    //check country exist by code
    public boolean checkCountryExist(String countryCode, ArrayList<EastAsiaCountries> listCountry) {
        //loop for first contry to last country in list
        for (int i = 0; i < listCountry.size(); i++) {
            if (listCountry.get(i).getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}
