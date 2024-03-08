/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Manager.*;
import java.util.Scanner;
import Object.*;

/**
 *
 * @author Fpt
 */
public class Menu {
    private static String ops[] = {
        "Viết hàm nhập vào danh sách N sinh viên (với các trường đã khai báo ở trên sau khi kết thúc chương trình tự tính điểm ).",
        "Viết hàm in ra danh sách sinh viên vừa nhập.",
        "Viết hàm thêm sinh viên vào danh sách (thêm một sinh viên mới vào danh sách)",
        "Viết hàm tìm kiếm (dựa vào mã sinh viên) in ra thông tin của sinh viên vừa được tìm.",
        "Viết hàm xóa sinh viên ra khỏi danh sách dựa vào mã sinh viên",
        "Viết hàm tính điểm Result cho N sinh viên với công thức 10% Progress test + 10% Assignment + 10% Workshop + 40% Practical Exam + 30% Final exam.",
        "Viết hàm kiểm tra sinh viên hoàn thành dựa vào tiêu chí tất các điểm thành phần >0 và điểm thi Final exam>=4 và Result >=5 (kiểm tra điều kiện và đưa ra thông báo sinh viên completed / incompleted).",
        "Viết hàm in danh sách ra file.",
        "Thoát!"
            
    };
    
    private static int getChoice(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < ops.length; i++)
        {
            System.out.println((i + 1) + ". " + ops[i]);
        }
        return Validation.getInt("Enter choice: ", 1, ops.length + 1);
    }
    
    public static void display(){
        Management n = new Management();
        int choice;
        do{
            System.out.println("======= Quản lí sinh viên =======");
            choice = getChoice();
            switch (choice) {
                case 1:
                    n.function1();
                    break;
                case 2:
                    n.function2();
                    break;
                case 3:
                    n.function3();
                    break;
                case 4:
                    n.function4();
                    break;
                case 5:
                    n.function5();
                    break;
                case 6:
                    n.function6();
                    break;
                case 7:
                    n.function7();
                    break;
                case 8:
                    n.function8();
                    break;
                case 9:
                    break;
            }
            
        }while(choice != 9);
        
    }
}
