
import java.util.ArrayList;

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

    private int locationFor(T item) {
        int base = 0;
        int top = collection.size() - 1;
        int mid = collection.size() / 2;
        while (top >= base) {
            int comp = collection.get(mid).compareTo(item);
            if (comp == 0) {
                break;
            }
            if (comp > 0) {
                top = mid - 1;
            } else {
                base = mid + 1;
            }
            mid = (base + top + 1) / 2;
        }
        return mid;
    }

    public void add(T item) {
        collection.add(locationFor(item), item);
    }

    public int remove(T item) {
        return 0;
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
