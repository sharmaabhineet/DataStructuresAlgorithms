package org.leIngeneursInc.problems.others.subtractLastFromListProblem;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.leIngeneursInc.problems.others.subtractLastFromListProblem.CommonUtil.listIntegersOrdered;
import static org.leIngeneursInc.problems.others.subtractLastFromListProblem.CommonUtil.subtractionFun;

/**
 * Tests implementation of {@link FunctionApplierOnFirstFromLast}
 */
public class FunctionApplierOnFirstFromLastTest {

    @Test
    public void apply_nullList_noException() {
        integerSubtractionApplier().apply(null);
    }

    @Test
    public void apply_singletonList_sameList() {
        FunctionApplierOnFirstFromLast<Integer> obj = integerSubtractionApplier();
        Node<Integer> lst = listIntegersOrdered(1);
        obj.apply(lst);
        assertThat(lst, is(new Node<>(1)));
    }

    @Test
    public void apply_listOf2_validValues() {
        FunctionApplierOnFirstFromLast<Integer> obj = integerSubtractionApplier();
        Node<Integer> lst = new Node<>(10, new Node<>(7));
        obj.apply(lst);
        Node<Integer> expected = new Node<>(3, new Node<>(7));
        assertThat(lst, is(expected));
    }

    @Test
    public void apply_listOf3_validValues() {
        FunctionApplierOnFirstFromLast<Integer> obj = integerSubtractionApplier();
        Node<Integer> lst = new Node<>(10, new Node<>(7, new Node<>(5)));
        obj.apply(lst);
        Node<Integer> expected = new Node<>(5, new Node<>(7, new Node<>(5)));
        assertThat(lst, is(expected));
    }

    @Test
    public void apply_listOf4_validValues() {
        FunctionApplierOnFirstFromLast<Integer> obj = integerSubtractionApplier();
        Node<Integer> lst = new Node<>(10, new Node<>(7, new Node<>(5, new Node<>(7))));
        obj.apply(lst);
        Node<Integer> expected = new Node<>(3, new Node<>(2, new Node<>(5, new Node<>(7))));
        assertThat(lst, is(expected));
    }

    @Test
    public void apply_listOf5_validValues() {
        FunctionApplierOnFirstFromLast<Integer> obj = integerSubtractionApplier();
        Node<Integer> lst = new Node<>(10, new Node<>(7,
                new Node<>(5, new Node<>(7, new Node<>(100)))));
        obj.apply(lst);
        Node<Integer> expected = new Node<>(-90, new Node<>(0,
                new Node<>(5, new Node<>(7, new Node<>(100)))));
        assertThat(lst, is(expected));
    }

    private static FunctionApplierOnFirstFromLast<Integer> integerSubtractionApplier() {
        return new FunctionApplierOnFirstFromLast<>(subtractionFun());
    }
}
