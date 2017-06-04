package org.leIngeneursInc.problems.others.subtractLastFromListProblem;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Represents a node in a list comprising of datum and next pointer
 */
public class Node<T> {
    T datum;
    Node next;

    public Node(T datum) {
        this(datum, null);
    }

    public Node(T datum, Node next) {
        this.datum = datum;
        this.next = next;
    }

    @Override
    public String toString() {
        return datum +" --> " +( next == null ? "x" : next.toString());
    }

    @Override
    public int hashCode() {
        return datum.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != Node.class) {
            return false;
        }

        Node rhs = (Node) obj;
        return new EqualsBuilder()
                .append(datum, rhs.datum)
                .append(next, rhs.next)
                .build();
    }
}
