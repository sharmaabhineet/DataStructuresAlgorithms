package org.leIngeneursInc.problems.others.subtractLastFromListProblem;

import java.util.function.BiFunction;

import static java.util.Objects.requireNonNull;

/**
 * Solves the following problem
 * Problem : Given a linked list, modify it so that the last number is subtracted from the first, second from last
 * from the second and so on. For example,
 *  10 -> 8 -> 6 -> 1 -> 7 -> 5 -> 3 ==> 7 -> 3 -> -1 -> 1 -> 3 -> 5 -> 7
 *
 * Proposed solution: First of all, reverse the later half of the linked list and store the pointer to the last node
 * and the one that is lost. This is the pointer from the middle element to the next. 1 -> 7 in this example.
 * Then start subtracting, and eventually reverse the later half again.
 */
public class FunctionApplierOnFirstFromLast<T> {
    private final BiFunction<T,T,T> bifunction;

    public FunctionApplierOnFirstFromLast(BiFunction<T,T,T> bifunction) {
        this.bifunction = requireNonNull(bifunction);
    }

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * @param list
     */
    public void apply(Node<T> list) {
        // Base case
        if (list == null || list.next == null) {
            return;
        }

        // 1. Find middle and the last ==> O(n)
        Node<T> middle = ListUtil.middleAndLast(list).getLeft();

        // 2. Store the next of the middle ==> O(1)
        Node<T> nextToMiddle = middle.next;

        //Break the chain so that only the rest half is reversed
        middle.next = null;

        // 3. Reverse the list starting from the next of the middle ==> O(n)
        Node<T> last = ListUtil.reverse(nextToMiddle);

        // 4. Apply biconsumer ==> O(n)
        Node<T> iter = last;
        Node<T> start = list;
        while(iter != null) {
            start.datum = bifunction.apply(start.datum, iter.datum);
            start = start.next;
            iter = iter.next;
        }

        // 5. Reverse the list back ==> O(n)
        middle.next = ListUtil.reverse(last);
    }
}
