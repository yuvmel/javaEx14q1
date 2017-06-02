/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sorted group of items with possible duplicates (as instructed)
 *
 * @param <T> Type of items in the sorted group collection
 * @author yuval.melamed
 */
public class SortedGroup<T extends Comparable<T>> {

    private final ArrayList<T> collection;

    public SortedGroup() {
        this.collection = new ArrayList<>();
    }

    // Constructor than can create a new group from an existing collection
    public SortedGroup(List<T> existingCollection) {
        this.collection = new ArrayList<>(existingCollection);
    }

    // Binary search for index of an item - type ANY means return location even if not there (otherwise -1)
    public int sortedIndex(IndexType indexType, T item) {
        int base = 0;
        int top = collection.size() - 1;
        int mid = collection.size() / 2;
        boolean found = false;
        while (top >= base) {
            // We use "equals" only because it was instructed. Otherwise "compareTo" below would be enough
            if (collection.get(mid).equals(item)) {
                found = true;
                switch (indexType) {
                    case FIRST:
                        top = mid - 1;      // search bottom half
                        break;
                    case POST:
                        base = mid + 1;     // search upper half
                        break;
                    case ANY:
                        return mid;         // found
                }
            } else if (collection.get(mid).compareTo(item) < 0) {
                base = mid + 1;
            } else {
                top = mid - 1;
            }
            mid = (base + top + 1) / 2;     // index in the middle
        }

        // Return -1 if not found, unless requested index of type ANY (a "would be" location)
        return found || indexType == IndexType.ANY ? mid : -1;
    }

    // Add an item in a sorted location, allow duplicates, as instructed
    public void add(T item) {
        collection.add(sortedIndex(IndexType.ANY, item), item);
    }

    // Remove all items that are equal to a given item & return the count
    public int remove(T item) {
        int first = sortedIndex(IndexType.FIRST, item);

        // If nothing was found, just return 0
        if (first < 0) {
            return 0;
        }

        // Find the first index which is not equal to item (optionally after last)
        int post = sortedIndex(IndexType.POST, item);

        // Remove the entire range of similar items that were found
        collection.subList(first, post).clear();

        // Return the count of removed items
        return post - first;
    }

    // Return a new group from a given range
    public SortedGroup<T> subGroup(int first, int post) {
        return new SortedGroup<>(collection.subList(first, post));
    }

    // Return an iterator to the group
    public Iterator<T> iterator() {
        return collection.iterator();
    }

    @Override
    public String toString() {
        return collection.toString();
    }

    // These values are to be used in the binary search function
    public enum IndexType {
        FIRST,
        POST,
        ANY;
    }
}
