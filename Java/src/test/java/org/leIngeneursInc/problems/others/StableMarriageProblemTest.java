package org.leIngeneursInc.problems.others;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Tests {@link StableMarriageProblem}
 */
public class StableMarriageProblemTest {

    /**
     * Here's the preference order, with integer codes assigned to each in the parenthesis
     *
     * Albert(0) -> Diane (0), Emily (1), Fergie (2)
     * Bradley (1) -> Emily(1), Diane(0), Fergie(2)
     * Charles (2) -> Diane(0), Emily(1), Fergie(2)
     *
     * Diane(0) -> Bradley(1), Albert(0), Charles(2)
     * Emily(1) -> Albert(0), Bradley(1), Charles(2)
     * Fergie(2) -> Albert(0), Bradley(1), Charles(2)
     *
     * Solution: Diane -> Albert, Bradle -> Emily, Fergie -> Charles
     */
    @Test
    public void randomCase() {
        Map<Integer, List<Integer>> menPrefs = new HashMap<>();
        menPrefs.put(0, Arrays.asList(0, 1, 2));
        menPrefs.put(1, Arrays.asList(1, 0, 2));
        menPrefs.put(2, Arrays.asList(0, 1, 2));

        Map<Integer, List<Integer>> womenPrefs = new HashMap<>();
        womenPrefs.put(0, Arrays.asList(1, 0, 2));
        womenPrefs.put(1, Arrays.asList(0, 1, 2));
        womenPrefs.put(2, Arrays.asList(0, 1, 2));

        Map<Integer, Integer> engagementsByWomen = StableMarriageProblem.stableMarriages(menPrefs, womenPrefs);
        assertTrue(engagementsByWomen.get(0) == 0);
        assertTrue(engagementsByWomen.get(1) == 1);
        assertTrue(engagementsByWomen.get(2) == 2);
    }
}
