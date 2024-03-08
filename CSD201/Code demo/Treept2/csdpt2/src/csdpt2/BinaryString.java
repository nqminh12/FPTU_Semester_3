/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdpt2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryString {

    private Node root;

    public BinaryString() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node search(String x) {
        return search(root, x);
    }

    private Node search(Node node, String x) {
        if (node == null) {
            return null;
        } else if (node.data.equals(x)) {
            return node;
        } else if (node.data.compareTo(x) > 0) {
            return search(node.left, x);
        } else {
            return search(node.right, x);
        }
    }

    public void insert(String x) {
        root = insert(root, x);
    }

    private Node insert(Node node, String x) {
        if (node == null) {
            node = new Node(x);
        } else if (node.data.compareTo(x) > 0) {
            node.left = insert(node.left, x);
        } else if (node.data.compareTo(x) < 0) {
            node.right = insert(node.right, x);
        }
        return node;
    }

    public void breadth() {
        Queue<Node> queue = new LinkedList<Node>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data + " ");
        }
    }

    public int count() {
        return count(root);
    }

    private int count(Node p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + count(p.left) + count(p.right);
        }
    }

    public void delete(String x) {
        root = delete(root, x);
    }

    private Node delete(Node p, String x) {
        if (p == null) {
            throw new RuntimeException("cannot delete.");
        } else if (x.compareTo(p.data) < 0) {
            p.left = delete(p.left, x);
        } else if (x.compareTo(p.data) > 0) {
            p.right = delete(p.right, x);
        } else {
            if (p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {

                p.data = retrieveData(p.left);

                p.left = delete(p.left, p.data);
            }
        }
        return p;
    }

    private String retrieveData(Node p) {

        while (p.right != null) {
            p = p.right;
        }

        return p.data;
    }

    public int height() {

        return height(root);

    }

    private int height(Node node) {

        if (node == null) {
            return 0;
        } else {

            int lheight = height(node.left);

            int rheight = height(node.right);

            if (lheight > rheight) {
                return lheight + 1;
            } else {
                return rheight + 1;
            }

        }

    }

    public boolean isAVL() {

        return isAVL(root);

    }

    private boolean isAVL(Node node) {

        if (node == null) {
            return true;
        } else {

            int lheight = height(node.left);

            int rheight = height(node.right);

            if (Math.abs(lheight - rheight) <= 1 && isAVL(node.left) && isAVL(node.right)) {
                return true;
            } else {
                return false;
            }

        }

    }

    public int mystery(Node x) {

        if (x == null) {
            return 0;
        } else {
            return Math.max(mystery(x.left), mystery(x.right));
        }

    }

    private class Node {

        private String data;

        private Node left;

        private Node right;

        public Node(String data) {

            this.data = data;

            left = right = null;

        }

    }
}
