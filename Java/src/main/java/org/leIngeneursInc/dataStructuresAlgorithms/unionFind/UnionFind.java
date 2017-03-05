package org.leIngeneursInc.dataStructuresAlgorithms.unionFind;

import java.util.Set;

/**
 * an interface for Union Find.
 * Follows Strategy pattern to build required implementation.
 */
public interface UnionFind<T> {
    enum IMPL {
        QUICK_FIND,
        QUICK_UNION,
        WEIGHTED_UNION
    }

    /**
     * Union two elements
     * @param ele1 first element
     * @param ele2 second element
     */
    void union(T ele1, T ele2);

    /**
     *
     * @param ele1 first element
     * @param ele2 second element
     * @return boolean value indicating whether or not
     *              both the elements belong to same component.
     */
    boolean connected(T ele1, T ele2);

    /**
     * Find the component of the element
     * @param element the element whose component is to be found
     * @return the component of the element
     */
    int find(T element);

    /**
     *
     * @return the number of components in the data structure
     */
    int count();

    /**
     * Create a new {@link UnionFind} instance based on the IMPL
     * @param values {@link Set} of values
     * @param impl one out of the provided implementations in {@link IMPL}
     * @return instance of the specified implementation for the specified size
     */
    static<T> UnionFind<T> newUnionFind(Set<T> values, IMPL impl) {
        switch(impl) {
            case QUICK_FIND:
                return new QuickFind<T>(values);
            case QUICK_UNION:
                return null;
            case WEIGHTED_UNION:
                return null;
        }
        return null;
    }
}
