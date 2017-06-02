
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yuval.melamed
 * @param <T>
 */
public class SortedGroup<T extends Comparable<T>> {

    private ArrayList<T> collection;

    public SortedGroup() {
        this.collection = new ArrayList<>();
    }

    private enum IndexType {
        FIRST,
        POST,
        ANY;
    }

    private int sortedIndex(IndexType indexType, T item) {
        int base = 0;
        int top = collection.size() - 1;
        int mid = collection.size() / 2;
        boolean found = false;
        while (top >= base) {
            int comp = collection.get(mid).compareTo(item);
            if (comp < 0) {
                base = mid + 1;
            } else if (comp > 0) {
                top = mid - 1;
            } else {
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

    public Iterator<T> iterator() {
        return collection.iterator();
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
