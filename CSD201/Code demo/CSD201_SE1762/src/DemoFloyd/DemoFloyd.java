/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoFloyd;

import java.io.RandomAccessFile;
import java.util.RandomAccess;

/**
 *
 * @author Fpt
 */
public class DemoFloyd {
    int [][]a;
    int size;

    public DemoFloyd() {
        try {
            RandomAccessFile raf = new RandomAccessFile("Check.txt", "r");
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
    int Floyd(int x, int y){
        int [][]d = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                d[i][j] = a[i][j];
            }
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(d[i][j] > d[i][k] + d[k][j]){
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
        return d[x][y];
        
    }
    public static void main(String[] args) {
        DemoFloyd d = new DemoFloyd();
        //d.display();
        System.out.println(d.Floyd(1, 4));// khoangr cacsh ddi tuw 2 den 5
        System.out.println(d.Floyd(0, 3 ));
    }
}
