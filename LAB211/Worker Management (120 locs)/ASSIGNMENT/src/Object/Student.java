/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Fpt
 */
public class Student {
    private String id;
    private String fullName;
    private String sex;
    private double progressTese;
    private double assignment;
    private double workShop;
    private double practicalExam;
    private double finalExam;

    public Student() {
    }

    public Student(String id, String fullName, String sex, double progressTese, double assignment, double workShop, double practicalExam, double finalExam) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
        this.progressTese = progressTese;
        this.assignment = assignment;
        this.workShop = workShop;
        this.practicalExam = practicalExam;
        this.finalExam = finalExam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getProgressTese() {
        return progressTese;
    }

    public void setProgressTese(double progressTese) {
        this.progressTese = progressTese;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public double getWorkShop() {
        return workShop;
    }

    public void setWorkShop(double workShop) {
        this.workShop = workShop;
    }

    public double getPracticalExam() {
        return practicalExam;
    }

    public void setPracticalExam(double practicalExam) {
        this.practicalExam = practicalExam;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
    @Override
    public String toString(){
    return String.format("%s | %20s | %5s | %-7.1f | %-7.1f | %-7.1f | %-7.1f | %-7.1f ", id, fullName, sex,progressTese, assignment,workShop,practicalExam,finalExam );
}

   
    
}
