/*
 * Maman 14 course 20554 question 2 by Yuval Melamed, ID 035870864
 */

/**
 * Person details - birth year denotes equality, per instructions
 *
 * @author yuval.melamed
 */
public class Person implements Comparable<Person> {

    private String name;
    private int idNum;
    private int birthYear;

    public Person(String name, int idNum, int birthYear) {
        this.name = name;
        this.idNum = idNum;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getIdNum() {
        return idNum;
    }

    public int getBirthYear() {
        return birthYear;
    }

    // Auto-generated by NetBeans
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.birthYear;
        return hash;
    }

    // Auto-generated by NetBeans
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.birthYear != other.birthYear) {
            return false;
        }
        return true;
    }

    // Compare persons by birth year
    @Override
    public int compareTo(Person person) {
        return getBirthYear() - person.getBirthYear();
    }

    // Compact string represntation for readability in lists
    @Override
    public String toString() {
        return String.format("%s #%d @%d",
                getName(), getIdNum(), getBirthYear());
    }
}
