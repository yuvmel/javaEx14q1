/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Sorted group of items with possible duplicates (as instructed)
 *
 * @author yuval.melamed
 * @param <T> Type of items in the sorted group collection
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

    // These values are to be used in the binary search function below
    public enum IndexType {
        FIRST,
        POST,
        ANY;
    }

    // TODO: binary search desc !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public int sortedIndex(IndexType indexType, T item) {
        int base = 0;
        int top = collection.size() - 1;
        int mid = collection.size() / 2;
        boolean found = false;
        while (top >= base) {
            if (collection.get(mid).equals(item)) {
                found = true;
                switch (indexType) {
                    case FIRST:
                        top = mid - 1;
                        break;
                    case POST:
                        base = mid + 1;
                        break;
                    case ANY:
                        return mid;
                }
            } else if (collection.get(mid).compareTo(item) < 0) {
                base = mid + 1;
            } else {
                top = mid - 1;
            }
            mid = (base + top + 1) / 2;
        }
        return found || indexType == IndexType.ANY ? mid : -1;
    }

    public void add(T item) {
        collection.add(sortedIndex(IndexType.ANY, item), item);
    }

    public int remove(T item) {
        int first = sortedIndex(IndexType.FIRST, item);
        if (first < 0) {
            return 0;
        }
        int post = sortedIndex(IndexType.POST, item);
        collection.subList(first, post).clear();
        return post - first;
    }

    public SortedGroup<T> subGroup(int first, int post) {
        return new SortedGroup<>(collection.subList(first, post));
    }

    public Iterator<T> iterator() {
        return collection.iterator();
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
