/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import object.SalaryHistory;
import object.Worker;

/**
 *
 * @author Fpt
 */
public class Management {
    private Scanner sc = new Scanner(System.in);
    private List<Worker> wlist;
    private List<SalaryHistory> shlist;
    final double epsi = 0.00001;

    public Management() {
        wlist = new ArrayList<>();
        shlist = new ArrayList<>();
    }

    

    
    
    public void addWorker(){
        String id, name, workLocation;
        int age;
        double salary;
        
        id = Validation.getCode("Enter worker id: ", "Id should be unique and not null!", wlist, 1);
        System.out.print("Enter worker name:");
        name = sc.nextLine();
        age = Validation.getInt("Enetr worker age: ", 18, 50);
        salary = Validation.getDouble("Enter worker salary: ", epsi, Double.MAX_VALUE);
        System.out.print("Enter worker location:");
        workLocation = sc.nextLine();
        wlist.add(new Worker(id, name, age, salary, workLocation));
    }
    
    public void updatesalary(int mode){
        String id = Validation.getCode("Enter worker id to be update: ", "ID must exist in database and not null", wlist, 2);
        double money = Validation.getDouble("Amount of money: ", epsi, Double.MAX_VALUE);
        Worker o = Validation.getWorker(id, wlist);
        String status = "";
        double update = 0;
        
        if(mode == 1){
            update = o.getSalary() + money;
            status = "UP";
        } else if(mode == 2){
            if(o.getSalary() > money)
            {
                update = o.getSalary() - money;
                status = "DOWN";
            }
        }
        
        o.setSalary(update);
        shlist.add(new SalaryHistory(id, o.getName(), o.getAge(), o.getSalary(), status, java.time.LocalDate.now()));
    }
    
    public void getInformation(){
        display(shlist);
    }
    public void displayAll(){
        display(wlist);
    }
    private void display(List list){
        for(Object o : list){
            System.out.println(o);
        }
    }
    
    
}
