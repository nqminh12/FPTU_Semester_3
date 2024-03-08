/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1sp0009;

/**
 *
 * @author Admin
 */
public class J1SP0009 {

    public static void main(String[] args) {
        // step 1: find 45 fibonacci sequence by recursion
        int fiboSeq[] = new int[45];
        Boolean test = true;
        findFiboSeq(fiboSeq, 0, test);
        // step 2: display 45 fibonacci sequence
        displayFiboSeq("The 45 sequence fibonacci:\n", fiboSeq);
    }

    private static void findFiboSeq(int[] fiboSeq, int index, boolean test) {
        //Recursive stop condition
        if (index == fiboSeq.length) {
            return;
        }
        // Base Steps: Check index = 0 or index = 1;
        if (index <= 1) {
            fiboSeq[index] = index;
            // Test algorithm
            if (test == true) {
                System.out.println("Fibo(" + index + ") = " + index);
            }

        } else {
            fiboSeq[index] = fiboSeq[index - 1] + fiboSeq[index - 2];
            // Test algorithm
            if (test == true) {
                System.out.println("Fibo(" + index + ") = " + fiboSeq[index - 1] + " + " + fiboSeq[index - 2] + " = " + fiboSeq[index]);

            }
        }
        index++;
        //Recursive
        findFiboSeq(fiboSeq, index, test);
    }

    private static void displayFiboSeq(String msg, int[] fiboSeg) {
        System.out.print(msg);
        // loops from first to last index of element
        for (int i = 0; i < fiboSeg.length; ++i) {
            // check if current element is not last element
            if (i + 1 < fiboSeg.length) {
                System.out.print(fiboSeg[i] + ", ");
            } else {
                System.out.println(fiboSeg[i]);
            }
        }
    }

}
