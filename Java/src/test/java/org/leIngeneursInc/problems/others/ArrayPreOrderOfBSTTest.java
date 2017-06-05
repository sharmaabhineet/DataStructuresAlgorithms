package org.leIngeneursInc.problems.others;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.leIngeneursInc.problems.others.ArrayPreOrderOfBST.isPreOrderOfBST;

/**
 * Tests implementation of {@link ArrayPreOrderOfBSTTest}
 */
public class ArrayPreOrderOfBSTTest {

    @Test(expected = IllegalArgumentException.class)
    public void isPreOrderOfBST_null() {
        isPreOrderOfBST(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPreOrderOfBST_emptyArray() {
        isPreOrderOfBST(new int[0]);
    }

    public void isPreOrderBST_withCoupleOfDiffInputs() {
        assertThat(isPreOrderOfBST(new int[]{2,4,3,1}), is(false));
        assertThat(isPreOrderOfBST(new int[]{2,1,4,3}), is(true));
        assertThat(isPreOrderOfBST(new int[]{2,1}), is(true));
        assertThat(isPreOrderOfBST(new int[]{1,2}), is(true));
        assertThat(isPreOrderOfBST(new int[]{2,3,5,7,1}), is(false));
    }
}
