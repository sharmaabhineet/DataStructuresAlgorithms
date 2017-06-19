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
        Node headOfRight = toDLL(root.right);

        root.left = headOfLeft == null ? headOfRight.left : headOfLeft.left;
        root.right = headOfRight == null ? headOfLeft : headOfRight;

        if (headOfLeft != null) {
            headOfLeft.left.right = root;
            headOfLeft.left = headOfRight == null ? root : headOfRight.left;

        }

        if (headOfRight != null) {
            headOfRight.left.right = headOfLeft == null ? root : headOfLeft;
            headOfRight.left = root;
        }

        return headOfLeft == null ? root : headOfLeft;
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

        // random BST : [10,2,1,5,3,7,8,9] in same order
        {
            Node root = new Node(10);
            root.left = new Node(2);
            root.left.left = new Node(1);
            root.left.right = new Node(5);

            root.left.right.left = new Node(3);
            root.left.right.right = new Node(7);

            root.left.right.right.right = new Node(8);
            root.left.right.right.right.right = new Node(9);
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
