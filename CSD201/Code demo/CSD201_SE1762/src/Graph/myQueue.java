/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Fpt
 */
public class myQueue {
    Node head, tail;

    public myQueue() {
        head = tail = null;
    }
    boolean isEmpty(){
        return head == null;
    }
    void EnQueue(int value){
        Node node = new Node(value);
        if(isEmpty()){
            head = tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
    }
    int DeQueue(){
        if(isEmpty()){
            return -1;            
        }
        int value = head.infor;
        head = head.next;
        return value;
    }
}

class Node{
    int infor;
    Node next;

    public Node(int value) {
        infor = value;
        next = null;
    }

    public Node() {
    }
    
    
}
