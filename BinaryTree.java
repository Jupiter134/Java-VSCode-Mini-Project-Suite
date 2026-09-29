//binary tree height/preorder/inorder
import java.util.Scanner;

class Node {
    int data;
    Node leftChild, rightChild;

    Node(int data) {
        this.data = data;
        leftChild = rightChild = null;
    }
}

public class BinaryTree {

    Node root;

    //add a new node with given number
    public void addNode(int data) 
    {
        Node newNode = new Node(data);

        // if tree is empty, make the new node the root
        if (root == null) 
        {
            root = newNode;
            return;
        }
        //start searching from the root
        Node current = root;
        Node parent = null;

        while (true) 
        {
            //store current node as parent before moving
            parent = current;

            // if left is smaller than current, move to left child
            if (data < current.data) 
            {
                current = current.leftChild;
                //if left child is empty, insert here
                if (current == null) 
                {
                    parent.leftChild = newNode;
                    return;
                }
            }
            //if larger than current, move to right child
            else if (data > current.data) 
            {
                current = current.rightChild;
                //if right child is empty, insert here
                if (current == null) 
                {
                    parent.rightChild = newNode;
                    return;
                }
            }
            // ignore duplicates
            else 
            {
                return;
            }
        }
    }

    //get height of tree
    public int getHeight(Node node) 
    {
        //if tree is empty, height is 0
        if (node == null) 
        {
            return 0;
        }

        //find height of left and right subtrees
        int leftHeight = getHeight(node.leftChild);
        int rightHeight = getHeight(node.rightChild);

        //compare left and right height, return biggest+1 for current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
    //inorder traversal
    public void traverseInorder(Node localRoot) 
    {
        //make sure node exists
        if (localRoot != null) 
        {   //visit left subtree, root node, and then right subtree
            traverseInorder(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            traverseInorder(localRoot.rightChild);
        }
    }
    //preorder traversal
    public void traversePreorder(Node localRoot) 
    {
        //make sure node exists
        if (localRoot != null) 
        {   //visit root node, then left subtree, then right subtree
            System.out.print(localRoot.data + " ");
            traversePreorder(localRoot.leftChild);
            traversePreorder(localRoot.rightChild);
        }
    }
//----------------------------------------------------------
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int data = sc.nextInt();
            tree.addNode(data);
        }

        sc.close();

        int height = tree.getHeight(tree.root);

        System.out.println("The height of the binary tree is: " + height);

        System.out.println("Inorder traversal of the binary tree:");
        tree.traverseInorder(tree.root);
        System.out.println();

        System.out.println("Preorder traversal of the binary tree:");
        tree.traversePreorder(tree.root);
        System.out.println();
    }
}

//test: 5 3 8 1 4 6 9 a