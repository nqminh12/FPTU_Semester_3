/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Fpt
 */
public class Option {
    public void addStudent(List<Student> list, String name, String classes, double math, double physical, double chemistry){
        list.add(new Student(name, classes, math, physical, chemistry));
    }
    public void display(List<Student> list){
        int index = 1;
        for (Student o : list) {
            System.out.println("------ Student"+ index +  " Info ------");
            o.display();
            index++;
        }
    }
    public HashMap<String, Double> getPercentTypeStudent(List<Student> list){
        HashMap<String, Double> hashMap = new HashMap<>();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        for (Student o : list) {
            if(o.getAVG() > 7.5){
                countA++;
            }else if(o.getAVG() >= 6){
                countB++;
            } else if(o.getAVG() >= 4){
                countC++;
            } else{
                countD++;
            }
        }
        int totalStudent = list.size();
        hashMap.put("A", 100.0 * countA/totalStudent);
        hashMap.put("B", 100.0 * countB/totalStudent);
        hashMap.put("C", 100.0 * countC/totalStudent);
        hashMap.put("D", 100.0 * countD/totalStudent);
        
        return hashMap;
    }
}
