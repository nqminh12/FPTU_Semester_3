/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhanvien;

/**
 *
 * @author Administrator
 */
public class BangNhanVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NhanVien doctor = new NhanVien("Linh",18,"HE172208","Good",1000000);
        //NhanVien(String ten, int tuoi, String Ms, String Status, double Salary) 
        doctor.printIn4();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        doctor.setTen("Minh");
        doctor.setTuoi(20);
        doctor.setMs("HE176167");
        doctor.setSalary(1000);
        doctor.printIn4();
        
        
    }
    
}
