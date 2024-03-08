/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p21;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class StudentScheduleManager {

    private boolean checkDuplicateID(ArrayList<StudentSchedule> studentList, String id, String studentName) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equalsIgnoreCase(id) && !studentList.get(i).getStudentName().equalsIgnoreCase(studentName)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDuplicateSchedule(ArrayList<StudentSchedule> studentList, String id, String studentName, int semester, String courseName) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equalsIgnoreCase(id)
                    && studentList.get(i).getStudentName().equalsIgnoreCase(studentName)
                    && studentList.get(i).getSemester() == semester
                    && studentList.get(i).getCourseName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    private int getIndexByID(String searchingID, ArrayList<StudentSchedule> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equalsIgnoreCase(searchingID)) {
                return i;
            }
        }

        return -1;
    }

    void create(ArrayList<StudentSchedule> studentList) {
        while (true) {
            System.out.println("----- Add -----");
            System.out.println("Enter info student " + (studentList.size() + 1));
            String id = DataGetter.getString("Enter Student ID: ", "^[0-9a-zA-Z]+$").toUpperCase();
            String studentName = DataGetter.getString("Enter Student Name: ", "^[a-zA-Z]+$");
            do {
                if (checkDuplicateID(studentList, id, studentName)) {
                    System.out.println("ID already exists in the list");
                    System.out.println(studentList.get(getIndexByID(id, studentList)).toString());
                    String choice = DataGetter.getString("Do you want to use it (Y/N)? ", "y|n|Y|N");
                    if (choice.equalsIgnoreCase("y")) {
                        studentName = DataGetter.getString("Please enter agian name (name must be "
                                + studentList.get(getIndexByID(id, studentList)).getStudentName() + "): ",
                                studentList.get(getIndexByID(id, studentList)).getStudentName());
                    } else {
                        id = DataGetter.getString("Enter Student ID agian: ", "^[0-9a-zA-Z]+$");
                        studentName = DataGetter.getString("Enter Student Name agian: ", "^[a-zA-Z]+$");
                    }
                }
            } while (checkDuplicateID(studentList, id, studentName));
            int semester = DataGetter.getInteger("Enter semester: ");
            String courseName = DataGetter.getString("Enter Courese Name (Java, .Net, C/C++): ", "^(Java|.Net|C/C\\+\\+)$");
            if (!checkDuplicateSchedule(studentList, id, studentName, semester, courseName)) {
                studentList.add(new StudentSchedule(id, studentName, semester, courseName));
                System.out.println("Add successfully");
            } else {
                System.out.println("The student enrolled in the course! Please enter again");
            }
            if (studentList.size() >= 3) {
                String choice = DataGetter.getString("Do you want to continue (Y/N)? ", "y|n|Y|N");
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }
        displayList(studentList);

    }

    void findAndSort(ArrayList<StudentSchedule> studentList) {
        System.out.println("----- Find and sort -----");
        if (studentList.isEmpty()) {
            System.out.println("List student schedule is empty");
        } else {
            String name = DataGetter.getString("Enter Student Name or part of Student Name: ", "^[a-zA-Z]+$");
            ArrayList<StudentSchedule> listFindByName = listFindByName(studentList, name);
            if (listFindByName.isEmpty()) {
                System.out.println("Can't find student with enter name");
            } else {
                Collections.sort(listFindByName);
                displayList(listFindByName);
            }
        }
    }

    private ArrayList<StudentSchedule> listFindByName(ArrayList<StudentSchedule> studentList, String name) {
        ArrayList<StudentSchedule> listFindByName = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listFindByName.add(studentList.get(i));
            }
        }
        return listFindByName;
    }

    private ArrayList<StudentSchedule> listFindByID(ArrayList<StudentSchedule> studentList, String ID) {
        ArrayList<StudentSchedule> listFindByID = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().toUpperCase().contains(ID.toUpperCase())) {
                listFindByID.add(studentList.get(i));
            }
        }
        return listFindByID;
    }

    private void displayListFindByID(ArrayList<StudentSchedule> listFindByID) {
        System.out.printf("%-10s|%-15s|%-15s|%-10s|%-20s", "Number", "ID", "StudentName", "Semester", "CourseName");
        System.out.println();
        for (int i = 0; i < listFindByID.size(); i++) {
            String str = String.format("%-10d|%-15s|%-15s|%-10d|%-20s", i + 1,
                    listFindByID.get(i).getID(), listFindByID.get(i).getStudentName(),
                    listFindByID.get(i).getSemester(), listFindByID.get(i).getCourseName());
            System.out.println(str);
        }
    }

    void updateOrDelete(ArrayList<StudentSchedule> studentList) {
        System.out.println("----- Update or delete -----");
        if (studentList.isEmpty()) {
            System.out.println("List student schedule is empty");
        } else {
            displayList(studentList);
            String ID = DataGetter.getString("Enter Student ID for update or delete: ", "^[0-9a-zA-Z]+$").toUpperCase();
            ArrayList<StudentSchedule> listFindByID = listFindByID(studentList, ID);
            if (listFindByID.isEmpty()) {
                System.out.println("That id not exist in student schedule list");
            } else {
                displayListFindByID(listFindByID);
                String choice = DataGetter.getString("Do you want to update (U) or delete (D) student: ", "[DUdu]");
                if (choice.equalsIgnoreCase("u")) {
                    System.out.println("----- Update -----");
                    int index = DataGetter.getOption("Enter record of student schedule for update: ", 1, listFindByID.size()) - 1;
                    StudentSchedule studentForUpdate = listFindByID.get(index);
                    String newID = DataGetter.getString("Enter new Student ID: ", "^[0-9a-zA-Z]+$").toUpperCase();
                    String newStudentName = DataGetter.getString("Enter  new Student Name: ", "^[a-zA-Z]+$");
                    do {
                        if (checkDuplicateID(studentList, newID, newStudentName)) {
                            System.out.println("ID already exists in the list");
                            System.out.println(studentList.get(getIndexByID(newID, studentList)).toString());
                            String option = DataGetter.getString("Do you want to use it (Y/N)? ", "y|n|Y|N");
                            if (option.equalsIgnoreCase("y")) {
                                newStudentName = DataGetter.getString("Please enter agian name (name must be "
                                        + studentList.get(getIndexByID(newID, studentList)).getStudentName() + "): ",
                                        studentList.get(getIndexByID(newID, studentList)).getStudentName());
                            } else {
                                newID = DataGetter.getString("Enter new Student ID agian: ", "^[0-9a-zA-Z]+$");
                                newStudentName = DataGetter.getString("Enter new Student Name agian: ", "^[a-zA-Z]+$");
                            }
                        }
                    } while (checkDuplicateID(studentList, newID, newStudentName));
                    int newSemester = DataGetter.getInteger("Enter new semester: ");
                    String newCourseName = DataGetter.getString("Enter new Courese Name (Java, .Net, C/C++): ", "^(Java|.Net|C/C\\+\\+)$");
                    if (!checkDuplicateSchedule(studentList, newID, newStudentName, newSemester, newCourseName)) {
                        studentForUpdate.setID(newID);
                        studentForUpdate.setStudentName(newStudentName);
                        studentForUpdate.setSemester(newSemester);
                        studentForUpdate.setCourseName(newCourseName);
                        System.out.println("Update successfully");
                        displayList(studentList);
                    } else {
                        System.out.println("The student enrolled in the course! Can't update");
                    }
                } else {
                    System.out.println("----- Delete -----");
                    int index = DataGetter.getOption("Enter the number of record student for update: ", 1, listFindByID.size()) - 1;
                    studentList.remove(index);
                    displayList(studentList);
                }
            }
        }
    }

    private int count(ArrayList<StudentSchedule> studentList, String id, String studentName, String coureName) {
        int count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getID().equalsIgnoreCase(id)
                    && studentList.get(i).getStudentName().equalsIgnoreCase(studentName)
                    && studentList.get(i).getCourseName().equalsIgnoreCase(coureName)) {
                count += 1;
            }
        }

        return count;
    }

    private void displayList(ArrayList<StudentSchedule> studentList) {
        System.out.printf("%-15s|%-15s|%-10s|%-20s", "ID", "StudentName", "Semester", "CourseName");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }

    void report(ArrayList<StudentSchedule> studentList) {
        System.out.println("----- Report -----");
        ArrayList<StudentSchedule> listTmp = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            listTmp.add(studentList.get(i));
        }
        if (listTmp.isEmpty()) {
            System.out.println("List student schedule is empty");
        }
        for (int i = 0; i < listTmp.size(); i++) {
            int count = count(listTmp, listTmp.get(i).getID(), listTmp.get(i).getStudentName(), listTmp.get(i).getCourseName());
            String display = String.format("%-15s|%-15s|%-15s", listTmp.get(i).getStudentName(),
                    listTmp.get(i).getCourseName(), count);
            System.out.println(display);
            for (int j = i + 1; j < listTmp.size(); j++) {
                if (listTmp.get(j).getID().equalsIgnoreCase(listTmp.get(i).getID())
                        && listTmp.get(j).getStudentName().equalsIgnoreCase(listTmp.get(i).getStudentName())
                        && listTmp.get(j).getCourseName().equalsIgnoreCase(listTmp.get(i).getCourseName())) {
                    listTmp.remove(j);
                    j--;
                }
            }
        }
    }

}
