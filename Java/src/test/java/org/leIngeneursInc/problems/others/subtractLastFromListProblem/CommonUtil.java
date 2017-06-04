package org.leIngeneursInc.problems.others.subtractLastFromListProblem;

import org.apache.commons.lang3.Validate;

import java.util.function.BiFunction;

/**
 * A Utility class providing all common functions for ease of testing
 */
public class CommonUtil {

    /**
     * Private constructor for a utility class
     */
    private CommonUtil() {}

    /**
     * Generates a list of integers of a fixed size with datums ordered starting from 1 incremented by 1
     * @param size the size of the list
     * @return the generated list
     * @throws {@link IllegalArgumentException} if size if less than 0
     */
    public static Node<Integer> listIntegersOrdered(int size) {
        Validate.validState(size >= 0);
        Node<Integer> start = null;
        for (int datum = size; datum > 0; datum--) {
            start = new Node<>(datum, start);
        }
        return start;
    }

    /**
     *
     * @return a lambda for subtracting second integer argument from first integer argument
     */
    public static BiFunction<Integer, Integer, Integer> subtractionFun() {
        return (Integer f, Integer s) ->  f - s;
    }
}
