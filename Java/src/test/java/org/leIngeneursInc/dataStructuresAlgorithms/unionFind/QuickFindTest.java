package org.leIngeneursInc.dataStructuresAlgorithms.unionFind;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertThat;

/**
 * Tests the implementation of {@link QuickFind}
 *
 * @author Abhineet (sharma.abhineet31@gmail.com)
 */
public class QuickFindTest {

    private static final Random RANDOM = new Random();

    @Test(expected = java.lang.NullPointerException.class)
    public void testWithNullValues() {
        new QuickFind<Integer>(null);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testWithEmptySet() {
        new QuickFind<Integer>(Collections.emptySet());
    }

    @Test
    public void testInitialization() {
        int size = 10;
        Set<Integer> values = IntStream.range(1, size + 1).boxed().
                collect(Collectors.toSet());
        QuickFind<Integer> qf = new QuickFind<>(values);
        assertThat(qf, IsNull.notNullValue());
        assertThat(qf.count(), Matchers.equalTo(10));
        for (int ele1 = 1; ele1 <= size; ele1++) {
            assertThat(qf.find(ele1), Matchers.equalTo(ele1 - 1));
            for (int ele2 = 1; ele2 <= size; ele2++) {
                assertThat(qf.connected(ele1, ele2), Matchers.equalTo(ele1 == ele2));
            }
        }
    }

    @Test
    public void testUnionConnectedFind_NonDeterministicInput_Tractable() {
        int size = RANDOM.nextInt(10) + 5; // min : 5 max : 15
        System.out.println("SIZE : " + size);
        Set<Integer> values = IntStream.range(1, size + 1).boxed().
                collect(Collectors.toSet());
        QuickFind<Integer> qf = new QuickFind<>(values);
        int[][] components = createRandomSampleOfInteger(qf, values);

    }


    private static int[][] createRandomSampleOfInteger(QuickFind<Integer> qf, Set<Integer> values) {
        int numComp = RANDOM.nextInt(values.size()) + 1;
        int[][] components = new int[numComp][];
        List<Integer> lstValues = new ArrayList<>(values);
        for (int compIdx = 0; compIdx < numComp; compIdx++) {
            int maxPossibleSize = lstValues.size() / (numComp - compIdx);
            int compSize = -1;
            if (compIdx == numComp - 1) {
                compSize = maxPossibleSize;
            } else {
                compSize = RANDOM.nextInt(maxPossibleSize) + 1;
            }
            components[compIdx] = new int[compSize];
            for (int numIdx = 0; numIdx < compSize; numIdx++) {
                int randIdx = RANDOM.nextInt(lstValues.size());
                components[compIdx][numIdx] = lstValues.get(randIdx);
                lstValues.remove(randIdx);
                if (numIdx > 0) {
                    qf.union(components[compIdx][0], components[compIdx][numIdx]);
                }
            }
        }
        return components;
    }

}
