/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.NoSuchElementException;

public class QueueObject {
    private Node front;
    private Node rear;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public QueueObject() {
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

    public void enqueue(Object x) {
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

    public Object dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Object value = front.value;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    public Object first() {
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
        QueueObject queue = new QueueObject();
        while (n > 0) {
            n *= 2;
            if (n >= 1) {
                queue.enqueue('1');
                n -= 1;
            } else {
                queue.enqueue('0');
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
        QueueObject queue = new QueueObject();
        queue.enqueue("Hello");
        queue.enqueue(123);
        queue.enqueue(true);
        queue.traverse();

        decimalToBinary(0.625);
    }
}

