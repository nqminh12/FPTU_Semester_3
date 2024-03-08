/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Object.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fpt
 */
public class Management {
    private Scanner sc = new Scanner(System.in);
    private List<Student> slist;
    private List<Result> rlist;
    private List<Comple> clist;
    final double epsi = 0.00001;

    public Management() {
        slist = new ArrayList<>();
        rlist = new ArrayList<>();
        clist = new ArrayList<>();
    }
    //function 1
    public void function1(){
        String id, fullname, sex;
        double progressTese,assignment,workShop,practicalExam,finalExam;
        
        id = Validation.getCode("Enter student's id: ", "Id should be unique and not null!", slist, 1);
        System.out.println("Enter student's full name: ");
        fullname = sc.nextLine();
        sex = Validation.getSex("Enter student's sex(Nam - Nu): ", "You must enter Nam - Nu");
        progressTese = Validation.getDouble("Enter Progress test mark: ", epsi, Double.MAX_VALUE);
        assignment = Validation.getDouble("Enter Assignment mark: ", epsi, Double.MAX_VALUE);
        workShop = Validation.getDouble("Enter Workshop mark: ", epsi, Double.MAX_VALUE);
        practicalExam = Validation.getDouble("Enter Practical Exam mark: ", epsi, Double.MAX_VALUE);
        finalExam = Validation.getDouble("Enter Final exam mark: ", epsi, Double.MAX_VALUE);
        
        slist.add(new Student(id, fullname, sex, progressTese, assignment, workShop, practicalExam, finalExam));
    }
    
    //function 2
    public void function2(){
        display(slist);
    }
    //function 3
    public void function3(){
        
    }
    //function 4
    public void function4(){
        System.out.println("Enter id of the student who you want to find:");
        String id = sc.nextLine();
        Student s = Validation.getStudent(slist, id);
        if(s == null){
            
            System.out.println("Can't find student information1");
        } else
        {
            System.out.println(s);
        }
    }
    
    //function 5
    
    public void function5(){
        System.out.println("Enter id of the student who you want to remove");
        String id = sc.nextLine();
        Student s = Validation.getStudent(slist, id);
        if(s == null){
            System.out.println("Can't find student!");
        }else
        {
            slist.remove(s);
        }
    }
    
    //function 6
    public void function6(){
        
    }
    
    //function 7
    public void function7(){
        
    }
    //function 8
    public void function8(){
        
    }
    
    public void display(List list){
        for(Object o : list){
            System.out.println(o);
        }
    }
    
}
