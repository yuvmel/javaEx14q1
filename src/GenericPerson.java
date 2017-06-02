
import java.util.Iterator;

/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */
/**
 *
 * @author yuval.melamed
 */
public class GenericPerson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortedGroup<Integer> sortedGroup = new SortedGroup<>();
        
        sortedGroup.add(32);
        sortedGroup.add(2);
        sortedGroup.add(8);
        sortedGroup.add(3);
        sortedGroup.add(17);
        sortedGroup.add(8);
        sortedGroup.add(81);
        sortedGroup.add(19);
        sortedGroup.add(21);
        sortedGroup.add(8);
        sortedGroup.add(1);
        
        System.out.println(sortedGroup);
        int removeItem = 8;
        System.out.println("sortedGroup.remove(" + removeItem + ") = " + sortedGroup.remove(removeItem));
        for (Iterator<Integer> iter = sortedGroup.iterator(); iter.hasNext();) {
            System.out.print(iter.next() + (iter.hasNext() ? ", " : "\n"));
        }
        System.out.println("GenericUtil.reduce(sortedGroup, 21) = " + GenericUtil.reduce(sortedGroup, 21));
    }
}
