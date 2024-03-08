/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.NoSuchElementException;

public class Queue {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int value = front.value;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public int first() {
        if (isEmpty()) throw new NoSuchElementException();
        return front.value;
    }

    public void traverse() {
        Node current = front;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void decimalToBinary(double n) {
        Queue queue = new Queue();
        while (n > 0) {
            n *= 2;
            if (n >= 1) {
                queue.enqueue(1);
                n -= 1;
            } else {
                queue.enqueue(0);
            }
            if (queue.size > 32) break; // limit the number of bits
        }
        
        System.out.print("0.");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.traverse();
        
        decimalToBinary(0.625);
    }
}
