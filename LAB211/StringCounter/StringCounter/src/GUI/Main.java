/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Fpt
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private Map<Character, Integer> charCounter = new HashMap<Character, Integer>();//khởi tạo map để đếm kí tự
    private Map<String, Integer> wordCounter = new Hashtable<>();// khởi tạo map khác để đếm chữ(word)
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");// nhập chuỗi cần đếm
        String s = sc.nextLine();
        
        Main m = new Main();
        m.analyze(s);
        m.display();
        
        
    }
    
    // in ra ngay map nó sẽ trả về 1 mảng gồm key và value với key là các chữ value sẽ là số lần chữ hoặc từ đó xuất hiện
    private void display() {
        System.out.println(charCounter);
        System.out.println(wordCounter);
    }
    
    
    //truyền chuỗi s người dùng nhập vào cho phương thức, sau khi hàm thực hiện xg 2 map sẽ được lần lượt key value mới
    private void analyze(String s) {
        // đếm từng chữ trong phần tử và số lần chúng xuất hiện
        for(char o: s.toCharArray()){// dùng for-each lặp qua từng phần tử chữ sau khi chuỗi đã chuyển thành charArray(abc ->{a,b,c})
            if(Character.isSpaceChar(o)){// nếu là phần tử cách(dấu cách) ta sẽ bỏ qua
                continue;
            }
            if(!charCounter.containsKey(o)){//điều kiện này dùng để check xem phần tử duyệt đến đã tòn tại trong chuỗi chưa
                charCounter.put(o, 1);// nếu chưa tồn tại (!charCounter.containsKey(o)= true) thì ta put phần tử mới với key là chữ đó value là 1 
            } else{// nếu tồn tại rồi thì ta cộng thêm 1 cho key(phần tử này trước đó được tìm thấy và set bằng 1 h lại bị laowj qua)
                charCounter.put(o, ((int)charCounter.get(o) + 1));
            }
        }
 // cách bình thường tách word ra khỏi chuỗi r đếm       
//        String[] a = s.split("\\s+") ;
//        for(String o: a){
//            if(!wordCounter.containsKey(o)){
//                wordCounter.put(o, 1);
//            } else{
//                wordCounter.put(o, ((int)wordCounter.get(o) + 1));
//            }
//        }

// cách được gợi ý dùng lớp StringTokenizer
        StringTokenizer tokenizer = new StringTokenizer(s);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {// nếu chưa tồn tại (contain) thì put key mới với value bằng 1
                wordCounter.put(token, 1);
            } else {// đã có rồi thì cộng thêm 1
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
        
    }
    
}
