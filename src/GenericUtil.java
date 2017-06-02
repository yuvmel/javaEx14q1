/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

/**
 * Utility class to hold the "reduce" method as instructed specifically.
 *
 * @author yuval.melamed
 */
public class GenericUtil {

    // Returns a new SortedGroup of all items which are <x in sGroup
    public static <T extends Comparable<T>> SortedGroup<T>
            reduce(SortedGroup<T> sGroup, T x) {

        // Try to find the first item that is equal to "x", to trim from
        int trim = sGroup.sortedIndex(SortedGroup.IndexType.FIRST, x);

        // If found none, trim from the location it could have been in
        if (trim < 0) {
            trim = sGroup.sortedIndex(SortedGroup.IndexType.ANY, x);
        }

        // Return a new copy of all items from the beginning until trimmed
        return sGroup.subGroup(0, trim);
    }
}
