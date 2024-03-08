/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;

public class StackChar {
    private Node top;
    private int size;

    private class Node {
        char value;
        Node next;

        Node(char value) {
            this.value = value;
        }
    }

    public StackChar() {
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

    public void push(char x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public char pop() {
        if (isEmpty()) throw new EmptyStackException();
        char value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public char top() {
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
        StackChar stackChar = new StackChar();
        while (n > 0) {
            stackChar.push((char) (n % 2 + '0'));
            n /= 2;
        }
        while (!stackChar.isEmpty()) {
            System.out.print(stackChar.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackChar stackChar = new StackChar();
        stackChar.push('A');
        stackChar.push('B');
        stackChar.push('C');
        stackChar.traverse();

        decimalToBinary(10);
    }
}

