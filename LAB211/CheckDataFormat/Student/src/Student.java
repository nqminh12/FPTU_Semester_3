/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trinh
 */
public class Student {
    private String name;
    private String className;
    private double math;
    private double physical;
    private double chemistry;

    public Student() {
    }

    public Student(String name, String className, double math, double physical, double chemistry) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }
    public String getType(double avg){
        if(avg > 7.5){
            return "A";
        }else if(avg>=6){
            return "B";
        }else if(avg >=4){
            return "C";
        }else return "D";
    }
    public double getAVG(){
        double avg = (math + physical + chemistry)/3;
        return avg;
    }
    public void dislay(){
        System.out.println("Name: "+name);
        System.out.println("Classes: "+className);
        double avg = (math + physical + chemistry)/3;
        System.out.printf("AVG: %.2f\n",avg);
        System.out.println("Type: "+getType(avg));
    }
}
