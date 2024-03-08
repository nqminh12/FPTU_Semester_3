/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class NhanVien {
    private String ten;// thuoc tinh cua lop 
    private int tuoi; // thuoc tinh cua lop
    private String Ms;// thuoc tinh cua lop
    private String Status;// thuoc tinh cua lop
    private double Salary;// thuoc tinh cua lop

    public NhanVien() {
    }

    public NhanVien(String ten, int tuoi, String Ms, String Status, double Salary) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.Ms = Ms;
        this.Status = Status;
        this.Salary = Salary;
    }

    

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getMs() {
        return Ms;
    }

    public void setMs(String Ms) {
        this.Ms = Ms;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Ten: " + ten + ", tuoi: " + tuoi + ", Ms: " + Ms + ", Status: " + Status + ", Salary: " + Salary;
    }
    public void printIn4(){
        System.out.println("Name : " + ten);
        System.out.println("Tuoi : " + tuoi);
        System.out.println("Ma So : " + Ms);
        System.out.println("Trang thai : " + Status);
        System.out.println("Luong : " + Salary);
    }
    
    
} 

