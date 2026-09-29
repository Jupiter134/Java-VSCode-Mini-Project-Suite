//balanced binary tree
import java.util.Scanner;

class Node {
    int data;
    Node leftChild, rightChild;

    Node(int data) {
        this.data = data;
        leftChild = rightChild = null;
    }
}

public class BalancedBinaryTree {

    Node root;

    // add Node recursively
    public void addNode(int data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node current, int data) {

        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.leftChild = addRecursive(current.leftChild, data);
        }

        else if (data > current.data) {
            current.rightChild = addRecursive(current.rightChild, data);
        }

        return current;
    }

    //-----------
    public int minDepth(Node root) {

        // empty tree has depth 0
        if (root == null) 
        {
            return 0;
        }

        // if no left child, only use right subtree
        if (root.leftChild == null) {
            return minDepth(root.rightChild) + 1;
        }

        // if no right child, only use left subtree
        if (root.rightChild == null) {
            return minDepth(root.leftChild) + 1;
        }

        // if both children exist, take smaller depth
        return Math.min(minDepth(root.leftChild), minDepth(root.rightChild)) + 1;
    }

    public static void main(String[] args) {

        BalancedBinaryTree tree = new BalancedBinaryTree();
        Scanner sc = new Scanner(System.in);

        // Read integers until non-integer entered
        while (sc.hasNextInt()) {
            int data = sc.nextInt();
            tree.addNode(data);
        }

        sc.close();

        int depth = tree.minDepth(tree.root);

        System.out.println("Minimum Depth of Binary Tree is " + depth);
    }
}

//test: 1 2 3 4 5 a
