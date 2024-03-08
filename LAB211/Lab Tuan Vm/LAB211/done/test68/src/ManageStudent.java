
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class ManageStudent {

    public static void main(String[] args) {
        ArrayList<Student> student = new ArrayList<>();
        // user enter student information 
        getStudentInformation(student);
        // sort students name from A to Z
        sortStudentByName(student);
        // display student information 
        displayStudentInformation(student);
    }

    private static void getStudentInformation(ArrayList<Student> student) {
        do {
            System.out.println("====== Collection Sort Program ======");
            String name = Validation.inputString("Name: ");
            String classes = Validation.inputString("Classes: ");
            float mark = Validation.inputFloat("Mark: ", 0, 100);
            student.add(new Student(name, mark, classes));
        } while (Validation.checkYN());
    }
    
    private static List <Student> sortStudentByName(ArrayList<Student> student) {
        Collections.sort(student);
        return student;
    }
    
    private static void displayStudentInformation(ArrayList<Student> student) {       
        for (int i = 0; i < student.size(); i++) {
            System.out.println("--------Student " + (i + 1) + "--------");
            System.out.println("Name: " + student.get(i).getName());
            System.out.println("Classes: " + student.get(i).getClasses());
            System.out.println("Mark: " + student.get(i).getMark());
        }
    }

}
