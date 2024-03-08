/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Object.Circle;
import Object.Rectangle;
import Object.Triangle;

/**
 *
 * @author Fpt
 */
public class Manager {
    private static Circle cir = new Circle();
    private static Rectangle rec = new Rectangle();
    private static Triangle tri = new Triangle();
    
    
    public void Nhap(){
        System.out.println("=====Calculator Shape Program=====");
        
        System.out.println("Please input side width of Rectangle:");
        double width = Validation.check();
        rec.setWidth(width);
        
        System.out.println("Please input length of Rectangle:");
        double hight = Validation.check();
        rec.setLength(hight);
        
        System.out.println("Please input radius of Circle:");
        double radius = Validation.check();
        cir.setRadius(radius);
        
        System.out.println("Please input side A of Triangle:");
        double a = Validation.check();
        tri.setA(a);
        
        System.out.println("Please input side B of Triangle:");
        double b = Validation.check();
        tri.setB(b);
        
        System.out.println("Please input side C of Triangle:");
        double c = Validation.check();
        tri.setC(c);
        
        
    }
    public void dissplay(){
        rec.printResult();
        cir.printResult();
        tri.printResult();
    }
}
