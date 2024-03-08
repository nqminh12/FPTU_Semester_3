/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Manager.Manager;
import Manager.Validation;

/**
 *
 * @author Fpt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Manager ma = new Manager();
        while (true) {            
            int inBase = Validation.getBase("Enter base input: ","Base invalid!");
            String value = Validation.getValue("Enter value input: ", "Value invalid!", inBase);
            int outBase = Validation.getBase("Enter base output: ", "Base invalid");
            System.out.println("The output: ");
            
            if (outBase == inBase) {
                System.out.println(value.trim());
                break;
            } else if (outBase == 10) {
                System.out.println(ma.otherToDec(value, inBase));
                break;
            } else if (inBase == 10) {
                System.out.println(ma.decToOther(Integer.parseInt(value), outBase));
                break;
            } else {
                System.out.println(ma.decToOther(ma.otherToDec(value, inBase), outBase));
                break;
            }
        }
    
}
}