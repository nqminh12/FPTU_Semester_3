/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 *
 * @author Fpt
 */
public class myGraph {
    int [][] a;
    int size;

    public myGraph() {
        try {
            RandomAccessFile raf = new RandomAccessFile("input.txt", "r");
            size = Integer.parseInt(raf.readLine());
            a = new int[size][size];
            String s1 = "";
            int k  = 0;
            while((s1 = raf.readLine()) != null){
                String [] s = s1.split("\\s+");
                for(int i = 0 ; i < size ; i++){
                    a[k][i] = Integer.parseInt(s[i]);
                }
                k++;
            }
            for(int i = 0 ; i < size; i++){
                for (int j = i + 1; j < size; j++) {
                    a[j][i] = a[i][j];
                }
            }
        } catch (Exception e) {
        }
        
    }
    void display(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    char toChar(int x){
        return(char)(x + 65);
    }
    int toInt(char c){
        return c - 65;
    }
    void visit(int p){
        System.out.print(toChar(p) + " -> ");
    }
    int deg(int x){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(a[i][x] != 0 ) count++;
        }
        return count; 
    }
    void Breadth_first(char x){
        boolean [] visited = new boolean[size];// dùng để check xem điểm đó đã duyệt chưa nếu r thì là truê ko thì false
        Arrays.fill(visited, false);// lấy đầy mảng bằng giá trị false
        int p = toInt(x);// thứ tự của điểm 
        myQueue my = new myQueue();// cho vào queue
        my.EnQueue(p);
        while (!my.isEmpty()) {            
            int q = my.DeQueue();// xóa và bắt đầu duyệt
            visited[q] = true;
            for (int i = 0; i < size; i++) {
                if(!visited[i] && a[i][q] != 0){// nếu chưa duyệt và có liên kết thì add vào queue để duyệt tiếp
                    visited[i] = true;
                    my.EnQueue(i);
                }
            }
            visit(q);
        }
    }
    
    void Depth_first(char x){
        boolean []visited = new boolean[size];// check xem điểm đã duyệt chưa
        Arrays.fill(visited, false);
        Depth_first(toInt(x), visited);// xét bắt đầu từ điểm nào
    }
    void Depth_first(int p, boolean [] visited){
        visited[p] = true;// cho điểm đã duyệt bằng true
        visit(p);// in ra node
        for (int i = 0; i < size; i++) {
            if(!visited[i] && a[i][p]!= 0){// nếu false , chưa duyệt và có liên kết( duyệt từ bé đến lớn) thì duyệt tiếp
                Depth_first(i, visited);
            }
        }
    }
    
}

class Using{
    public static void main(String[] args) {
        myGraph my = new myGraph();
        my.display();
        my.Breadth_first('A');
        System.out.println("");
        my.Depth_first('A');
    }
}

//1. duỵet bằng breath first hay in cac đỉnh kèm theo số bậc của nó ví dụ A(3) 
//2. duyet bang breath - first in ra các đỉnh có bậc lớn hơn 3