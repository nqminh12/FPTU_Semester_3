
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duy
 */
public class Manager {
    public static boolean checkOdd(double n){
        if(n % 2 != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean checkEven(double n){
        if(n % 2 == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean checkSquareNumber(double n){
        if( Math.sqrt(n) * Math.sqrt(n) == n){
            return true;
        }else{
            return false;
        }
    }
    
    public static void superlativeEquation(){
        double a = Validation.getNumber("Enter A: ", "Please input number", 
                Double.MIN_VALUE, Double.MAX_VALUE);
        double b = Validation.getNumber("Enter B: ", "Please input number", 
                Double.MIN_VALUE, Double.MAX_VALUE);
        //xet truong hop vo nghiem
        if(a==0 && b != 0){
            System.out.println("Have no solution");
        }else{
        double x =  (-b)/ a;
         System.out.println("Solution: "+x);
         
         double[] arr= {a,b,x};
            System.out.print("Odd is: ");
         for(int i = 0; i < arr.length; i++){
             if(checkOdd(arr[i])){
                 System.out.print(arr[i]+" ");
             }
         }
            System.out.println();
         System.out.print("Even is: ");
         for(int i = 0; i < arr.length; i++){
             if(checkEven(arr[i])){
                 System.out.print(arr[i]+" ");
             }
         }
            System.out.println();
            System.out.print("Perfect square is: ");
            for(int i = 0; i < arr.length; i++){
                if(checkSquareNumber(arr[i])){
                    System.out.println(arr[i]+" ");
                }
            }
            System.out.println();
        }
       
    }
  
    public static void quadraticEquation(){
        double a = Validation.getNumber("Enter A: ", "Please input number", 
                Double.MIN_VALUE, Double.MAX_VALUE);
        double b = Validation.getNumber("Enter B: ", "Please input number", 
                Double.MIN_VALUE, Double.MAX_VALUE);       
        double c = Validation.getNumber("Enter C: ", "Please input number", 
                Double.MIN_VALUE, Double.MAX_VALUE);
        double delta = b*b - 4*a*c;
        double y = -c/b;
        double x = (-b)/(2*a);
        double x1 = (-b + Math.sqrt(delta))/(2*a);
        double x2 = (-b - Math.sqrt(delta))/(2*a);
        //TH1: a = 0, nghiem = -c/b
        if(a == 0){
            System.out.println("Solution: " + y);
        }
        else{
        //TH2: a != 0, delta = 0 => co 1 nghiem kep
        if(delta == 0){
            System.out.println("Have two solution x1 = x2 = : " + x);
        }
        //TH3: a != 0, delta > 0 => co 2 nghiem phan biet
        else if(delta > 0){
            System.out.println("Solution: x1= "+x1+" x2= "+x2);
        }
        //TH4: a != 0, delta < 0 => ptrinh vo nghiem
        else if(delta < 0){
            System.out.println("Have no solution");
        }
        }
        
        //check odd
        System.out.print("Odd is: ");
        if(checkOdd(a)){
            System.out.print(a + " ");          
        }
        if( b != a && checkOdd(b)){
            System.out.print(b + " ");          
        }
        if(c != b && c != a && checkOdd(c)){
            System.out.print(c + " ");          
        }
         if(a==0 && checkOdd(y) && y != a && y != b && y != c){
            System.out.print(y + " ");
        }
        if(a!=0 && checkOdd(x) && delta == 0 && x != a && x != b && x != c){
            System.out.print(x+" ");
        }
        if(a!=0 && delta>0 && checkOdd(x1)&& x1 != a && x1 != b && x1 != c && x1 != x2){
            System.out.print(x1+" ");
        }
        if(a!=0 && delta>0 && checkOdd(x2) && x2 != a && x2 != b && x2 != c && x2 != x1){
            System.out.print(x2+" ");
        }
        System.out.println();
        
        //check Even
         System.out.print("Even is: ");
          if(checkEven(a)){
            System.out.print(a + " ");          
        }
        if( b != a && checkEven(b)){
            System.out.print(b + " ");          
        }
        if(c != b && c != a && checkEven(c)){
            System.out.print(c + " ");          
        }
          if(a==0 && checkEven(y) && y != a && y != b && y != c){
            System.out.print(y + " ");
        }
        if(a!=0 && checkEven(x) && delta == 0 && x != a && x != b && x != c){
            System.out.print(x+" ");
        }
        if(a!=0 && delta>0 && checkEven(x1) && x1 != a && x1 != b && x1 != c && x1 != x2){
            System.out.print(x1+" ");
        }
        if(a!=0 && delta>0 && checkEven(x2) && x2 != a && x2 != b && x2 != c && x2 != x1){
            System.out.print(x2+" ");
        }
            System.out.println();
           
            //check Perfect square
            System.out.print("Perfect square is: ");
            if(checkSquareNumber(a)){
            System.out.print(a + " ");          
        }
        if( b != a && checkSquareNumber(b)){
            System.out.print(b + " ");          
        }
        if(c != b && c != a && checkSquareNumber(c)){
            System.out.print(c + " ");     
        if(a==0 && checkSquareNumber(y) && y != a && y != b && y != c){
            System.out.print(y + " ");
        }
        if(a!=0 && checkSquareNumber(x) && delta == 0 && x != a && x != b && x != c){
            System.out.print(x+" ");
        }
        if(a!=0 && delta>0 && checkSquareNumber(x1) && x1 != a && x1 != b && x1 != c && x1 != x2){
            System.out.print(x1+" ");
        }
        if(a!=0 && delta>0 && checkSquareNumber(x2) && x2 != a && x2 != b && x2 != c && x2 != x1){
            System.out.print(x2+" ");
        }
        System.out.println();

    }
}
}
