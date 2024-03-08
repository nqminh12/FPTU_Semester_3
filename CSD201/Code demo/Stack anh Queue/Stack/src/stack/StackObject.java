/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;

public class StackObject {
    private Node top;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public StackObject() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void push(Object x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object pop() {
        if (isEmpty()) throw new EmptyStackException();
        Object value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public Object top() {
        if (isEmpty()) throw new EmptyStackException();
        return top.value;
    }

    public void traverse() {
        Node current = top;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void decimalToBinary(int n) {
        StackObject stack = new StackObject();
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackObject stack = new StackObject();
        stack.push("Hello");
        stack.push(123);
        stack.push(true);
        stack.traverse();
        
        decimalToBinary(10);
    }
}

