/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0101;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class EmployeeManagement {

    private boolean checkDuplicationID(ArrayList<Employee> listEmployee, String id) {
        //loop for first employee to last employee in list
        for (int i = 0; i < listEmployee.size(); i++) {
            //Check if current id equals enter id
            if (listEmployee.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    void addEmployee(ArrayList<Employee> listEmployee) {
        String id;
        //loop until the ID is not duplicated 
        do {
            id = DataGetter.getString("Enter id: ", "^[a-zA-Z0-9]+$");
            //check duplicated
            if (checkDuplicationID(listEmployee, id)) {
                System.out.println("Id is existed");
            } else {
                break;
            }
        } while (true);
        String firstName = DataGetter.getString("Enter first name: ", "^[a-zA-Z]+$");
        String lastName = DataGetter.getString("Enter last name: ", "^[a-zA-Z]+$");
        String phone = DataGetter.getString("Enter phone: ", "^[0-9]{10}$");
        String email = DataGetter.getString("Enter email: ", "^[a-zA-Z0-9_]+@[a-z]{2,6}.[a-z]{2,6}$");
        String address = DataGetter.getString("Enter address: ", "^[a-zA-Z0-9- ]+$");
        Date dob = DataGetter.getDate("Enter day of birth: ");
        String sex = DataGetter.getString("Input gender (M: Male or F: Female): ", "m|M|F|f").toUpperCase();
        Double salary = DataGetter.getDouble("Enter salary: ");
        String adency = DataGetter.getString("Enter adency: ", "^[a-zA-Z ]+$");
        listEmployee.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, adency));
        System.out.println("        Add employee successfully       ");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Date Of Birth", "Gender", "Salary", "Egency");
        //loop for first element to last element in list
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println(listEmployee.get(i).toString());
        }
    }

    private void displayMenuUpdate() {
        System.out.println("        Choose information of employee to update    ");
        System.out.println("        1. Update new ID                            ");
        System.out.println("        2. Update new first name                    ");
        System.out.println("        3. Update new last name                     ");
        System.out.println("        4. Update new phone number                  ");
        System.out.println("        5. Update new email                         ");
        System.out.println("        6. Update new address                       ");
        System.out.println("        7. Update new date of birth                 ");
        System.out.println("        8. Update new gender                        ");
        System.out.println("        9. Update new salary                        ");
        System.out.println("        10. Update new agency                       ");
        System.out.println("        11. Exit                                    ");
    }

    void updateEmployees(ArrayList<Employee> listEmployee) {
        String id;
        int choice;
        //check list employee empty
        if (listEmployee.isEmpty()) {
            System.out.println("List employee is empty");
            return;
        }
        id = DataGetter.getString("Enter id to update: ", "^[a-zA-Z0-9]+$");
        //check id exist or not
        if (!checkDuplicationID(listEmployee, id)) {
            System.out.println("ID does not exist in employee list");
        } else {
            int index = findIndexEmployeeByID(listEmployee, id);
            do {
                displayMenuUpdate();
                choice = DataGetter.getOption(1, 11);
                switch (choice) {
                    case 1:
                        String newId;
                        do {
                            newId = DataGetter.getString("Enter new id: ", "^[a-zA-Z0-9]+$");
                            //check duplicated
                            if (checkDuplicationID(listEmployee, newId) && !id.equalsIgnoreCase(newId)) {
                                System.out.println("Id is existed");
                            } else {
                                break;
                            }
                        } while (true);
                        listEmployee.get(index).setId(newId);
                        System.out.println("        Update id successfully!");
                        break;
                    case 2:
                        String newFirstName = DataGetter.getString("Enter new first name: ", "^[a-zA-Z]+$");
                        listEmployee.get(index).setFirstName(newFirstName);
                        System.out.println("        Update first name successfully!");
                        break;
                    case 3:
                        String newLastName = DataGetter.getString("Enter new last name: ", "^[a-zA-Z]+$");
                        listEmployee.get(index).setLastName(newLastName);
                        System.out.println("        Update last name successfully!");
                        break;
                    case 4:
                        String newPhone = DataGetter.getString("Enter new phone: ", "^[0-9]{10}$");
                        listEmployee.get(index).setPhone(newPhone);
                        System.out.println("        Update phone successfully!");
                        break;
                    case 5:
                        String newEmail = DataGetter.getString("Enter new email: ", "^[a-zA-Z0-9_]+@[a-z]{2,6}.[a-z]{2,6}$");
                        listEmployee.get(index).setEmail(newEmail);
                        System.out.println("        Update email successfully!");
                        break;
                    case 6:
                        String newAddress = DataGetter.getString("Enter new address: ", "^[a-zA-Z0-9- ]+$");
                        listEmployee.get(index).setAddress(newAddress);
                        System.out.println("        Update address successfully!");
                        break;
                    case 7:
                        Date newDob = DataGetter.getDate("Enter new day of birth: ");
                        listEmployee.get(index).setDob(newDob);
                        System.out.println("        Update day of birth successfully!");
                        break;
                    case 8:
                        String newSex = DataGetter.getString("Input new gender (M: Male or F: Female): ", "m|M|F|f").toUpperCase();
                        listEmployee.get(index).setSex(newSex);
                        System.out.println("        Update gender successfully!");
                        break;
                    case 9:
                        Double newSalary = DataGetter.getDouble("Enter new salary: ");
                        listEmployee.get(index).setSalary(newSalary);
                        System.out.println("        Update salary successfully!");
                        break;
                    case 10:
                        String newAdency = DataGetter.getString("Enter new adency: ", "^[a-zA-Z ]+$");
                        listEmployee.get(index).setAdency(newAdency);
                        System.out.println("        Update adency successfully!");
                        break;
                    case 11:
                        System.out.println("        Exit        ");
                        break;
                }

            } while (choice != 11);
            System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                    "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                    "Date Of Birth", "Gender", "Salary", "Egency");
            for (int i = 0; i < listEmployee.size(); i++) {
                System.out.println(listEmployee.get(i).toString());
            }
        }

    }

    private int findIndexEmployeeByID(ArrayList<Employee> listEmployee, String id) {
        //check lis employee is empty
        if (listEmployee.isEmpty()) {
            return -1;
        }
        //loop for first employee to last employee in list
        for (int i = 0; i < listEmployee.size(); i++) {
            //Check if current id equals searching id
            if (listEmployee.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    void reremoveEmployee(ArrayList<Employee> listEmployee) {
        String id;
        //check list employee empty
        if (listEmployee.isEmpty()) {
            System.out.println("List employee is empty");
        } else {
            //loop until found remove id in list
            do {
                id = DataGetter.getString("Enter id to remove: ", "^[a-zA-Z0-9]+$");
                if (findIndexEmployeeByID(listEmployee, id) == -1) {
                    System.out.println("ID does not exist in employee list");
                } else {
                    listEmployee.remove(findIndexEmployeeByID(listEmployee, id));
                    break;
                }
            } while (true);
        }
        System.out.println("        Remove employee successfully       ");
        System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                "Date Of Birth", "Gender", "Salary", "Egency");
        //loop for first element to last element in list
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println(listEmployee.get(i).toString());
        }
    }

    //Swap two country in list
    private void swap(ArrayList<Employee> listEmployee, int j, int i) {
        Employee tmp = listEmployee.get(i);
        listEmployee.set(i, listEmployee.get(j));
        listEmployee.set(j, tmp);
    }

    //Sort employees by salary
    void sortEmployeeBySalary(ArrayList<Employee> listEmployee) {
        //Check list is emty
        if (listEmployee.isEmpty()) {
            System.out.println("List employee is empty");
        } else {
            // loop for first employee to last employee in list
            for (int i = 0; i < listEmployee.size(); i++) {
                // loop for first employee to last employee in list is not sorted
                for (int j = 0; j < listEmployee.size() - i - 1; j++) {
                    //Compare each pair of adjacent employee
                    if (listEmployee.get(j).getSalary() >= listEmployee.get(j + 1).getSalary()) {
                        swap(listEmployee, j, j + 1);
                    }
                }
            }
            System.out.println("        Sort employee by salary successfully       ");
            System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                    "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                    "Date Of Birth", "Gender", "Salary", "Egency");
            //loop for first element to last element in list
            for (int i = 0; i < listEmployee.size(); i++) {
                System.out.println(listEmployee.get(i).toString());
            }

        }
    }

    //Search employees
    void searchInformationByName(ArrayList<Employee> listEmployee) {
        //Check list is emty
        if (listEmployee.isEmpty()) {
            System.out.println("List employee is empty");
        } else {
            String searchName = DataGetter.getString("Enter search name: ", "^[a-zA-Z ]+$");
            boolean check = false;
            //loop for first contry to last country in list
            for (int i = 0; i < listEmployee.size(); i++) {
                String name = listEmployee.get(i).getFirstName() + " " + listEmployee.get(i).getLastName();
                if (name.toUpperCase().contains(searchName.toUpperCase())) {
                    check = true;
                }
            }
            //case: found employee
            if (check == true) {
                System.out.printf("%-10s|%-15s|%-15s|%-15s|%-20s|%-15s|%-20s|%-10s|%-15s|%-15s\n",
                        "ID", "First Name", "Last Name", "Phone", "Email", "Address",
                        "Date Of Birth", "Gender", "Salary", "Egency");
                for (int i = 0; i < listEmployee.size(); i++) {
                    String name = listEmployee.get(i).getFirstName() + " " + listEmployee.get(i).getLastName();
                    if (name.toUpperCase().contains(searchName.toUpperCase())) {
                        System.out.println(listEmployee.get(i).toString());
                    }
                }
                //Case: Can't found employee
            } else {
                System.out.println("        Can't find the employee in list       ");
            }
        }
    }

}
