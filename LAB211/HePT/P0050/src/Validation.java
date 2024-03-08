
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duy
 */
public class Validation {
    public static int getChoice(String message, String error, int min, int max){
    while(true){
    try{
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int number = Integer.parseInt(scanner.nextLine());
        if(number <= 0){
            System.out.println(error);
        }else{
            return number;
        }
    }catch(NumberFormatException e){
        System.out.println(error);
    }
}
}
    
    public static double getNumber(String message, String error, double min, double max){
    while(true){
    try{
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int number = Integer.parseInt(scanner.nextLine());
            return number;
    }catch(NumberFormatException e){
        System.out.println(error);
    }
}
}
}
