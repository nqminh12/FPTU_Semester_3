/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

/**
 *
 * @author Fpt
 */
public class Manager {
//    public int otherToDec(String value, int base){
//        int result = 0;
//        String HEX = "0123456789ABCDEF";// đặt để không phải đổi hay dùng if else chuyển A thành 10 cũng như các số khác
//        value = value.toUpperCase();
//        for (int i = 0; i < value.length(); i++) {
//            result += HEX.indexOf(value.charAt(i)) * Math.pow(base, value.length() - 1 - i);// duyệt từ trái sang phải 
//            
//        }
//        return result;
//    }
//    
//    public String decToOther(int dec, int base){
//        String result = "";
//        String HEX = "0123456789ABCDEF";
//        while(dec > 0){
//            result = HEX.charAt(dec%base) + result;
//            dec/= base;
//            
//        }
//        return result;
//    }
    
    public int otherToDec(String value, int base){
        int dec = 0;
        String HEX = "0123456789ABCDEF";
        value = value.toUpperCase();
        for (int i = 0; i < value.length(); i++) {
            dec += HEX.indexOf(value.charAt(i))*Math.pow(base, value.length() - 1 - i);
        }
        return dec;
    }
    
    public String decToOther(int dec, int base){
        String value = "";
        String HEX = "0123456789ABCDEF";
        while (dec > 0) {
            value = HEX.charAt(dec % base) + value;
            dec /= base;
        }
        

        return value;
        
    }
    
    
}
