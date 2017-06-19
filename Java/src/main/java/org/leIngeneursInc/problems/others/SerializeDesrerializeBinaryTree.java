package org.leIngeneursInc.problems.others;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * Given a binary tree serialize a binar tree and then deserialize a binary tree. Assert there equivalence as well
 */
public class SerializeDesrerializeBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(3);

        System.out.println("SERIALIZED OUTPUT : " +serialize(root));
        System.out.println("IS SERIALIZATION AS EXPECTED ? " +"_5_1_0_#_#_4_#_#_2_3_#_#_#".equals(serialize(root)));
        System.out.println(areEqual(root, deserialize(serialize(root))));

        System.out.println(areEqual(null, deserialize(serialize(null))));
    }

    private static Node deserialize(String str) {
        return deserializeRec(new Iterator(str, '_'));
    }

    private static Node deserializeRec(Iterator iter) {
        Integer val = iter.next();
        if (val == null) {
            return null;
        }

        Node n = new Node(val);
        n.left = deserializeRec(iter);
        n.right = deserializeRec(iter);
        return n;
    }

    private static class Iterator {
        private final char[] arr;
        int currIdx = 0;
        private final char separator;

        private Iterator(String str, char separator) {
            Validate.validState(StringUtils.isNotBlank(str)
                    && str.charAt(0) == separator
                    && str.length() > 1);
            this.arr = str.toCharArray();
            this.separator = separator;
        }

        public boolean hasNext() {
            return currIdx < arr.length;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new IllegalStateException("no more elements");
            }
            int num = 0;
            int multiplier = 1;
            int digit;
            currIdx++;
            while(arr[currIdx] != separator) {
                digit = arr[currIdx++] - '0';
                if (digit == '#' - '0') {
                    Validate.validState(currIdx >= arr.length  || arr[currIdx] == '_');
                    return null;
                }
                Validate.validState(digit >= 0 && digit <= 9);
                num += multiplier * digit;
                multiplier *= 10;
            }
            return num;
        }
    }

    private static String serialize(Node root) {
        StringBuilder stringBuilder = new StringBuilder();
        serializeRec(root, stringBuilder);
        return stringBuilder.toString();
    }

    private static void serializeRec(Node root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append('_');
            stringBuilder.append('#');
            return;
        }
        stringBuilder.append('_');
        stringBuilder.append(root.val);
        serializeRec(root.left, stringBuilder);
        serializeRec(root.right, stringBuilder);
    }

    private static boolean areEqual(Node n1, Node n2) {
        if (n1 == n2) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        return areEqual(n1.left, n2.left) && areEqual(n1.right, n2.right);
    }

    private static class Node {
        int val;
        Node left, right;

        private Node(int val) {
            this.val= val;
        }
    }
}
