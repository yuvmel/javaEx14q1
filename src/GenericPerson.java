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
        SortedGroup<Integer> sortedGroup = new SortedGroup<Integer>();

        sortedGroup.add(32);
        sortedGroup.add(2);
        sortedGroup.add(8);
        sortedGroup.add(3);
        sortedGroup.add(17);
        sortedGroup.add(8);
        sortedGroup.add(81);
        sortedGroup.add(19);
        sortedGroup.add(21);
        sortedGroup.add(1);

        System.out.println(sortedGroup);
    }

    public static <T extends Comparable<T>> void f(T x) {
        System.out.println("x=" + x);
    }

}
