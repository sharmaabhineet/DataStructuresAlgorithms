package org.leIngeneursInc.problems.forFun;

import org.junit.Assert;

public class LoopInList {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode loop(ListNode head) {
        if (head == null) {
            // No loop in this list
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        ListNode ptOfIntersection = null;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                ptOfIntersection = slowPtr;
                break;
            }

        }

        if (ptOfIntersection == null) {
            return ptOfIntersection;
        }

        slowPtr = head;
        while (slowPtr != ptOfIntersection) {
            slowPtr = slowPtr.next;
            ptOfIntersection = ptOfIntersection.next;
        }
        return slowPtr;
    }


    public static void main(String[] args) {
        //base case
        {
            Assert.assertTrue(loop(null) == null);
        }

        //single node no loop
        {
            ListNode head = new ListNode(1, null);
            Assert.assertTrue(loop(head) == null);
        }

        //single node with loop
        {
            ListNode head = new ListNode(1, null);
            head.next = head;
            Assert.assertTrue(loop(head) == head);
        }

        // circular linked list
        {
            ListNode head = new ListNode(1, null);
            head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, head))));
            Assert.assertTrue(loop(head) == head);
        }

        // Loop at random location
        {
            ListNode randomNode = new ListNode(100, null);
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, randomNode)))));
            randomNode.next = new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10, randomNode)))));
            Assert.assertTrue(loop(head) == randomNode);
        }
    }

    private static void printList(ListNode head) {
        int count = 0;
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" --> ");
            }
            head = head.next;
            if (count++ > 15) {
                break;
            }
        }
        System.out.println("\n");
    }
}