package org.leIngeneursInc.problems.others.subtractLastFromListProblem;

import org.apache.commons.lang3.tuple.Pair;

/**
 * A utility class for all the list methods we need
 */
public class ListUtil {
    /**
     * Private constructor for this utility class
     */
    private ListUtil(){}

    /**
     * Reverses the list starting at given node and returns the new start of the reversed list
     * @param list starting pointer of the given list
     * @return the starting {@link Node} of the reversed list
     */
    public static<T> Node<T> reverse(Node<T> list) {
        if (list == null || list.next == null) {
            return list;
        }

        Node a = list;
        Node b = list.next;
        Node c = list.next.next;
        a.next = null;
        while (b != null) {
            b.next = a;
            a = b;
            b = c;
            if (c != null) {
                c = c.next;
            }
        }
        return a;
    }

    /**
     * Returns the middle and the last of the list
     * @param list the given list
     * @return a {@link Pair} of middle and the last node of the list. Does not return a <code>null</code> pair.
     */
    public static<T> Pair<Node<T>, Node<T>> middleAndLast(Node<T> list) {
        //Base case
        if (list == null || list.next == null) {
            return Pair.of(list, list);
        }

        Node slow = list;
        Node fast = list.next;
        while(fast.next != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return Pair.of(slow, fast);
    }
}
