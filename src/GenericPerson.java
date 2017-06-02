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

        // Create new collection
        SortedGroup<Person> sortedGroup = new SortedGroup<>();

        // Populate the collection
        sortedGroup.add(new Person("Jack", 123, 1937));
        sortedGroup.add(new Person("Marlon", 234, 1924));
        sortedGroup.add(new Person("Robert", 345, 1943));
        sortedGroup.add(new Person("Al", 456, 1940));
        sortedGroup.add(new Person("Ran", 567, 1980));
        sortedGroup.add(new Person("Dan", 678, 1980));
        sortedGroup.add(new Person("Baby", 789, 2017));

        System.out.println("Persons: name #idNum @birthYear");
        System.out.println(sortedGroup);
        System.out.println();

        // Remove person(s)
        int year = 1980;
        Person remover = new Person("Remover", 0, year);
        int count = sortedGroup.remove(remover);

        System.out.printf(
                "After removing %d persons with the same birth year as: %s%n",
                count, remover);
        System.out.println(sortedGroup);
        System.out.println();

        Person reducer = new Person("Reducer", 0, 2000);
        System.out.printf("Reduced to persons born before: %s%n%s%n%n",
                reducer, GenericUtil.reduce(sortedGroup, reducer));

        System.out.println("After removal, before reduction, by iteration:");
        for (Iterator<Person> iter = sortedGroup.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
}
