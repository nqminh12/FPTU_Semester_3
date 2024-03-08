/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Object.*;

/**
 *
 * @author Fpt
 */
public class Manager {
    private static Rectangle r = new Rectangle();
    private static Circle c = new Circle();
    private static Triangle t = new Triangle();
    public static void nhap(){
        System.out.println("=====Calculator Shape Program=====");
        
        System.out.println("Please input side width of Rectangle:");
        double width = Validation.check();
        r.setWidth(width);
        
        System.out.println("Please input side length of Rectangle:");
        double length = Validation.check();
        r.setLength(length);
        
        System.out.println("Please input radius of Circle:");
        double radius = Validation.check();
        c.setRadius(radius);
        
        System.out.println("Please input side A of Triangle:");
        double a = Validation.check();
        t.setA(a);
        
        System.out.println("Please input side B of Triangle:");
        double b = Validation.check();
        t.setB(b);
        
        System.out.println("Please input side C of Triangle:");
        double c = Validation.check();
        t.setC(c);
    }
    
    public static void display(){
        r.printResult();
        c.printResult();
        t.printResult();
    }
}
