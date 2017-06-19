package org.leIngeneursInc.problems.others;

/**
 * Given a binary search tree, convert it to Double linked list
 */
public class BSTToDLL {
    private static class Node {
        int val;
        // Also the previous pointer for a doubly linked list
        Node left;
        // Also the next pointer for the doubly linked list
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node toDLL(Node root) {
        //base case
        if (root == null) {
            return null;
        }

        //Case of leaf node
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }

        Node headOfLeft = toDLL(root.left);
        // Linking the left DLL to the root
        root.left = headOfLeft.left;
        headOfLeft.left.right = root;
        //Linking the right DLL to the root
        root.right = toDLL(root.right);

        headOfLeft.left = root.right.left.right;
        root.right.left.right = headOfLeft;
        return headOfLeft;
    }

    public static void main(String[] args) {
        printCircularDLL(toDLL(null));
        printCircularDLL(toDLL(new Node(1)));

        //Simple Case : BST of [5,3,7] in the same order
        {
            Node root = new Node(5);
            root.left = new Node(3);
            root.right = new Node(7);
            printCircularDLL(toDLL(root));
        }

        //Complete BST two levels: [5,3,7,1,4,6,8] in same order
        {
            Node root = new Node(5);
            root.left = new Node(3);
            root.left.left = new Node(1);
            root.left.right = new Node(4);

            root.right = new Node(7);
            root.right.left = new Node(6);
            root.right.right = new Node(8);
            printCircularDLL(toDLL(root));
        }
    }


    private static void printCircularDLL(Node head) {
        if (head == null) {
            System.out.println("NULL LIST");
            return;
        }

        Node ptr = head;
        while(true) {
            System.out.print(ptr.val);
            ptr = ptr.right;
            if (ptr != head) {
                System.out.print(" --> ");
            } else {
                break;
            }
        }
        System.out.println("");
    }
}
