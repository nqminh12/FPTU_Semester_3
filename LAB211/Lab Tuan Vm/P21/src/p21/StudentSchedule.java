/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p21;

/**
 *
 * @author Admin
 */
public class StudentSchedule implements Comparable<StudentSchedule>{
    private String ID;
    private String studentName;
    private int semester;
    private String courseName;

    public StudentSchedule() {
    }

    public StudentSchedule(String ID, String studentName, int semester, String courseName) {
        this.ID = ID;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%-15s|%-15s|%-10d|%-20s", ID, studentName, semester, courseName);
    }
    @Override
    public int compareTo(StudentSchedule s) {
        return this.studentName.compareTo(s.studentName);
    }
                 
}
