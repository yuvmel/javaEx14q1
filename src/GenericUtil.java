/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

/**
 *
 * @author yuval.melamed
 */
public class GenericUtil {

    public static <T extends Comparable<T>> SortedGroup<T>
            reduce(SortedGroup<T> sGroup, T x) {
        int trim = sGroup.sortedIndex(SortedGroup.IndexType.FIRST, x);
        if (trim < 0) {
            trim = sGroup.sortedIndex(SortedGroup.IndexType.ANY, x);
        }
        return sGroup.subGroup(0, trim);
    }
}
