/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

import java.util.Iterator;

/**
 * Program that demonstrates usage of generic sorted group of persons
 *
 * @author yuval.melamed
 */
public class GenericPerson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortedGroup<Person> sortedGroup = new SortedGroup<>();

        sortedGroup.add(new Person("Jack", 123, 1937));
        sortedGroup.add(new Person("Marlon", 234, 1924));
        sortedGroup.add(new Person("Robert", 345, 1943));
        sortedGroup.add(new Person("Al", 456, 1940));
        sortedGroup.add(new Person("Ran", 567, 1980));
        sortedGroup.add(new Person("Dan", 678, 1980));
        sortedGroup.add(new Person("John", 789, 1970));

        System.out.println(sortedGroup);
        System.out.println("sortedGroup.remove(new Person(\"Anybody\", 123456789, 1980)) = " + sortedGroup.remove(new Person("Anybody", 123456789, 1980)));
        for (Iterator<Person> iter = sortedGroup.iterator(); iter.hasNext();) {
            System.out.print(iter.next() + (iter.hasNext() ? ", " : "\n"));
        }
        System.out.println("GenericUtil.reduce(sortedGroup, new Person(\"Anybody\", 123456789, 1980)) = " + GenericUtil.reduce(sortedGroup, new Person("Anybody", 123456789, 1980)));
    }
}
