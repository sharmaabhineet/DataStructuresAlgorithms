package org.leIngeneursInc.problems.others.subtractLastFromListProblem;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.leIngeneursInc.problems.others.subtractLastFromListProblem.CommonUtil.listIntegersOrdered;

/**
 * Tests the implementation of {@link ListUtil}
 */
public class ListUtilTest {
    @Test
    public void reverse_null_null() {
        assertThat(ListUtil.reverse(null), is(nullValue()));
    }

    @Test
    public void reverse_singleton_singleton() {
        Node<Integer> n = new Node<>(1);
        System.out.println("Asserting reverse of " +n +" is " +n);
        assertThat(ListUtil.reverse(n), is(n));
    }

    @Test
    public void reverse_twoNodes_reverseList() {
        Node<Integer> first = new Node<>(1, new Node<>(2));
        Node<Integer> reversed = new Node<>(2, new Node<>(1));
        System.out.println("Asserting reverse of " +first +" is " +reversed);
        assertThat(ListUtil.reverse(first), is(reversed));
    }

    @Test
    public void reverse_significantSizedList_validCase() {
        // Creating 1 -> 2 -> 3 -> 4 -> 5
        Node<Integer> lst = new Node<>(1, new Node<>(2,
                new Node<>(3, new Node<>(4, new Node<>(5)))));
        Node<Integer> reversed = new Node<>(5, new Node<>(4,
                new Node<>(3, new Node<>(2, new Node<>(1)))));

        System.out.println("Asserting that reverse of " +lst +" is " +reversed);
        assertThat(ListUtil.reverse(lst), is(reversed));
    }

    @Test
    public void middleAndLast_nullList_null() {
        assertThat(ListUtil.middleAndLast(null), is(Pair.of(null, null)));
    }

    @Test
    public void middleAndLast_singleton_singleton() {
        Node<Integer> n = new Node<>(1);
        System.out.println("Asserting that middle and last of " +n +" is " +Pair.of(n, n));
        assertThat(ListUtil.middleAndLast(n), is(Pair.of(n, n)));
    }

    @Test
    public void middleAndLast_listOfSize3_validValues() {
        Node<Integer> lst = listIntegersOrdered(3);
        Pair<Node, Node> expected =Pair.of(new Node<>(2, new Node<>(3)), new Node<>(3));
        System.out.println("Asserting that middle and last of " +lst + " is " +expected);
        assertThat(ListUtil.middleAndLast(lst), is(expected));
    }

    @Test
    public void middleAndLast_listOfSize4_validValues() {
        Node<Integer> lst = listIntegersOrdered(4);
        Pair<Node, Node> expected =Pair.of(new Node<>(2, new Node<>(3, new Node<>(4))), new Node<>(4));
        System.out.println("Asserting that middle and last of " +lst + " is " +expected);
        assertThat(ListUtil.middleAndLast(lst), is(expected));
    }

    @Test
    public void middleAndLast_longListEven_validValues() {
        Node<Integer> lst = listIntegersOrdered(10);
        System.out.println(lst);
        Pair<Node<Integer>, Node<Integer>> res = ListUtil.middleAndLast(lst);
        System.out.println("Asserting midlle and last of " +lst +" has 5 in the middle and 10 in the last");
        assertThat(res.getLeft().datum, is(5));
        assertThat(res.getLeft().next, is(notNullValue()));

        assertThat(res.getRight().datum, is(10));
        assertThat(res.getRight().next, is(nullValue()));
    }

    @Test
    public void middleAndLast_longListOdd_validValues() {
        Node<Integer> lst = listIntegersOrdered(11);
        System.out.println(lst);
        Pair<Node<Integer>, Node<Integer>> res = ListUtil.middleAndLast(lst);
        System.out.println("Asserting midlle and last of " +lst +" has 6 in the middle and 11 in the last");
        assertThat(res.getLeft().datum, is(6));
        assertThat(res.getLeft().next, is(notNullValue()));

        assertThat(res.getRight().datum, is(11));
        assertThat(res.getRight().next, is(nullValue()));
    }
}
