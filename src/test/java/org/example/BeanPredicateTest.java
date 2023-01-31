package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.Predicate;
import org.junit.Assert;
import org.junit.Test;

public class BeanPredicateTest {
    @Test
    public void testNotNullPredicate() {
        Book book = new Book();
        book.setTitle("Missing fortune");
        // missing NotNullPredicate in beanutils
        // Predicate titleNotNull = new BeanPredicate("title", new NotNullPredicate());
    }

    @Test
    public void testDescribe() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Person author = new Person();
        author.setName("Mike Pierce");
        Book book = new Book();
        book.setTitle("Type safety");
        book.setAuthor(author);
        Map person = BeanUtils.describe(author);
        Assert.assertEquals("Mike Pierce", person.get("name"));
        Map bookMap = BeanUtils.describe(book);
        Assert.assertEquals("Type safety", bookMap.get("title"));
        // internal composite object is not described as map, rather string
        // Assert.assertEquals(Map.class, bookMap.get("author").getClass());
    }

    @Test
    public void testBeanWrapToMap() {
        Person person = new Person();
        person.setName("Bernaded Tiples");
        person.setAge(22);
        Map beanMap = new BeanMap(person);

        Assert.assertTrue(beanMap.containsKey("name"));
        Assert.assertTrue(beanMap.containsKey("age"));
        Assert.assertFalse(beanMap.containsKey("unknowField"));

        Assert.assertEquals("Bernaded Tiples", beanMap.get("name"));
        Assert.assertEquals(22, beanMap.get("age"));
    }

    @Test
    public void testBeanWrap() throws CloneNotSupportedException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Person person = new Person();
        person.setName("Bernaded Tiples");
        person.setAge(22);
        BeanMap beanMap = new BeanMap(person);

        Assert.assertEquals(String.class, beanMap.getType("name"));
        Assert.assertEquals("public java.lang.Integer org.example.Person.getAge()", beanMap.getReadMethod("age").toString());
        Assert.assertEquals("public void org.example.Person.setAge(java.lang.Integer)", beanMap.getWriteMethod("age").toString());
        Assert.assertNull("Property doesn't exists", beanMap.getWriteMethod("medivalo"));

        int age = (Integer) beanMap.getReadMethod("age").invoke(person);
        Assert.assertEquals(22, age);
        beanMap.getWriteMethod("age").invoke(person, Integer.valueOf("44"));
        Assert.assertEquals(44, (int) person.getAge());
    }
}
