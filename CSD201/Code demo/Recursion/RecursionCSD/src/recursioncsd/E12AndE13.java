/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncsd;

class TreeNode {
    int label;
    TreeNode left;
    TreeNode right;

    public TreeNode(int label) {
        this.label = label;
        this.left = null;
        this.right = null;
    }
}

public class E12AndE13 {
    public static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0; // Base case: empty tree has height 0
        } else {
            int leftHeight = calculateHeight(root.left);
            int rightHeight = calculateHeight(root.right);

            return Math.max(leftHeight, rightHeight) + 1; // Height is maximum of left and right subtrees + 1
        }
    }

    public static int calculateSize(TreeNode root) {
        if (root == null) {
            return 0; // Base case: empty tree has size 0
        } else {
            int leftSize = calculateSize(root.left);
            int rightSize = calculateSize(root.right);

            return leftSize + rightSize + 1; // Size is sum of left and right subtree sizes + 1 (for the root)
        }
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Calculate the height of the tree
        int height = calculateHeight(root);
        System.out.println("Height of the tree: " + height);

        // Calculate the size of the tree
        int size = calculateSize(root);
        System.out.println("Size of the tree: " + size);
    }
}
