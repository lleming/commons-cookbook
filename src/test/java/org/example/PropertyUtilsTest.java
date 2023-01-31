package org.example;

import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;

public class PropertyUtilsTest {
    @Test
    public void testGetSimpleProperty()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Person person = new Person("Alex", "Green");
        Assert.assertEquals("Alex", (String) PropertyUtils.getSimpleProperty(person, "name"));
        Assert.assertEquals("Green", (String) PropertyUtils.getSimpleProperty(person, "favoriteColour"));
    }

    @Test
    public void testThrowNoSuchMethodException() throws IllegalAccessException, InvocationTargetException {
        Person person = new Person();
        try {
            PropertyUtils.getSimpleProperty(person, "unknownProperty");
            Assert.fail("Expected " + NoSuchMethodException.class + " thrown");
        } catch (NoSuchMethodException e) {

        }
    }

    // @Test
    public void testThrowsIllegalAccessException() throws InvocationTargetException, NoSuchMethodException {
        Person person = new Person();
        try {
            PropertyUtils.getSimpleProperty(person, "nameColourfull");
            fail("Expected " + IllegalAccessException.class + " to be thrown");
        } catch (IllegalAccessException e) {

        }
    }

    @Test
    public void testGetNestedProperty()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Person author = new Person("Indigo");
        Book book = new Book("Best my seller", author);
        Assert.assertEquals("Indigo", (String) PropertyUtils.getNestedProperty(book, "author.name"));

    }

    @Test
    public void testGetIndexedProperty()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        Chapter first = new Chapter("Introduction", 1);
        Chapter second = new Chapter("Meeting in the see", 2);
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(first);
        chapters.add(second);
        book.setChapters(chapters);
        Assert.assertEquals("Meeting in the see",
                ((Chapter) PropertyUtils.getIndexedProperty(book, "chapters[1]")).getName());
    }

    @Test
    public void testGetIndexedPropertyAsIndex()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        Chapter first = new Chapter("Introduction", 1);
        Chapter second = new Chapter("Meeting in the see", 2);
        List<Chapter> chapters = new ArrayList<>();
        chapters.add(first);
        chapters.add(second);
        book.setChapters(chapters);
        Assert.assertEquals("Introduction",
                ((Chapter) PropertyUtils.getIndexedProperty(book, "chapters", 0)).getName());
    }

    @Test
    public void testGetMappedProperty()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Room diningRoom = new Room();
        diningRoom.setArea(20);
        diningRoom.setCarpeted(false);
        diningRoom.setFurnitured(true);
        Map rooms = new HashMap();
        rooms.put("Dining Room", diningRoom);
        Apartment apartment = new Apartment();
        apartment.setRooms(rooms);
        Assert.assertSame(diningRoom, PropertyUtils.getMappedProperty(apartment, "rooms(Dining Room)"));
    }

    @Test
    public void testGetMappedPropertyAsKey()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Room diningRoom = new Room();
        diningRoom.setArea(20);
        diningRoom.setCarpeted(false);
        diningRoom.setFurnitured(true);
        Map rooms = new HashMap();
        rooms.put("Dining Room", diningRoom);
        Apartment apartment = new Apartment();
        apartment.setRooms(rooms);
        Assert.assertSame(diningRoom, PropertyUtils.getMappedProperty(apartment, "rooms", "Dining Room"));
    }

    @Test
    public void getGetProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        City richmond = new City();
        richmond.setName("Richmond");
        richmond.setPopulation(5_000_000L);

        Map cities = new HashMap<>();
        cities.put("richmond", richmond);

        Region midAtlantic = new Region();
        midAtlantic.setName("Mid-Atlantic");
        midAtlantic.setCities(cities);

        List<Region> regions = new ArrayList<>();
        regions.add(midAtlantic);

        Country country = new Country();
        country.setName("United States");
        country.setRegions(regions);

        Assert.assertEquals(5_000_000L, PropertyUtils.getProperty(country, "regions[0].cities(richmond).population"));

    }

    @Test
    public void testGetPropertyType() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        Class<?> type = PropertyUtils.getPropertyType(book, "author");
        Assert.assertSame(Person.class, type);
    }

    @Test
    public void testGetPropertyTypeComplex()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Chapter chapter = new Chapter();
        chapter.setName("Chapter 3 Bean Utils");
        chapter.setNumber(3);

        List chapters = new ArrayList();
        chapters.add(chapter);

        Person author = new Person();
        author.setName("Dude");
        Book book = new Book();
        book.setTitle("Jakarta common cookbook");
        book.setAuthor(author);
        book.setChapters(chapters);

        Class<?> type = PropertyUtils.getPropertyType(book, "chapters[0].name");
        Assert.assertSame(String.class, type);
    }

    @Test
    public void testBeanComparator() {
        Country india = new Country();
        india.setName("India");

        Country shrilanka = new Country();
        shrilanka.setName("Shri-Lanka");

        Country canada = new Country();
        canada.setName("Canada");

        List countries = new ArrayList<>();
        countries.add(india);
        countries.add(shrilanka);
        countries.add(canada);

        Collections.sort(countries, new BeanComparator("name"));
        List expected =new ArrayList();
        expected.add(canada);
        expected.add(india);
        expected.add(shrilanka);
        Assert.assertEquals(expected, countries);
    }

    @Test
    public void testByEngineEffeciency() {
        Engine engine1 = new Engine();
        engine1.setMilesGalon(8);
        engine1.setPercentElectric(25);
        Engine engine2 = new Engine();
        engine2.setMilesGalon(26);
        engine2.setPercentElectric(98);
        Engine engine3 = new Engine();
        engine3.setMilesGalon(1);
        engine3.setPercentElectric(0);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setModel("Aveo RX");
        vehicle1.setMake("Mazda");
        vehicle1.setEngine(engine1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModel("Izio");
        vehicle2.setMake("Toyota");
        vehicle2.setEngine(engine2);
        Vehicle vehicle3 = new Vehicle();
        vehicle3.setModel("Gazeliano");
        vehicle3.setMake("Shevrolle");
        vehicle3.setEngine(engine3);

        List vehicles = new ArrayList<>();
        vehicles.add(vehicle2);
        vehicles.add(vehicle1);
        vehicles.add(vehicle3);

        Comparator comparator = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Engine engine1 = (Engine) o1;
                Engine engine2 = (Engine) o2;
                Integer engine1Use = engine1.getMilesGalon() * engine1.getPercentElectric();
                Integer engine2Use = engine2.getMilesGalon() * engine2.getPercentElectric();
                return engine1Use.compareTo(engine2Use);
            }

        };

        Comparator vehicleComparator = new BeanComparator("engine", comparator);
        Collections.sort(vehicles, vehicleComparator);

        List expected = Arrays.asList(vehicle3, vehicle1, vehicle2);
        Assert.assertEquals(expected, vehicles);
    }

    @Test
    public void testCopyBean() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        book.setTitle("Tuple structure at runtime");
        Book destinationBook = new Book();
        PropertyUtils.copyProperties(destinationBook, book);
        Assert.assertEquals("Tuple structure at runtime", destinationBook.getTitle());
    }

    @Test
    public void testCopyBeanNested() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        book.setTitle("Modern java");
        Person author = new Person();
        author.setName("Artur Clark");
        book.setAuthor(author);
        Book destinationBook = new Book();
        PropertyUtils.copyProperties(destinationBook, book);
        Assert.assertEquals("Modern java", destinationBook.getTitle());
        Assert.assertSame(author, destinationBook.getAuthor());
    }

    @Test
    public void testCopyMapIntoBean() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map props = new HashMap<>();
        props.put("title", "Elixir in action");
        // props.put("author", "Frederiz Gonzalo");
        Book book = new Book();
        PropertyUtils.copyProperties(book, props);
        Assert.assertEquals("Elixir in action", book.getTitle());
    }

    @Test
    public void testSetProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        Person author = new Person();
        Chapter chapter = new Chapter();
        book.setChapters(Arrays.asList(chapter));
        PropertyUtils.setProperty(book, "title", "Single iland");
        PropertyUtils.setProperty(book, "author", author);
        PropertyUtils.setProperty(book, "author.name", "Richard Morris");
        PropertyUtils.setProperty(book, "chapters[0].name", "Once upon a time");
        Assert.assertEquals("Single iland", book.getTitle());
        Assert.assertEquals("Richard Morris", book.getAuthor().getName());
        Assert.assertEquals("Once upon a time", book.getChapters().get(0).getName());
    }

    @Test
    public void testPropertyIsReadable() {
        Book book = new Book();
        Chapter chapter = new Chapter();
        book.setChapters(Arrays.asList(chapter));
        Assert.assertFalse(PropertyUtils.isReadable(book, "Blah"));
        Assert.assertTrue(PropertyUtils.isWriteable(book, "author"));

        Assert.assertTrue(PropertyUtils.isReadable(book, "chapters[0].number"));
    }
}
