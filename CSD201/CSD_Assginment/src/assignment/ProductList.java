/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Admin
 */
class ProductList {

    static class Node {

        Product data;
        Node next;

        public Node(Product data) {
            this.data = data;
        }
    }

    Node head;

    public void add(Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
                "Code",  "Pro_name",  "Quantity", "Saled", "Price",  "Value");
        Node current = head;
        while (current != null) {
            double value = current.data.price * current.data.saled;
            System.out.printf("%-10s | %-10s | %-10d | %-10d | %-10f | %-10f\n",
                    current.data.pcode, current.data.proName, current.data.quantity,
                    current.data.saled,  current.data.price, value);
            current = current.next;
        }
    }

    public Node search(String xCode) {
        Node current = head;
        while (current != null) {
            if (current.data.pcode.equals(xCode)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(String xCode) {
        if (head == null) {
            return;
        }

        if (head.data.pcode.equals(xCode)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.pcode.equals(xCode)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;
        while (current != null) {
            Node minNode = current;
            Node innerCurrent = current.next;
            while (innerCurrent != null) {
                if (innerCurrent.data.pcode.compareTo(minNode.data.pcode) < 0) {
                    minNode = innerCurrent;
                }
                innerCurrent = innerCurrent.next;
            }
            swap(current, minNode);
            current = current.next;
        }
    }

    private void swap(Node node1, Node node2) {
        Product temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void addAfterPosition(int k, Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < k && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void deleteNodeAfter(String xCode) {
        Node current = head;
        while (current != null && !current.data.pcode.equals(xCode)) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }
}
