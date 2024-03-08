/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoTree;

/**
 *
 * @author Fpt
 */
public class MyQueue {
    NodeQ head, tail;

    public MyQueue() {
        head = tail = null;
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    void EnQueue(Node p){// adđlast
         NodeQ node = new NodeQ(p);
         if(isEmpty()){
             head = tail = node;
         }
         else{
             tail.next = node;
             tail = node;
         }
    }
    
    Node Dequeue(){// xóa phần tử đầu và trả về value của nó    
        if(isEmpty()) return null;
        Node value = head.value;
        head = head.next;
        return value;
    }
    
    
}
