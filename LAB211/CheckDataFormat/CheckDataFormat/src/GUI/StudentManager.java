/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class StudentManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Nguyen Quang Minh", "full", 9, 9, 9));
        Option op = new Option();
        System.out.println("====== Management Student Program ======");
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.println("Name: ");
            String name = sc.nextLine();
            System.out.println("Class: ");
            String classes = sc.nextLine();
            System.out.println("Math: ");
            double math = Double.parseDouble(sc.nextLine());
            System.out.println("Chemistry: ");
            double chemistry = Double.parseDouble(sc.nextLine());
            System.out.println("Physical:");
            double physical = Double.parseDouble(sc.nextLine());
            op.addStudent(list, name, classes, math, physical, chemistry);
            String choice = Vadilation.inputYN();
            if(choice.equalsIgnoreCase("N")){
                break;
            }
        }
        
        op.display(list);
        System.out.println("--------Classification Info -----");
        HashMap<String, Double> mapStudent = op.getPercentTypeStudent(list);
        
        for(String i : mapStudent.keySet()){
            System.out.println(i + ": " + mapStudent.get(i) + "%");
        }
    }
    
}
