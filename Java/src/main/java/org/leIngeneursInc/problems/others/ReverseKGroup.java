package org.leIngeneursInc.problems.others;

public class ReverseKGroup {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "" +val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, null)))))));

        print(head);
        head = reverseKGroup(head, 3);
        print(head);
    }

    private static void print(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val);
            ptr = ptr.next;
            if (ptr != null) {
                System.out.print(" --> ");
            }
        }
        System.out.println("\n");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        //Base Case: if head == null or length of list is < k
        ListNode kthNode = findKthNode(head, k);

        // If list is empty or size < k, kthNode is null. Therefore, return head.
        if (kthNode == null) {
            return head;
        }

        ListNode nxtPtr = reverseKGroup(kthNode.next, k);
        kthNode.next = null;
        ListNode oldHead = head;
        head = reverse(head);
        oldHead.next = nxtPtr;
        return head;
    }

    private static ListNode reverse(ListNode head) {
        // Empty list or a single node, return head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        ListNode ptr3 = head.next.next;
        ptr1.next = null;
        while (ptr2 != null) {
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr3;
            if (ptr3 != null) {
                ptr3 = ptr3.next;
            }
        }
        return ptr1;
    }

    private static ListNode findKthNode(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        for (int idx = 1; idx < k && head != null; idx++) {
            head = head.next;
        }

        return head;
    }
}