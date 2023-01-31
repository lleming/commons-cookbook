package org.example;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.NullComparator;
import org.example.Book;
import org.example.ComparedPerson;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ChainComparatorTest {
    @Test
    public void testChainComparator() {
        ComparedPerson person0 = new ComparedPerson();
        person0.setFirstName("Alex");
        person0.setLastName("Rozamund");
        person0.setAge(22);
        ComparedPerson person1 = new ComparedPerson();
        person1.setFirstName("Alex");
        person1.setLastName("Alvares");
        person1.setAge(17);
        ComparedPerson person2 = new ComparedPerson();
        person2.setFirstName("Alex");
        person2.setLastName("Alvares");
        person2.setAge(66);

        ComparedPerson[] persons = new ComparedPerson[] { person0, person1, person2 };
        ComparatorChain comparatorChain = new ComparatorChain();
        comparatorChain.addComparator(new BeanComparator("firstName"));
        comparatorChain.addComparator(new BeanComparator("lastName"));
        comparatorChain.addComparator(new BeanComparator("age"), true);
        Arrays.sort(persons, comparatorChain);
        ComparedPerson[] expected = new ComparedPerson[] {
                Person("Alex", "Alvares", 66),
                Person("Alex", "Alvares", 17),
                Person("Alex", "Rozamund", 22)
        };
        Assert.assertTrue(Arrays.equals(expected, persons));
    }

    @Test
    public void testNullComparator() {
        Book[] books = new Book[] { new Book(), null, new Book() };
        //Arrays.sort(books, new NullComparator());
        //Assert.assertNull(books[2]);
    }

    static ComparedPerson Person(String firstName, String lastName, int age) {
        ComparedPerson person = new ComparedPerson();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        return person;
    }

}