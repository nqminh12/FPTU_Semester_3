/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author Cao Duy Quân
 */


import java.util.NoSuchElementException;

public class QueueString {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
        }
    }

    public QueueString() {
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

    public void enqueue(String x) {
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

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        String value = front.value;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public String first() {
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
        QueueString queue = new QueueString();
        while (n > 0) {
            n *= 2;
            if (n >= 1) {
                queue.enqueue("1");
                n -= 1;
            } else {
                queue.enqueue("0");
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
        QueueString queue = new QueueString();
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");
        queue.traverse();

        decimalToBinary(0.625);
    }
}

