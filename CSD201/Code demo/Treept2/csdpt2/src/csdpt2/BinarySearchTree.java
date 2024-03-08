/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csdpt2;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    //1. `isEmpty()`: Kiểm tra xem cây nhị phân tìm kiếm có rỗng hay không.
    //Trả về `true` nếu cây rỗng, ngược lại trả về `false`.
    public boolean isEmpty() {
        return root == null;
    }

    /*
    2. `clear()`: Xóa tất cả các nút trong cây.

    3. `search(int x)`: Tìm kiếm nút chứa giá trị `x` trong cây.
    Trả về nút đó nếu tìm thấy, ngược lại trả về `null`.

    4. `insert(int x)`: Chèn giá trị `x` vào cây nhị phân tìm kiếm.
     */
    public void clear() {
        root = null;
    }

    public Node search(int x) {
        return search(root, x);
    }

    private Node search(Node node, int x) {
        if (node == null) {
            return null;
        } else if (node.data == x) {
            return node;
        } else if (node.data > x) {
            return search(node.left, x);
        } else {
            return search(node.right, x);
        }
    }

    public void insert(int x) {
        root = insert(root, x);
    }

    private Node insert(Node node, int x) {
        if (node == null) {
            node = new Node(x);
        } else if (node.data > x) {
            node.left = insert(node.left, x);
        } else if (node.data < x) {
            node.right = insert(node.right, x);
        }
        return node;
    }

    /*
    5. `breadth()`: In các nút của cây theo thứ tự duyệt theo chiều rộng (level-order).

6. `preorder(Node p)`: Duyệt cây theo thứ tự trước (preorder traversal).
    In giá trị của nút `p`, sau đó duyệt cây con trái của `p`, rồi duyệt cây con phải của `p`.

7. `inorder(Node p)`: Duyệt cây theo thứ tự giữa (inorder traversal).
    Duyệt cây con trái của `p`, sau đó in giá trị của nút `p`, rồi duyệt cây con phải của `p`.

8. `postorder(Node p)`: Duyệt cây theo thứ tự sau (postorder traversal).
    Duyệt cây con trái của `p`, sau đó duyệt cây con phải của `p`, và cuối cùng in giá trị của nút `p`.

     */

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

    /*
    9. `count()`: Đếm số lượng nút trong cây.

10. `delete(int x)`: Xóa nút chứa giá trị `x` khỏi cây.

11. `min()`: Tìm nút có giá trị nhỏ nhất trong cây.

12. `max()`: Tìm nút có giá trị lớn nhất trong cây.
     */

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

    public void delete(int x) {
        root = delete(root, x);
    }

    private Node delete(Node p, int x) {
        if (p == null) {
            throw new RuntimeException("cannot delete.");
        } else if (x < p.data) {
            p.left = delete(p.left, x);
        } else if (x > p.data) {
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

    private int retrieveData(Node p) {

        while (p.right != null) {
            p = p.right;
        }

        return p.data;
    }

    public Node min() {

        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public Node max() {

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    /*
    13. `sum()`: Tính tổng giá trị của tất cả các nút trong cây.

14. `avg()`: Tính giá trị trung bình của các nút trong cây.

15. `height()`: Tính chiều cao của cây.

     */
    public int sum() {

        return sum(root);

    }

    private int sum(Node node) {

        if (node == null) {

            return 0;
        } else {
            return node.data + sum(node.left) + sum(node.right);
        }

    }

    public int avg() {

        int sum = sum();

        int count = count();

        return sum / count;

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

    public int cost() {

        return cost(root);

    }

    private int cost(Node node) {

        if (node == null) {

            return 0;
        } else {

            int lcost = cost(node.left);

            int rcost = cost(node.right);

            if (lcost > rcost) {

                return lcost + node.data;
            } else {
                return rcost + node.data;
            }

        }

    }

    /*
   16. `cost()`: Tính tổng các giá trị của nút trong cây dựa trên quy tắc: nếu nút có nhiều con hơn, thì giá trị của nút đó được tính vào tổng.

17. `isAVL()`: Kiểm tra xem cây có phải là cây AVL hay không.

18. `mystery(Node x)`: Hàm trả về chiều cao của cây trừ đi 1.
   Hàm này sử dụng đệ quy để tìm giá trị lớn nhất giữa các cây con bên trái
   và bên phải của một nút.
   Trường hợp cơ bản là khi nút là null, hàm trả về 0. Điều này có nghĩa là đối với một nút lá, hàm trả về 0, và đối với nút cha của nút lá đó, hàm trả về 1, và tiếp tục như vậy cho đến khi đạt đến gốc của cây.

19. `isHeap()`: Kiểm tra xem cây có phải là một cây heap hay không. Cây heap là một cây nhị phân mà tất cả các giá trị trong các nút con đều nhỏ hơn (hoặc lớn hơn) giá trị của nút cha tương ứng.

     */
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

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /*   18)) The mystery function returns the height of the tree minus 1. 
    It does this by recursively finding the maximum value between
    the left and right subtrees and returning it.
    The base case is when the node is null, in which case it returns 0.
    This means that for a leaf node, the function will return 0, for its parent it will return 1,
    and so on until it reaches the root of the tree.
     */
//19
    public boolean isHeap() {
        return isHeap(root);
    }

    private boolean isHeap(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.left.data > node.data) {
            return false;
        }

        if (node.right != null && node.right.data > node.data) {
            return false;
        }

        return isHeap(node.left) && isHeap(node.right);
    }

}
