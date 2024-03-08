
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author trinh
 */
public class Options {

    public String inputYN() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N):");
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("N")||choice.equalsIgnoreCase("Y")){
                return choice;
            }else{
                System.out.println("Please input Y or N");
            }
        }
    }

    public void addStudent(List<Student> list, String name, String className, double math,
            double chemistry, double physical) {
        list.add(new Student(name, className, math, physical, chemistry));
    }

    public void display(List<Student> list) {
        int index = 0;
        for (Student o : list) {
            System.out.println("------ Student" + index + " Info ------");
            o.dislay();
            index++;
        }
    }

    public HashMap<String, Double> getPercentTypeStudent(List<Student> list) {
        //A: 30%
        //B: 20%
        //C: 40%
        //D: 10%
        HashMap<String, Double> hashMap = new HashMap<>();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        for (Student o : list) {
            if (o.getAVG() > 7.5) {
                countA++;
            } else if (o.getAVG() >= 6) {
                countB++;
            } else if (o.getAVG() >= 4) {
                countC++;
            } else {
                countD++;
            }
        }
        int totalStudent = list.size();
        hashMap.put("A", 100.0 * countA / totalStudent);
        hashMap.put("B", 100.0 * countB / totalStudent);
        hashMap.put("C", 100.0 * countC / totalStudent);
        hashMap.put("D", 100.0 * countD / totalStudent);
        return hashMap;
        //
    }
}
