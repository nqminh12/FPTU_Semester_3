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
public class NodeQ {
    Node value; // value của nodeQ chính là node của tree
    NodeQ next;

    public NodeQ(Node q) {
        value = q;
        next = null;
    }
    
}
