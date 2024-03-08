/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoLinkList;

/**
 *
 * @author Fpt
 */
public class Node {
    int value;
    Node next;// pointer không dùng khái niệm pointer mà dùng khái niệm đối tượng

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
        next = null;
    }
    
}
