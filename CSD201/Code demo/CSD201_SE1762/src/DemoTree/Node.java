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
public class Node {
    Car infor;
    Node left, right;

    public Node() {
    }

    public Node(Car infor) {
        this.infor = infor;
        this.left = null;
        this.right = null;
    }

    public Node(String name, int price) {
        infor = new Car(name, price);
        left = right = null;
    }
    
    
    
}

class Car {
    String name;
    int price; // key

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + price + ")";
    }
    
    
}
