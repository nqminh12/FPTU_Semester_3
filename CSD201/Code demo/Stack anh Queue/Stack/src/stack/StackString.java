/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;



import java.util.EmptyStackException;

public class StackString {
    private Node top;
    private int size;

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    public StackString() {
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

    public void push(String x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public String pop() {
        if (isEmpty()) throw new EmptyStackException();
        String value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public String top() {
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
        StackString stackString = new StackString();
        while (n > 0) {
            stackString.push(String.valueOf(n % 2));
            n /= 2;
        }
        while (!stackString.isEmpty()) {
            System.out.print(stackString.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackString stackString = new StackString();
        stackString.push("Alice");
        stackString.push("Bob");
        stackString.push("Charlie");
        stackString.traverse();

        decimalToBinary(10);
    }
}

