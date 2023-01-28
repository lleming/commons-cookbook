package org.example;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;

public class PoliticalCandidateTest {

    //@Test
    public void testToString() {
        String expected = "org.example.PoliticalCandidate[lastName=[null],firstName=[null],dateOfBirth=[null],moneyRaised=[null],hostState=[null]]";
        PoliticalCandidate candidate = new PoliticalCandidate();
        Assert.assertEquals("Wront toString implementation", expected, candidate.toString());
    }

    //@Test
    public void testToStringFilled() {
        PoliticalCandidate candidate = new PoliticalCandidate();
        Assert.assertEquals("", candidate.toString());
    }

    @Test
    public void testEmptyStatesEquals() {
        PoliticalCandidate.State first = new PoliticalCandidate.State();
        PoliticalCandidate.State second = new PoliticalCandidate.State();
        Assert.assertEquals("Must match", first, second);
    }

    @Test
    public void testStateEquals() {
        PoliticalCandidate.State first = new PoliticalCandidate.State();
        first.setName("Oklahoma");
        first.setPopulation(27_567);
        PoliticalCandidate.State second = new PoliticalCandidate.State();
        second.setName("Oklahoma");
        second.setPopulation(27_567);
        Assert.assertEquals("Must match", first, second);
    }

    @Test
    public void testStateInEquals() {
        PoliticalCandidate.State first = new PoliticalCandidate.State();
        first.setName("Alabama");
        first.setPopulation(96_301);
        PoliticalCandidate.State second = new PoliticalCandidate.State();
        second.setName("Oklahoma");
        second.setPopulation(27_567);
        Assert.assertFalse("Must match", first.equals(second));
    }

    @Test
    public void testHashCode() {
        PoliticalCandidate.State state = new PoliticalCandidate.State();
        state.setName("Alabama");
        state.setPopulation(96_301);
        assertEquals("Must match", 1550310801, state.hashCode());
    }

    @Test
    public void testHashCodeIsNotChanged() {
        PoliticalCandidate.State state = new PoliticalCandidate.State();
        state.setName("Alabama");
        state.setPopulation(96_301);
        int first = state.hashCode();
        int second = state.hashCode();
        assertEquals("Must match", first, second);
    }

    @Test
    public void testHashCodeIsChanged() {
        PoliticalCandidate.State state = new PoliticalCandidate.State();
        state.setName("Alabama");
        state.setPopulation(96_301);
        int first = state.hashCode();
        state.setPopulation(456_674L);
        int second = state.hashCode();
        Assert.assertTrue("Must match", first != second);
    }

    @Test
    public void testArrayEquals(){
        int[] array1 = new int[]{1, 3, 7, 9, 4, 5, 8};
        int[] array2 = new int[]{1, 3, 7, 9, 4, 5, 8};
        int[] array3 = new int[]{1, 3, 5, 9, 4, 7, 8};
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(array1, array2);
        Assert.assertTrue("Must equals", builder.isEquals());

        builder = new EqualsBuilder();
        builder.append(array1, array3);
        Assert.assertFalse("Must not equal", builder.isEquals());
    }

    @Test
    public void testCompareTo() {

    }
}