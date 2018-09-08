package org.leIngeneursInc.problems.others;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Problem description: There are same number of men and women. Each has its own preference of the most desirable
 * women from amongst the available set. Need to match each men and women in a way to attain a stable marriage. A
 * marriage would be stable if each of them is married to the most preferred partner.
 *
 * Solution: Start with all men and women free. Then each man proposes to the woman he desires the most and they are
 * potentially engaged. Say another man proposes to a woman who is already engaged then woman gets engaged to the man
 * who she desires the most. In this way, all are engaged to the best possible availability as per their preferences
 */
public class StableMarriageProblem {
    private StableMarriageProblem() {}

    /**
     * Returns mapping of women -> men for the stable marriage problem
     * @param menPrefs
     * @param womenPrefs
     * @return
     */
    public static Map<Integer, Integer> stableMarriages(Map<Integer, List<Integer>> menPrefs,
                                                          Map<Integer, List<Integer>> womenPrefs) {
        Map<Integer, Integer> engagementsByWoman = new HashMap<>();
        Set<Integer> availableMen = new HashSet<>(menPrefs.keySet());

        while(!availableMen.isEmpty()) {
            int man = availableMen.iterator().next();
            availableMen.remove(man);

            List<Integer> prefList = menPrefs.get(man);
            for (Integer woman : prefList) {
                if (engagementsByWoman.containsKey(woman)) {
                    List<Integer> womanPrefList = womenPrefs.get(woman);
                    Integer currentEngagement = engagementsByWoman.get(woman);
                    for (Integer womansPreferredMan : womanPrefList) {
                        if (womansPreferredMan == man) {
                            engagementsByWoman.put(woman, man);
                            availableMen.add(currentEngagement);
                        } else if (womansPreferredMan == currentEngagement) {
                            // Hard luck. Propose next on the list. Sounds rude, eh!!
                            break;
                        }
                    }
                } else {
                    engagementsByWoman.put(woman, man);
                    break;
                }
            }
        }
        return engagementsByWoman;
    }

}
