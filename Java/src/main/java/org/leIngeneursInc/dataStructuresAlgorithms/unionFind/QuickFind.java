package org.leIngeneursInc.dataStructuresAlgorithms.unionFind;

import org.apache.commons.lang3.Validate;

import java.util.*;

/**
 * Quick find implementation of {@link UnionFind}
 * NOTE: For correctness the template(generic) class must have correct implementation
 * of {@link Object#equals(Object)} and {@link Object#hashCode()}
 */
class QuickFind<T> implements UnionFind<T> {

    /**
     * mapping of generated ids to values
     */
    private final Map<T, Integer> mapValues = new HashMap<>();

    /**
     * array to store the components of each element
     */
    private final int[] ids;

    /**
     * Constructor for quick find implementation of {@link UnionFind}
     *
     * @param values {@link Set} of values. Throws {@link NullPointerException}
     *               or {@link IllegalArgumentException} if the input
     *               is null or empty respectively.
     */
    QuickFind(Set<T> values) {
        Validate.notEmpty(values);
        // creating a fixed size list
        ids = new int[values.size()];
        //Starting counter with 1
        int counter = 0;
        for (T val : values) {
            mapValues.put(val, counter);
            ids[counter] = counter;
            counter++;
        }
    }


    @Override
    public void union(T ele1, T ele2) {
        int comp1 = ids[mapValues.get(ele1)];
        int comp2 = ids[mapValues.get(ele2)];
        for (int idx = 0; idx < ids.length; idx++) {
            // Update all the components having same ID as
            // ele2 with new id of ele1
            if (ids[idx] == comp2) {
                ids[idx] = comp1;
            }
        }

    }

    @Override
    public boolean connected(T ele1, T ele2) {
        Integer ele1Id = mapValues.get(ele1);
        Integer ele2Id = mapValues.get(ele2);
        if (ele1Id == null || ele2Id == null) {
            return false;
        }
        return ids[ele1Id] == ids[ele2Id];
    }

    @Override
    public int find(T element) {
        return ids[mapValues.get(element)];
    }

    @Override
    public int count() {
        return new Long(Arrays.stream(ids)
                .distinct().count()).intValue();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Strategy : Quick Find\n")
                .append("Number of Components : ").append(count()).append('\n')
                .toString();
    }
}
